package com.studies.myfirstspringbootapp.web.demos.web.Infrastructure.Exception;

import com.studies.myfirstspringbootapp.web.demos.web.models.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理全局异常
     *
     * @param ex ：异常
     * @return ：结果
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<String>> handle(Exception ex) {
        log.error("系统发生未处理异常:{}", ex.getMessage(), ex);

        Result<String> result = Result.error(HttpStatus.INTERNAL_SERVER_ERROR, "系统发生未处理异常");
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
