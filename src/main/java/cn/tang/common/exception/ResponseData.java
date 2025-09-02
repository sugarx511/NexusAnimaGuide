package cn.tang.common.exception;

import cn.tang.common.exception.exceptions.CustomException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 响应数据
 *
 * @author tz
 * @date 2023-09-05
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {

    /**
     * 编码
     */
    private Integer code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

    public ResponseData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(CustomException customException) {
        this.code = customException.getCode();
        this.msg = customException.getMessage();
    }

    public ResponseData(ExceptionCodeEnum exceptionCodeEnum) {
        this.code = exceptionCodeEnum.code;
        this.msg = exceptionCodeEnum.msg;
    }

    public ResponseData(ExceptionCodeEnum exceptionCodeEnum, Object data) {
        this.code = exceptionCodeEnum.code;
        this.msg = exceptionCodeEnum.msg;
        this.data = data;
    }
}
