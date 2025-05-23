package com.udemy.fifthsection.interceptor.FifthSection.interceptors;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception {
        logger.info("LoadingTimeInterceptor: preHandle() entrando..." + ((HandlerMethod)handler).getMethod().getName());
        request.setAttribute("start", System.currentTimeMillis());
        Random delay = new Random();
        Thread.sleep(delay.nextInt(500));
        Map<String, String> json = new HashMap<>();
        json.put("error", "You dont have access this resource");
        json.put("date", new Date().toString());
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(json);
        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(jsonString);
        return false;
        // return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
            System.out.println("Its been: " + (System.currentTimeMillis() - (long) request.getAttribute("start") + " ms"));
            logger.info("LoadingTimeInterceptor: postHandle() saliendo..." + ((HandlerMethod)handler).getMethod().getName());
    }
}
