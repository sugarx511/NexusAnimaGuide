package cn.tang.common.exception.aop;

import cn.tang.common.exception.ExceptionCodeEnum;
import cn.tang.common.exception.ResponseData;
import cn.tang.common.exception.exceptions.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 接口响应处理切面
 *
 * @author tz
 * @date 2023-09-05
 */
@Slf4j
@Order(1)
@Aspect
@Component
public class ResAspect {

    @Pointcut("@annotation(cn.tang.common.exception.annotation.Res)")
    public void resAnnotationPointcut() {
    }

    @Around("resAnnotationPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {

        try {
            Object data = joinPoint.proceed();
            if (data == null) {
                return new ResponseData(ExceptionCodeEnum.SUCCESS);
            } else {
                return new ResponseData(ExceptionCodeEnum.SUCCESS, data);
            }
        } catch (Throwable e) {
            if (e instanceof CustomException) {
                return new ResponseData((CustomException) e);
            } else {
                String methodName;
                if (joinPoint.getSignature() instanceof MethodSignature) {
                    Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
                    if (method != null) {
                        methodName = method.getName();
                    } else {
                        methodName = "未知方法";
                    }
                } else {
                    methodName = "未知方法";
                }
                String argsStr = Arrays.toString(joinPoint.getArgs());
                log.error("系统异常!!! 方法:{},参数:{}", methodName, argsStr, e);
                return new ResponseData(ExceptionCodeEnum.INNER_EXCEPTION);
            }
        }
    }
}
