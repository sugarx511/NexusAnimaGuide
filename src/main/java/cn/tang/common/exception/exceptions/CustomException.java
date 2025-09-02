package cn.tang.common.exception.exceptions;

import cn.tang.common.exception.ExceptionCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义异常
 *
 * @author tz
 * @date 2023-08-29
 */
@Getter
@Setter
@Slf4j
public class CustomException extends RuntimeException {

    private int code;

    public CustomException() {
        super();
        this.code = ExceptionCodeEnum.DEFAULT_EXCEPTION.code;
    }

    public CustomException(String message) {
        super(message);
        this.code = ExceptionCodeEnum.DEFAULT_EXCEPTION.code;
    }

    public CustomException(int code) {
        super();
        this.code = code;
    }

    public CustomException(String message, int code) {
        super(message);
        this.code = code;
    }

    public CustomException(ExceptionCodeEnum exceptionCodeEnum) {
        super(exceptionCodeEnum.msg);
        this.code = exceptionCodeEnum.code;
    }
}
