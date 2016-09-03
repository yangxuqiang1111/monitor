package com.yangxq.monitor.common.utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtil {


    /**
     * 时间格式化工具(线程局部变量)
     */
    private static ThreadLocal<SimpleDateFormat> DATE_FORMAT = new
            ThreadLocal<SimpleDateFormat>() {
                @Override
                protected SimpleDateFormat initialValue() {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    return sdf;
                }
            };

    private static ThreadLocal<DateTimeFormatter> dtf = new ThreadLocal<DateTimeFormatter>() {
        @Override
        protected DateTimeFormatter initialValue() {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return dateTimeFormatter;
        }
    };

    /**
     * 获取当前时间(秒数格式)
     *
     * @return
     */
    public static int getNowSecond() {
        return (int) (System.currentTimeMillis() / 1000);
    }


    /**
     * 获取当前的格式化时间
     *
     * @return
     */
    public static String getFormatTime() {
        return DATE_FORMAT.get().format(new Date());
    }

//    /**
//     * 获取yyyy-MM-dd HH:mm:ss 格式的日期
//     *
//     * @return
//     */
//    public static String getFormatDateTime() {
//        LocalDateTime now = LocalDateTime.now();
//        return now.format(dtf.get());
//    }

    /**
     * 获取当前的去掉秒的时间戳
     *
     * @return
     */
    public static int getNowTimeStampRmS() {
        int nowSecond = getNowSecond();
        Instant instant = Instant.ofEpochSecond(nowSecond);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return nowSecond - localDateTime.getSecond();
    }


//    /**
//     * 获取格式为yyyyMMddHHmm 的日期
//     *
//     * @param nowMinute
//     * @return
//     */
//    public static Long getFormatTime(int nowMinute) {
//        Instant instant = Instant.ofEpochSecond(nowMinute);
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//        return Long.parseLong(localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
//    }

//    /**
//     * 获取格式为yyyy-MM-dd HH:mm 的日期
//     *
//     * @param nowMinute
//     * @return
//     */
//    public static String getFormDateString(int nowMinute) {
//        Instant instant = Instant.ofEpochSecond(nowMinute);
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd/HH/mm"));
//    }

    /**
     * 获取当前时间(毫秒数)
     *
     * @return
     */
    public static long getNowTime() {
        return System.currentTimeMillis();
    }

    /**
     * 获取凌晨0:00 的时间戳
     *
     * @return
     */
    public static int getTodayBegTimeStamp() {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = localDate.atTime(0, 0, 0);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return (int) zonedDateTime.toEpochSecond();
    }

    /**
     * 获取今天8点的时间戳
     *
     * @return
     */
    public static int getTodayEightOclock() {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = localDate.atTime(8, 0, 0);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return (int) zonedDateTime.toEpochSecond();
    }


    /**
     * 获取格式为 yyyy-MM-dd的日期
     *
     * @return
     */
    public static String getFormatDateStr() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 获取一天23:59:59 的时间戳
     *
     * @param dateStr
     * @return
     */
    public static int getDayEndTimeStamp(String dateStr) {
        LocalDateTime localDateTime = LocalDate.parse(dateStr).atTime(23, 59, 59);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return (int) zonedDateTime.toEpochSecond();
    }


    /**
     * 获取一天 0:0:0 的时间戳
     *
     * @param dateStr
     * @return
     */
    public static int getDayBegTimeStamp(String dateStr) {
        LocalDateTime localDateTime = LocalDate.parse(dateStr).atTime(0, 0, 0);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return (int) zonedDateTime.toEpochSecond();
    }

    /**
     * 获取一天 8;00 的时间戳
     *
     * @param dateStr
     * @return
     */
    public static int getDayEightOclock(String dateStr) {
        LocalDateTime localDateTime = LocalDate.parse(dateStr).atTime(8, 0, 0);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return (int) zonedDateTime.toEpochSecond();
    }

    public static void main(String[] args) {
        long endTime = getTodayBegTimeStamp();
        System.out.println(endTime);
    }


}
