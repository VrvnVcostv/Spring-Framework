package com.udemy.sixthsection.calendar.SixthSection.interceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("calendarInterceptor")
public class CalendarInterceptor implements HandlerInterceptor{

    @Value("${config.calendar.open}")
    private int openHour;
    @Value("${config.calendar.close}")
    private int closeHour;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= openHour && hour < closeHour) {
            StringBuilder message = new StringBuilder("Welcome to the customer service schedule");
            message.append(", we serve from ");
            message.append(openHour);
            message.append("hrs.");
            message.append(" to ");
            message.append(closeHour);
            message.append("hrs.");
            message.append(" Thanks for your visit.");
            request.setAttribute("message", message.toString());
            return true;
        }
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> data = new HashMap<>();
        StringBuilder message = new StringBuilder("Closed, out of attention schedule ");
        message.append("please visit us from ");
        message.append(openHour);
        message.append(" to ");
        message.append(closeHour);
        message.append("hrs. Thanks");
        data.put("message", message.toString());
        data.put("date", new Date().toString());
        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(mapper.writeValueAsString(data));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
    }
}
