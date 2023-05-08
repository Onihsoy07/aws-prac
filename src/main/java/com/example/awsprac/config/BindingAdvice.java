package com.example.awsprac.config;

import com.example.awsprac.domain.dto.ResponseDto;
import io.sentry.Sentry;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect //Class의 전처리는 Filter로 Class내의 전후처리는 AOP로
public class BindingAdvice {

    private final Logger LOGGER = LoggerFactory.getLogger(BindingAdvice.class);

    @Before("execution(* com.example.awsprac.controller..*Controller.*(..))")
    public void testCheck() {
        HttpServletRequest request =
            ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        System.out.println("주소 확인 : " + request.getRequestURI());
    }

    @Around("execution(* com.example.awsprac.controller..*Controller.*(..))")
    public Object validCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String method = proceedingJoinPoint.getSignature().getName();

        System.out.println("tpye : " + type + " method : " + method);

        Object[] args = proceedingJoinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    Map<String, String> errorMap = new HashMap<>();

                    for (FieldError error : bindingResult.getFieldErrors()) {
                        errorMap.put(error.getField(), error.getDefaultMessage());
                        //로그 뿌리기(logback 사용하여 파일로 저장 및 sentry 사용)
                        LOGGER.warn("{}.{}() => 필드 : {}, 메시지 : {}", type, method, error.getField(), error.getDefaultMessage());
                        Sentry.captureMessage(String.format("%s.%s() => 필드 : %s, 메시지 : %s", type, method, error.getField(), error.getDefaultMessage()));
                        Sentry.captureException(new Throwable(new IllegalArgumentException("testtesttewtwtfsdafa")));
                    }

                    return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), errorMap);
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }

}
