package com.wonder.common.exception;

import com.wonder.common.result.Result;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionGlobal {
    private static final Logger log = LoggerFactory.getLogger(ExceptionGlobal.class);

    public ExceptionGlobal() {
    }

    @ExceptionHandler({Exception.class})
    public Result exceptionHandler(Exception e) {
        log.error("service err: {}", e);
        Result res = new Result();
        res.setCode(-1);
        res.setMessage(String.format("错误信息：%s", e.getMessage()));
        return res;
    }

//    @ExceptionHandler({BusinessException.class})
//    public Result businessHandler(BusinessException e) {
//        log.warn("service warn: {}", e.getMessage());
//        Result res = new Result();
//        res.setCode(-1);
//        res.setMessage(e.getMessage());
//        return res;
//    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Result ParameterException(MissingServletRequestParameterException e) {
        log.error("缺少参数：{}", e.getMessage());
        Result res = new Result();
        res.setCode(-1);
        res.setMessage(String.format("错误信息：%s", e.getMessage()));
        return res;
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result MethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("请求方式错误：{}", e.getMessage());
        Result res = new Result();
        res.setCode(-1);
        res.setMessage(String.format("错误信息：%s", e.getMessage()));
        return res;
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public Result MethodNotSupportedException(ConstraintViolationException e) {
        String msg = (String)e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        log.error("参数错误：{}", msg);
        Result res = new Result();
        res.setCode(-1);
        res.setMessage(String.format("错误信息：%s", msg));
        return res;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        Iterator var4 = fieldErrors.iterator();

        while(var4.hasNext()) {
            FieldError fieldError = (FieldError)var4.next();
            sb.append(String.format("%s=%s, err:%s，", fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage()));
        }

        sb.deleteCharAt(sb.length() - 1);
        log.error("参数错误：{}", sb.toString());
        Result res = new Result();
        res.setCode(-1);
        res.setMessage(String.format("错误信息:{%s}", sb.toString()));
        return res;
    }

    @ExceptionHandler({MyBatisSystemException.class})
    public Result MyBatisSystemException(MyBatisSystemException e) {
        log.warn("service warn: {}", e.getRootCause().getMessage());
        Result res = new Result();
        res.setCode(-1);
        res.setMessage(e.getRootCause().getMessage());
        return res;
    }

    @ExceptionHandler({BindException.class})
    public Result BindException(BindException e) {
        StringBuilder sb = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        Iterator var4 = fieldErrors.iterator();

        while(var4.hasNext()) {
            FieldError fieldError = (FieldError)var4.next();
            sb.append(String.format("%s=%s, err:%s，", fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage()));
        }

        sb.deleteCharAt(sb.length() - 1);
        log.error("参数错误：{}", sb.toString());
        Result res = new Result();
        res.setCode(-1);
        res.setMessage(String.format("错误信息：%s", sb.toString()));
        return res;
    }
}
