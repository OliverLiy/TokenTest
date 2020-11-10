package com.javayz.exception;

import com.javayz.entity.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author by: Liyu
 * @ClassName: MyControllerAdvice
 * @Description: TODO 全局异常捕获器
 * @Date: 2020/11/9 15:59
 */
@ControllerAdvice
public class MyControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public Response serviceExceptionHandler(ServiceException exception){
        Response response=new Response(Integer.valueOf(exception.getCode()),exception.getMsg(),null);
        return response;
    }
}
