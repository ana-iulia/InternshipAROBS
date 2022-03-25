package com.internshipArobs.servlet.controller;

import com.internshipArobs.servlet.domain.Customer;
import com.internshipArobs.servlet.domain.OrderMenuItem;
import com.internshipArobs.servlet.service.CustomerService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter output = response.getWriter();
        CustomerService customerService = (CustomerService) getServletContext().getAttribute("customerService");
        try {
            Customer customer = customerService.login(request.getParameter("firstName"),request.getParameter("lastName"), Long.valueOf(request.getParameter("phoneNumber")));
            List<OrderMenuItem> toDoList = new ArrayList<>();
            HttpSession newSession = request.getSession();
            newSession.setAttribute("toDoList", toDoList);
            newSession.setAttribute("customer", customer);
            output.print("<h1>Welcome " + customer.getFirstName()+" " +customer.getLastName() + "</h1>");
            output.print("<h3>Session id: " + newSession.getId() + "</h3>");
            output.print("<h3>Session created on: " + newSession.getCreationTime() + "</h3>");
            output.print("""
                    <form action="myOrders">
                    <input type="submit" value="My Orders"/>
                    </form>
                    <form action="updateAccount">
                    <input type="submit" value="Update my information"/>
                    </form>
                    <form action="deleteAccount"
                    onsubmit="return confirm('Are you sure you want to delete your account?');">
                    <input type="submit" value="Delete account"/>
                    </form>
                    <form action="user">
                    <input type="submit" value="Logout"/>
                    </form>
                    """);
            ServletContext context = getServletContext();
            context.setAttribute("customer", customer);

        } catch (Exception e) {

            output.print("<h3 style=\"color:red\">Username or password error!</h3>");
            request.getRequestDispatcher("/user").include(request, response);
        }
        output.close();
    }

}
