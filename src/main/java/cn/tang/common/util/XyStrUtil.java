package cn.tang.common.util;

import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

/**
 * 字符串工具类
 *
 * @author tz
 * @date 2025-08-08
 */
public class XyStrUtil {

    /**
     * 空字符串
     */
    public static final String EMPTY = "";

    /**
     * 英文逗号
     */
    public static final String COMMA = ",";

    /**
     * 获取字符串的长度，如果字符串为空，则返回0。
     *
     * @param cs 字符串
     * @return int
     */
    public static int length(CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    /**
     * 判断字符串是否为空、null、空格
     *
     * @param cs 字符串
     * @return boolean
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen = length(cs);
        if (strLen != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断字符串是否不为空、null、空格
     *
     * @param cs 字符串
     * @return boolean
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 判断字符串是否为空、null，此方法不会校验字符串是否全为空格
     *
     * @param cs 字符串
     * @return boolean
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 判断字符串是否不为空、null，此方法不会校验字符串是否全为空格
     *
     * @param cs 字符串
     * @return boolean
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判断字符串是否相同
     *
     * @param cs1 字符串1
     * @param cs2 字符串2
     * @return boolean
     */
    public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
        if (cs1 == cs2) {
            return true;
        }
        if (cs1 == null || cs2 == null) {
            return false;
        }
        if (cs1.length() != cs2.length()) {
            return false;
        }
        if (cs1 instanceof String && cs2 instanceof String) {
            return cs1.equals(cs2);
        }
        final int length = cs1.length();
        for (int i = 0; i < length; i++) {
            if (cs1.charAt(i) != cs2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否为数字，可以为小数或负数（十六进制和科学计数法除外）
     *
     * @param str 反恐精英
     * @return boolean
     */
    public static boolean isNumber(final String str) {
        if (XyStrUtil.isEmpty(str)) {
            return false;
        }
        if (str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            return withDecimalsParsing(str, 1);
        }
        return withDecimalsParsing(str, 0);
    }

    /**
     * 判断是否为数字
     *
     * @param str      字符串
     * @param beginIdx 开始索引
     * @return boolean
     */
    private static boolean withDecimalsParsing(final String str, final int beginIdx) {
        int decimalPoints = 0;
        for (int i = beginIdx; i < str.length(); i++) {
            final char ch = str.charAt(i);
            final boolean isDecimalPoint = ch == '.';
            if (isDecimalPoint) {
                decimalPoints++;
            }
            if (decimalPoints > 1) {
                return false;
            }
            if (!isDecimalPoint && !Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 如果字符串值为空（包含空格），则返回默认字符串，否则返回原字符串
     *
     * @param str        字符串
     * @param defaultStr 默认字符串
     * @return {@link String }
     */
    public static String defaultIfBlank(String str, String defaultStr) {
        return isBlank(str) ? defaultStr : str;
    }

    /**
     * 如果字符串值为空（包含空格），则返回空字符串，否则返回原字符串
     *
     * @param str 字符串
     * @return {@link String }
     */
    public static String defaultIfBlank(String str) {
        return defaultIfBlank(str, EMPTY);
    }

    /**
     * 如果字符串值为空，则返回默认字符串，否则返回原字符串
     *
     * @param str        字符串
     * @param defaultStr 默认字符串
     * @return {@link String }
     */
    public static String defaultIfEmpty(String str, String defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }

    /**
     * 如果字符串值为空，则返回空字符串，否则返回原字符串
     *
     * @param str 字符串
     * @return {@link String }
     */
    public static String defaultIfEmpty(String str) {
        return defaultIfEmpty(str, EMPTY);
    }

    /**
     * 分割字符串
     *
     * @param str       字符串
     * @param separator 分隔符
     * @return {@link String[] }
     */
    public static String[] split(String str, String separator) {
        if (str == null) {
            return new String[0];
        }
        return str.split(separator);
    }

    /**
     * 分割字符串，默认根据英文逗号分割
     *
     * @param str 字符串
     * @return {@link String[] }
     */
    public static String[] split(String str) {
        return split(str, COMMA);
    }

    /**
     * 分割字符串，返回ArrayList
     *
     * @param str       字符串
     * @param separator 分隔符
     * @return {@link List }<{@link String }>
     */
    public static List<String> splitToList(String str, String separator) {
        return XyCollectionUtil.asList(split(str, separator));
    }

    /**
     * 分割字符串，返回ArrayList，默认根据英文逗号分割
     *
     * @param str 字符串
     * @return {@link List }<{@link String }>
     */
    public static List<String> splitToList(String str) {
        return XyCollectionUtil.asList(split(str));
    }

    /**
     * 数组合并字符串
     *
     * @param array     数组
     * @param separator 分隔符
     * @return {@link String }
     */
    public static String join(Object[] array, String separator) {
        if (array == null) {
            return null;
        }
        StringJoiner joiner = new StringJoiner(XyStrUtil.defaultIfEmpty(separator));
        for (Object cs : array) {
            joiner.add(toStringOrEmpty(cs));
        }
        return joiner.toString();
    }

    /**
     * 数组合并字符串，默认根据英文逗号分割
     *
     * @param array 数组
     * @return {@link String }
     */
    public static String join(Object[] array) {
        return join(array, COMMA);
    }

    /**
     * 列表合并字符串
     *
     * @param list      数组
     * @param separator 分隔符
     * @return {@link String }
     */
    public static String join(Collection<Object> list, String separator) {
        if (list == null) {
            return null;
        }
        StringJoiner joiner = new StringJoiner(XyStrUtil.defaultIfEmpty(separator));
        for (Object cs : list) {
            joiner.add(toStringOrEmpty(cs));
        }
        return joiner.toString();
    }

    /**
     * 列表合并字符串，默认根据英文逗号分割
     *
     * @param list 数组
     * @return {@link String }
     */
    public static String join(Collection<Object> list) {
        return join(list, COMMA);
    }

    /**
     * 对象转字符串，如果为null则返回空字符串
     *
     * @param obj 对象
     * @return {@link String }
     */
    public static String toStringOrEmpty(Object obj) {
        return obj == null ? EMPTY : obj.toString();
    }

    /**
     * 对象转字符串，如果为null则返回null
     *
     * @param obj 对象
     * @return {@link String }
     */
    public static String toString(Object obj) {
        return obj == null ? null : obj.toString();
    }
}
