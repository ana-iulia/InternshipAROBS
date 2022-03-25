package com.internshipArobs.servlet.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        if (!request.getServletPath().equals("/register")) {
            ServletContext context = event.getServletContext();
            context.setAttribute("register", (int) context.getAttribute("register") + 1);
        }
    }

}