package com.example.demo.handler;

import com.example.demo.pojo.ResultBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*****************************拦截器***************************/
/**
 * 异常拦截器
 * 1.定义一个全局异常，相当于默认异常。
 * 2.之后根据实际情况，逐个添加精细化的异常控制。
 * 3.根据异常的类型，先找与之对应的准确的异常，如果没有才会使用全局异常（默认异常）。
 * */
@ControllerAdvice
@Slf4j
public class GloablExceptionHandler {

    /**
     * 全局统一处理异常信息，异常拦截，反馈给用户具体的信息
     **/
    //private Logger log = LoggerFactory.getLogger(GloablExceptionHandler.class);
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean validationErrorHandler(BindException ex) throws JsonProcessingException {
        //1.此处先获取BindingResult
        BindingResult bindingResult = ex.getBindingResult();
        //2.获取错误信息
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        //3.组装异常信息
        Map<String,String> message = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            message.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        //4.将map转换为JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(message);
        //5.返回错误信息
        return new ResultBean("400",json);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean errorPage(Exception e){
        log.error(e.getMessage());
        //
        return new ResultBean("400","数据格式异常！！");
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public String errorPage(Exception e){
//        //1.打印日日志
//        log.error(e.getMessage());
//        //2.如果有核心业务逻辑，通知相关人员
//        //3.发送短信或邮件
//        //springboot
//        return "404";
//    }
}
