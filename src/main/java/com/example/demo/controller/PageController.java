package com.example.demo.controller;

import com.example.demo.entity.TUser;
import com.example.demo.pojo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("page")
@Slf4j
public class PageController {

    //private Logger log = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("hello")
    public String hello(Model model){
        log.debug("debug....");
        log.info("info....");
        log.warn("warn....");
        log.error("error....");
        //int c = 1/0;
//        try{
//            int a = 1;
//            int b = 0;
//            int c = a/b;
//        }
//        catch (Exception e){
//            log.error(e.getMessage());
//        }
        model.addAttribute("username","fang0000");
        TUser user = new TUser(1,"111","2222","3333");
        model.addAttribute("user",user);
        model.addAttribute("money",100);
        List<TUser> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            TUser user1 = new TUser(i,""+i,""+i,""+i);
            list.add(user1);
        }
        model.addAttribute("list",list);
        return "hello";
    }

    //测试数据校验
//    @RequestMapping("add")
//    @ResponseBody
//    public ResultBean hello(@Valid TUser user, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//            for (FieldError f : fieldErrors) {
//                //错误参数
//                String field = f.getField();
//                //错误信息
//                String defaultMessage = f.getDefaultMessage();
//                log.error("[{}]:[{}]",field,defaultMessage);
//            }
//            return new ResultBean("fild","数据校验失败");
//        }
//        return new ResultBean("success","ok");
//    }
    @RequestMapping("add")
    @ResponseBody
    public ResultBean hello(@Valid TUser user){
//        if(bindingResult.hasErrors()){
//            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//            for (FieldError f : fieldErrors) {
//                //错误参数
//                String field = f.getField();
//                //错误信息
//                String defaultMessage = f.getDefaultMessage();
//                log.error("[{}]:[{}]",field,defaultMessage);
//            }
//            return new ResultBean("fild","数据校验失败");
//        }
        return new ResultBean("success","ok");
    }
}
