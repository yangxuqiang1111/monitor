package com.yangxq.monitor.connector.netty.udp;

import com.yangxq.monitor.connector.netty.IBaseServer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by Yangxq on 2016/8/26.
 * udp 调用量服务
 */
@Component
public class UDPTransferServer implements IBaseServer,ApplicationContextAware {
    private Logger log = Logger.getLogger(UDPTransferServer.class);
    private EventLoopGroup group = null;


    private ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public void start(final int port) {
        group = new NioEventLoopGroup();
        Bootstrap b=new Bootstrap();
        b.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST,true)
                .handler(applicationContext.getBean(UDPHandler.class));

        b.bind(port).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    log.info("UDPTransferServer 启动成功, listen on [" + port + "]");
                } else {
                    log.info("UDPTransferServer 启动失败, listen on [" + port + "]");
                }
            }
        });

    }

    public void stop() {
        group.shutdownGracefully();
    }
}
