package com.internshipArobs.servlet.controller;
import com.internshipArobs.servlet.domain.Customer;
import com.internshipArobs.servlet.domain.OrderMenuItem;
import com.internshipArobs.servlet.service.OrderMenuItemService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/myOrders")
public class MyOrder extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        OrderMenuItemService itemService = (OrderMenuItemService) session.getServletContext().getAttribute("orderMenuItemService");
        Customer customer = (Customer) session.getAttribute("customer");
        List<OrderMenuItem> toDoList = (List<OrderMenuItem>) session.getAttribute("toDoList");
        out.print("<h3>Session id: " + session.getId() + "</h3>");
        out.print("<h1>" + customer.getFirstName() + "'s order List:" + "</h1>");


        out.print("""
                <head>
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <style>
                body {
                  font-family: Arial;
                  color: white;
                }
                                
                .split {
                  height: 100%;
                  width: 50%;
                  position: fixed;
                  z-index: 1;
                  top: 0;
                  overflow-x: hidden;
                  padding-top: 20px;
                }
                                
                .left {
                  left: 0;
                  background-color: #111;
                }
                                
                .right {
                  right: 0;
                  background-color: red;
                }
                                
                .centered {
                  position: absolute;
                  top: 50%;
                  left: 50%;
                  transform: translate(-50%, -50%);
                  text-align: center;
                }
                                
                </style>
                </head>
                <body>
                                
                <div class="split left">
                  <div class="centered">
                  <form action="user">
                    <input type="submit" value="Logout"/>
                    </form>
                    
                    """);
        OrderMenuItem newItem = (OrderMenuItem) session.getAttribute("item");
        if (newItem != null) {
            toDoList.add(newItem);
        }
        out.print("""
                <html>
                    <body> 
                        <ol>""");
        for (OrderMenuItem item : toDoList) {
            out.print("<li>" + item.getName() + "</li>");
        }
        if (toDoList.size() == 0) {
            out.print("<h3>The list is empty!</h3>");
        }
        out.print("""
                  </div >
                </div >
                                
                <div class="split right" >
                  <div class="centered" >
                  """);
        try {
            for (OrderMenuItem item : itemService.findAll()) {
                session.setAttribute("item", item);
                out.print("""
                                  <form action="myOrders">
                                   <h3>""" + item.getName() + "</h3>" +
                          "<h4>" + item.getDescription() + "</h4>" +
                          "<input type=\"submit\" value= Add to order name=\"item\"></form>");


            }
            out.print("""
                    </div >
                    </div >
                    """);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registerPost.jsp");
        requestDispatcher.forward(request, response);


    }

}

