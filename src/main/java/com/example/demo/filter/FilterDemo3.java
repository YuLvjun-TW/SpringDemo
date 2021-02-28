package com.example.demo.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "FilterDemo3")
//@Order(1)
//@Component
public class FilterDemo3 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("----FilterDemo3过滤器初始化----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo3执行前！！！");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterDemo3执行后！！！");
    }
    @Override
    public void destroy() {
        System.out.println("----FilterDemo3过滤器销毁----");
    }
}
