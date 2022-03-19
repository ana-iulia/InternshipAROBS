package com.internshipArobs.servlet.controller;

import com.internshipArobs.servlet.domain.User;
import com.internshipArobs.servlet.service.UserService;

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
        UserService userService = (UserService) getServletContext().getAttribute("service");
        try {
            User user = userService.login(request.getParameter("email"), request.getParameter("password"));
            List<String> toDoList = new ArrayList<>();
            HttpSession newSession = request.getSession();
            newSession.setAttribute("toDoList", toDoList);
            newSession.setAttribute("user", user);
            output.print("<h1>Welcome " + user.getName() + "</h1>");
            output.print("<h3>Session id: " + newSession.getId() + "</h3>");
            output.print("<h3>Session created on: " + newSession.getCreationTime() + "</h3>");
            output.print("""
                    <form action="myToDoList">
                    <input type="submit" value="My To Do List"/>
                    </form>
                    <form action="user">
                    <input type="submit" value="Logout"/>
                    </form>
                    """);

        } catch (Exception e) {

            output.print("<h3 style=\"color:red\">Username or password error!</h3>");
            request.getRequestDispatcher("/user").include(request, response);
        }
        output.close();
    }

}
