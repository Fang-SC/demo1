package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "User")
@Slf4j
public class UserController {

    @Value("${resource.getImage}")
    public String images;
    @Value("${resource.getFile}")
    public String file;

    @RequestMapping(value = "hello")
    @ResponseBody
    public String hello(){
        return"hello";
    }
    @RequestMapping(value = "getImage",method = RequestMethod.GET)
    @ResponseBody
    public String getImage(){
        return images;
    }
    @RequestMapping(value = "file",method = RequestMethod.GET)
    @ResponseBody
    public String getFile() {
        //提交测试.....
        log.error("error.....");
        System.out.println("dev add.......");
        log.info("info.......");
        log.warn("warn.......");
        return file;
    }
}
