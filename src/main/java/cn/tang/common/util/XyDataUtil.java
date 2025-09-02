package cn.tang.common.util;

import java.util.function.Function;

/**
 * 数据工具类
 *
 * @author tz
 * @date 2025-07-21
 */
public class XyDataUtil {

    /**
     * 执行类中的某个方法，如果执行的类为null，则返回null。
     *
     * @param data   数据
     * @param method 方法
     * @return {@link T }
     */
    public static <T, V> T executeNoNull(V data, Function<? super V, ? extends T> method) {
        return executeNoNull(data, method, null);
    }

    /**
     * 执行类中的某个方法，如果执行的类为null，则返回默认值。
     *
     * @param data         数据
     * @param method       方法
     * @param defaultValue 默认值
     * @return {@link T }
     */
    public static <T, V> T executeNoNull(V data, Function<? super V, ? extends T> method, T defaultValue) {
        return data == null ? defaultValue : method.apply(data);
    }

    /**
     * 判断值是否为空，如果为空，则使用默认值
     *
     * @param value        值
     * @param defaultValue 默认值
     * @return {@link T }
     */
    public static <T> T defaultIfNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }
}
