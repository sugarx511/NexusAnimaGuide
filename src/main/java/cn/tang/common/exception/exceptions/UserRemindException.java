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
public class UserRemindException extends CustomException {

    public UserRemindException() {
        super(ExceptionCodeEnum.USER_REMIND_EXCEPTION);
    }

    public UserRemindException(String message) {
        super(message, ExceptionCodeEnum.USER_REMIND_EXCEPTION.code);
    }
}
