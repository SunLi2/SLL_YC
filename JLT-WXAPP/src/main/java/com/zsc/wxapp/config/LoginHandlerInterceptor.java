package com.zsc.wxapp.config;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        final Object admin = request.getSession().getAttribute("admin");
//        if (admin == null) {
//            request.setAttribute("msg", "没有权限，请先登录！");
//            request.getRequestDispatcher("/index").forward(request, response);
//            return false;
//        } else {
//            return true;
//        }

        return true;
    }

}
