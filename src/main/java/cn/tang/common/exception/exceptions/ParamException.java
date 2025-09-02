package cn.tang.common.exception.exceptions;

import cn.tang.common.exception.ExceptionCodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义异常
 *
 * @author tz
 * @date 2023-08-29
 */
@Slf4j
public class ParamException extends CustomException {

    public ParamException() {
        super(ExceptionCodeEnum.INNER_PARAM_EXCEPTION);
    }

    public ParamException(String message) {
        super(message, ExceptionCodeEnum.INNER_PARAM_EXCEPTION.code);
        log.error("内部参数异常,{}", message);
    }
}
