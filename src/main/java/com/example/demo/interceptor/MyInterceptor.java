package com.example.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/***********************过滤器************************/
@Component
public class MyInterceptor implements HandlerInterceptor {

//    @Autowired
//    private IUserService iUserService;
    //预处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("预处理...............");
//        System.out.println(iUserService.getById(1L));
        //是否放行
        return true;
    }
}
