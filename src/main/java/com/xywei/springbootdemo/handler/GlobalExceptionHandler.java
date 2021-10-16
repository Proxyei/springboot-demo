package com.xywei.springbootdemo.handler;

import com.xywei.springbootdemo.http.ResponseResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.net.BindException;
import java.util.Set;

/**
 * @Author future
 * @DateTime 2021/10/7 23:12
 * @Description
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult validationHandler(ConstraintViolationException exception) {

        ResponseResult responseResult = new ResponseResult();
        responseResult.setStatus(500);
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        for (ConstraintViolation constraintViolation : constraintViolations) {
            responseResult.setMessage(constraintViolation.getMessage());
            return responseResult;
        }

        return responseResult;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseResult(500, e.getBindingResult().getFieldError().getDefaultMessage(), null);
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseResult handleValidationException(ValidationException e) {
        return new ResponseResult(500, e.getCause().getMessage(), null);
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseResult<String> errorHandler(BindException e) {
        return new ResponseResult(500, e.getCause().getMessage(), null);
    }

}
