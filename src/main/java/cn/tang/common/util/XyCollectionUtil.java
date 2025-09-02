package cn.tang.common.util;

import java.util.*;

/**
 * 集合工具类
 *
 * @author tz
 * @date 2025-08-08
 */
public class XyCollectionUtil {

    /**
     * 判断集合是否为空
     *
     * @param coll 集合
     * @return boolean
     */
    public static boolean isEmpty(Collection<?> coll) {
        return (coll == null || coll.isEmpty());
    }

    /**
     * 判断映射是否为空
     *
     * @param map 映射
     * @return boolean
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 判断集合是否不为空
     *
     * @param coll 集合
     * @return boolean
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 判断映射是否不为空
     *
     * @param map 映射
     * @return boolean
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 将一个数组转换成ArrayList。注意：数组类型必须为包装类型，不能是 int 这种基本类型，比如可以使用 Integer[]，但是不能使用 int[]。
     *
     * @param a 一
     * @return {@link List }<{@link T }>
     */
    @SafeVarargs
    public static <T> List<T> asList(T... a) {
        if (a == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(a));
    }

    /**
     * 判断集合中是否包含某个元素
     *
     * @param iterator 集合
     * @param element  元素
     * @return boolean
     */
    public static boolean contains(Iterator<?> iterator, Object element) {
        if (iterator != null) {
            while (iterator.hasNext()) {
                Object candidate = iterator.next();
                if (XyObjectUtil.nullSafeEquals(candidate, element)) {
                    return true;
                }
            }
        }
        return false;
    }
}
