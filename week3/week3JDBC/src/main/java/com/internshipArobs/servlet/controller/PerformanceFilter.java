package com.internshipArobs.servlet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "performanceFilter", urlPatterns = {"/*"})
public class PerformanceFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(PerformanceFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long endTime = System.currentTimeMillis();
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String resourceName = httpRequest.getRequestURI();
            long time = endTime - startTime;
            logger.info("{} took {} milliseconds", resourceName, time);

        }

    }

    @Override
    public void destroy() {
    }
}
