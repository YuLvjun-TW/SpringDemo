package com.example.demo.filter;

import org.springframework.boot.web.servlet.ServletContextInitializerBeans;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "FilterDemo1")
public class FilterDemo1 implements Filter {
    private String filterName;
    ServletContextInitializerBeans servletContextInitializerBeans = null;

    @Override
    public void init(FilterConfig filterConfig) {
        filterName = filterConfig.getFilterName();
        System.out.println(String.format("----%s过滤器初始化----", filterName));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println(String.format("----%s执行前----", filterName));
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println(String.format("----%s执行后----", filterName));
    }

    @Override
    public void destroy() {
        System.out.println(String.format("----%s过滤器初始化----", filterName));
    }
}
