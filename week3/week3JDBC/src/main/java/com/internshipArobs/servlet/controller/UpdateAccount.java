package com.internshipArobs.servlet.controller;

import com.internshipArobs.servlet.domain.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updateAccount")
public class UpdateAccount extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        Customer customer = (Customer) session.getAttribute("customer");
        out.print("""
                          <head>
                          </head>
                          <body>
                          <form action="updateAccount" method="post">
                              First name:<br/><input type="text" name="firstName"/><br/><br/>
                              Last name:<br/><input type="text" name="lastName"/><br/><br/>
                              Phone number:<br/><input type="password" name="phoneNumber"/><br/><br/><br/>
                              <input type="submit" value=" Update "/>
                          </form>
                          </body>
                          </html>""");
        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/updatePost.jsp");
        requestDispatcher.forward(request, response);


    }
}