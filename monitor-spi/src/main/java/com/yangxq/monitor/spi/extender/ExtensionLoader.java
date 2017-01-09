package com.yangxq.monitor.spi.extender;


import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.utils.ConcurrentHashSet;
import com.yangxq.monitor.spi.annotations.Adaptive;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/**
 * Created by Yangxq on 2017/1/9.
 */
public class ExtensionLoader<T> {

    private Class<?> type;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(ExtensionLoader.class);

    private static final ConcurrentHashMap<Class<?>, ExtensionLoader<?>> EXTENSION_LOADERS = new ConcurrentHashMap<>();

    private final Holder<Map<String, Class<?>>> holder = new Holder<>();

    private final ConcurrentHashMap<String, Holder<Object>> cacheInstances = new ConcurrentHashMap<>(); // 缓存name 对应的对象

    private final Holder<Map<String, Class<?>>> cachedClasses = new Holder<>();

    private final ConcurrentHashMap<Class<?>, Object> EXTENSION_INSTANCES = new ConcurrentHashMap<>();

    private static final Pattern NAME_SEPARATOR = Pattern.compile("\\s*[,]+\\s*");

    private final Map<String, Activate> cachedActivates = new ConcurrentHashMap<String, Activate>();

    private final ConcurrentMap<Class<?>, String> cachedNames = new ConcurrentHashMap<Class<?>, String>();

    private volatile Class<?> cachedAdaptiveClass = null;

    private Set<Class<?>> cachedWrapperClasses;

    private final String SERVICES_DIRECTORY = "META-INF/services/";

    private ExtensionLoader(Class<?> type) {
        this.type = type;
    }

    public static <T> ExtensionLoader<T> getExtensionLoader(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("extension type==null");
        }
        if (!type.isInterface()) {
            throw new IllegalArgumentException("extension type:" + type + " must be interface");
        }
        ExtensionLoader<T> extensionLoader = (ExtensionLoader<T>) EXTENSION_LOADERS.get(type);

        if (extensionLoader == null) {
            EXTENSION_LOADERS.putIfAbsent(type, new ExtensionLoader<>(type));
            extensionLoader = (ExtensionLoader<T>) EXTENSION_LOADERS.get(type);
        }
        return extensionLoader;
    }

    public T getExtension(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("extension name == null");
        }

        Holder<Object> holder = cacheInstances.get(name);
        if (holder == null) {
            cacheInstances.putIfAbsent(name, new Holder<>());
            holder = cacheInstances.get(name);
        }

        Object instance = holder.get();
        if (instance == null) {
            instance = createExtension(name);
            holder.set(instance);
        }


        return (T) instance;
    }

    /**
     * 创建name对应的实例
     *
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    private T createExtension(String name) {
        Class<?> clazz = getExtensionClasses().get(name);
        if (clazz == null) {
            throw new IllegalArgumentException("name " + name + " class == null");
        }
        T instance = (T) EXTENSION_INSTANCES.get(clazz);
        if (instance == null) {
            try {
                EXTENSION_INSTANCES.putIfAbsent(clazz, (T) clazz.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            instance = (T) EXTENSION_INSTANCES.get(clazz);
        }
        return instance;

    }

    /**
     * 获取扩展classes
     *
     * @return
     */
    private Map<String, Class<?>> getExtensionClasses() {
        Map<String, Class<?>> classes = cachedClasses.get();
        if (classes == null) {
            classes = loadExtensionClasses();
            cachedClasses.set(classes);
        }
        return classes;
    }

    private Map<String, Class<?>> loadExtensionClasses() {
        Map<String, Class<?>> extensionClasses = new HashMap<>();
        loadFile(extensionClasses, SERVICES_DIRECTORY);
        return extensionClasses;
    }

    private void loadFile(Map<String, Class<?>> extensionClasses, String dir) {
        String fileName = dir + type.getName();
        try {
            ClassLoader classLoader = ExtensionLoader.class.getClassLoader();
            Enumeration<URL> urls;
            if (classLoader != null) {
                urls = classLoader.getResources(fileName);
            } else {
                urls = ClassLoader.getSystemResources(fileName);
            }
            if (urls != null) {
                while (urls.hasMoreElements()) {
                    URL url = urls.nextElement();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("utf-8")));
                    String line = null;
                    try {
                        while ((line = reader.readLine()) != null) {
                            int index = line.indexOf("=");
                            String name = null;
                            if (index > 0) {
                                name = line.substring(0, index).trim();
                                line = line.substring(index + 1).trim();
                            }

                            if (line.length() > 0) {
                                Class<?> clazz = Class.forName(line, true, classLoader);
                                if (!type.isAssignableFrom(clazz)) {
                                    throw new IllegalStateException("Error when load extension class(interface: " + type + "," +
                                            "class line: " + clazz.getName() + ", " +
                                            "class: " + clazz.getName() + " is not subtype of interface ");
                                }

                                if (clazz.isAnnotationPresent(Adaptive.class)) {
                                    if (cachedAdaptiveClass == null) {
                                        cachedAdaptiveClass = clazz;
                                    } else if (!cachedAdaptiveClass.equals(clazz)) {
                                        throw new IllegalStateException("More than 1 adaptive class found: "
                                                + cachedAdaptiveClass.getClass().getName()
                                                + ", " + clazz.getClass().getName());
                                    }
                                } else {
                                    try {
                                        clazz.getConstructor(type);
                                        Set<Class<?>> wrappers = cachedWrapperClasses;
                                        if (wrappers == null) {
                                            cachedWrapperClasses = new ConcurrentHashSet<>();
                                            wrappers = cachedWrapperClasses;
                                        }
                                        wrappers.add(clazz);
                                    } catch (NoSuchMethodException e) {
                                        clazz.getConstructor();
                                        if (name == null || name.length() == 0) {
                                            if (clazz.getSimpleName().length() > type.getSimpleName().length() &&
                                                    clazz.getSimpleName().endsWith(type.getSimpleName())) {
                                                name = clazz.getSimpleName().substring(0, clazz.getSimpleName().length() - type.getSimpleName().length()).toLowerCase();
                                            } else {
                                                throw new IllegalStateException("No such extension name for the class " + clazz.getName() + " in the config " + url);
                                            }
                                        }
                                        String[] names = NAME_SEPARATOR.split(name);
                                        if (names != null && names.length > 0) {
                                            Activate activate = clazz.getAnnotation(Activate.class);
                                            if (activate != null) {
                                                cachedActivates.putIfAbsent(names[0], activate);
                                            }

                                            for (String n : names) {
                                                if (!cachedNames.containsKey(clazz)) {
                                                    cachedNames.putIfAbsent(clazz, n);
                                                }
                                                Class<?> c = extensionClasses.get(n);
                                                if (c == null) {
                                                    extensionClasses.put(n, clazz);
                                                } else if (c != clazz) {
                                                    throw new IllegalStateException("Duplicate extension " + type.getName() + " name " + n + " on " + c.getName() + " and " + clazz.getName());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable t) {
                        IllegalStateException e = new IllegalStateException("Failed to load extension class(interface: " + type + ", class line: " + ") in " + url + ", cause: " + t.getMessage(), t);
                    } finally {
                        reader.close();
                    }
                }
            }
        } catch (Throwable e) {
            logger.error("Exception when load extension class(interface: " +
                    type + ", description file: " + fileName + ").", e);
        }

    }


}
