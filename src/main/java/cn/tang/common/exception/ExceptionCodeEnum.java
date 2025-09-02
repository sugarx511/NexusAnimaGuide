package cn.tang.common.exception;

import lombok.AllArgsConstructor;

/**
 * 异常编码枚举
 *
 * @author tz
 * @date 2023-08-29
 */
@AllArgsConstructor
public enum ExceptionCodeEnum {

    // 默认异常
    DEFAULT_EXCEPTION(90, "默认异常", "系统异常"),

    // 内部异常 - 后端服务未预料到的异常
    INNER_EXCEPTION(99, "内部异常", "系统异常"),

    // 内部参数异常 - 前端传的参数在服务器中未找到对应的数据
    INNER_PARAM_EXCEPTION(98, "内部参数异常", "系统异常"),

    // 参数异常 - 前端传的参数格式有误
    PARAM_EXCEPTION(40, "参数异常", "参数异常"),

    // 用户提示异常 - 对于用户友好的异常提示
    USER_REMIND_EXCEPTION(20, "用户提示异常", "系统提示"),

    // 成功
    SUCCESS(0, "成功", "成功"),

    ;

    public final int code;

    public final String reason;

    public final String msg;
}
