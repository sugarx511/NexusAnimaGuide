package cn.tang.common.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 日期时间工具类
 *
 * @author tz
 * @date 2025-08-06
 */
public class XyDateUtil {

    /**
     * 默认日期时间格式
     */
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);

    /**
     * 默认日期格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);

    /**
     * 默认时间格式
     */
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    public static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT);

    /**
     * 默认年月
     */
    public static final String DEFAULT_YEAR_MONTH = "yyyy-MM";

    public static final DateTimeFormatter DEFAULT_YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_YEAR_MONTH);

    /**
     * 解析日期时间
     *
     * @param dateTime 日期时间 yyyy-MM-dd HH:mm:ss
     * @return {@link LocalDateTime }
     */
    public static LocalDateTime parseDateTime(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, DEFAULT_DATETIME_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析日期时间
     *
     * @param dateTime  日期时间
     * @param formatStr 格式化str
     * @return {@link LocalDateTime }
     */
    public static LocalDateTime parseDateTime(String dateTime, String formatStr) {
        try {
            return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(formatStr));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析日期
     *
     * @param date 日期 yyyy-MM-dd
     * @return {@link LocalDate }
     */
    public static LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DEFAULT_DATE_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析日期
     *
     * @param date      日期
     * @param formatStr 格式化str
     * @return {@link LocalDate }
     */
    public static LocalDate parseDate(String date, String formatStr) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(formatStr));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析时间
     *
     * @param time 时间 HH:mm:ss
     * @return {@link LocalTime }
     */
    public static LocalTime parseTime(String time) {
        try {
            return LocalTime.parse(time, DEFAULT_TIME_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析时间
     *
     * @param time      时间
     * @param formatStr 格式化str
     * @return {@link LocalTime }
     */
    public static LocalTime parseTime(String time, String formatStr) {
        try {
            return LocalTime.parse(time, DateTimeFormatter.ofPattern(formatStr));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析日期时间并转化成Date
     *
     * @param dateTime 日期时间 yyyy-MM-dd HH:mm:ss
     * @return {@link Date }
     */
    public static Date parseDateTimeAsDate(String dateTime) {
        try {
            LocalDateTime localDateTime = parseDateTime(dateTime);
            return localDateTime == null ? null : asDate(localDateTime);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析日期时间并转化成Date
     *
     * @param dateTime  日期时间
     * @param formatStr 格式化str
     * @return {@link LocalDateTime }
     */
    public static Date parseDateTimeAsDate(String dateTime, String formatStr) {
        try {
            LocalDateTime localDateTime = parseDateTime(dateTime, formatStr);
            return localDateTime == null ? null : asDate(localDateTime);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析日期并转化成Date
     *
     * @param date 日期 yyyy-MM-dd
     * @return {@link LocalDate }
     */
    public static Date parseDateAsDate(String date) {
        try {
            LocalDate localDate = parseDate(date);
            return localDate == null ? null : asDate(localDate);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析日期并转化成Date
     *
     * @param date      日期
     * @param formatStr 格式化str
     * @return {@link Date }
     */
    public static Date parseDateAsDate(String date, String formatStr) {
        try {
            LocalDate localDate = parseDate(date, formatStr);
            return localDate == null ? null : asDate(localDate);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将LocalDateTime转换成Date
     *
     * @param localDateTime 本地日期时间
     * @return {@link Date }
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将LocalDate转换成Date
     *
     * @param localDate 本地日期
     * @return {@link Date }
     */
    public static Date asDate(LocalDate localDate) {
        return asDate(localDate.atStartOfDay());
    }

    /**
     * 将Date转换成LocalDate
     *
     * @param date 日期
     * @return {@link LocalDate }
     */
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 将Date转换成LocalDateTime
     *
     * @param date 日期
     * @return {@link LocalDateTime }
     */
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 将Date转换成LocalTime
     *
     * @param date 日期
     * @return {@link LocalTime }
     */
    public static LocalTime asLocalTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalTime();
    }

    /**
     * 格式化日期时间
     *
     * @param localDateTime 日期时间
     * @return {@link String }
     */
    public static String formatDateTime(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(DEFAULT_DATETIME_FORMATTER);
    }

    /**
     * 格式化日期时间
     *
     * @param date 日期时间
     * @return {@link String }
     */
    public static String formatDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return formatDateTime(asLocalDateTime(date));
    }

    /**
     * 格式化日期时间
     *
     * @param localDateTime 日期时间
     * @param formatStr     格式化str
     * @return {@link String }
     */
    public static String formatDateTime(LocalDateTime localDateTime, String formatStr) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(formatStr));
    }

    /**
     * 格式化日期时间
     *
     * @param date      日期时间
     * @param formatStr 格式化str
     * @return {@link String }
     */
    public static String formatDateTime(Date date, String formatStr) {
        if (date == null) {
            return null;
        }
        return asLocalDateTime(date).format(DateTimeFormatter.ofPattern(formatStr));
    }

    /**
     * 格式化日期
     *
     * @param localDate 日期
     * @return {@link String }
     */
    public static String formatDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return localDate.format(DEFAULT_DATE_FORMATTER);
    }

    /**
     * 格式化日期
     *
     * @param date 日期
     * @return {@link String }
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return formatDate(asLocalDate(date));
    }

    /**
     * 格式化日期
     *
     * @param localDate 日期
     * @param formatStr 格式化str
     * @return {@link String }
     */
    public static String formatDate(LocalDate localDate, String formatStr) {
        if (localDate == null) {
            return null;
        }
        return localDate.format(DateTimeFormatter.ofPattern(formatStr));
    }

    /**
     * 格式化日期
     *
     * @param date      日期
     * @param formatStr 格式化str
     * @return {@link String }
     */
    public static String formatDate(Date date, String formatStr) {
        if (date == null) {
            return null;
        }
        return formatDate(asLocalDate(date), formatStr);
    }

    /**
     * 格式化时间
     *
     * @param localTime 时间
     * @return {@link String }
     */
    public static String formatTime(LocalTime localTime) {
        if (localTime == null) {
            return null;
        }
        return localTime.format(DEFAULT_TIME_FORMATTER);
    }

    /**
     * 格式化时间
     *
     * @param localTime 时间
     * @param formatStr 格式化str
     * @return {@link String }
     */
    public static String formatTime(LocalTime localTime, String formatStr) {
        if (localTime == null) {
            return null;
        }
        return localTime.format(DateTimeFormatter.ofPattern(formatStr));
    }

    /**
     * 格式化时间
     *
     * @param time 时间
     * @return {@link String }
     */
    public static String formatTime(Date time) {
        if (time == null) {
            return null;
        }
        return formatTime(asLocalTime(time));
    }

    /**
     * 格式化时间
     *
     * @param time      时间
     * @param formatStr 格式化str
     * @return {@link String }
     */
    public static String formatTime(Date time, String formatStr) {
        if (time == null) {
            return null;
        }
        return formatTime(asLocalTime(time), formatStr);
    }

    /**
     * 获取当前日期时间
     *
     * @return {@link String }
     */
    public static String getCurrentDateTime() {
        return formatDateTime(LocalDateTime.now());
    }

    /**
     * 获取当前日期
     *
     * @return {@link String }
     */
    public static String getCurrentDate() {
        return formatDate(LocalDate.now());
    }

    /**
     * 获取当前时间
     *
     * @return {@link String }
     */
    public static String getCurrentTime() {
        return formatTime(LocalTime.now());
    }

    /**
     * 解析年份
     *
     * @param year 年 yyyy
     * @return {@link Year }
     */
    public static Year parseYear(String year) {
        try {
            return Year.of(Integer.parseInt(year));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析年月
     *
     * @param yearMonth 年月 yyyy-MM
     * @return {@link YearMonth }
     */
    public static YearMonth parseYearMonth(String yearMonth) {
        try {
            return YearMonth.parse(yearMonth, DEFAULT_YEAR_MONTH_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取两个日期之间的所有日期
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 日期列表
     */
    public static List<String> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<String> result = new ArrayList<>();
        if (startDate == null || endDate == null) {
            return result;
        }
        try {
            // 循环添加日期到结果列表
            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                result.add(date.format(DEFAULT_DATE_FORMATTER));
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }

        return result;
    }

    /**
     * 计算两个日期时间的间隔
     * 开始日期时间在前，结束日期时间在后，得到的结果为正数。
     * 比如：开始日期时间为2023-01-01 00:00:00，结束日期时间为2023-01-02 00:00:00 ，间隔为86400秒。
     *
     * @param startDateTime 开始日期时间
     * @param endDateTime   结束日期时间
     * @param unit          单元
     * @return 两个日期时间的间隔
     */
    public static long getDateTimeInterval(LocalDateTime startDateTime, LocalDateTime endDateTime, ChronoUnit unit) {
        if (startDateTime == null || endDateTime == null) {
            return 0;
        }
        return startDateTime.until(endDateTime, unit);
    }

    /**
     * 计算两个日期的间隔
     * 开始日期在前，结束日期在后，得到的结果为正数。
     * 比如：开始日期为2023-01-01，结束日期为2023-01-02 ，间隔为86400秒。
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param unit      单元
     * @return 两个日期的间隔
     */
    public static long getDateInterval(LocalDate startDate, LocalDate endDate, ChronoUnit unit) {
        return getDateTimeInterval(startDate.atStartOfDay(), endDate.atStartOfDay(), unit);
    }
}
