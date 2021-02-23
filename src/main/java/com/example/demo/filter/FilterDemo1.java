package com.example.demo.filter;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletContextResourcePatternResolver;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*", filterName = "FilterDemo1")
@Order(3)
@Component
public class FilterDemo1 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("----FilterDemo1过滤器初始化----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo1执行前！！！");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterDemo1执行后！！！");
    }
    @Override
    public void destroy() {
        System.out.println("----FilterDemo1过滤器销毁----");
    }
}
