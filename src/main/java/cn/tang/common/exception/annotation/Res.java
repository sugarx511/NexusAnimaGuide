package cn.tang.common.exception.annotation;

import java.lang.annotation.*;

/**
 * 接口响应处理注解
 *
 * @author tz
 * @date 2023-09-05
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Res {

}
