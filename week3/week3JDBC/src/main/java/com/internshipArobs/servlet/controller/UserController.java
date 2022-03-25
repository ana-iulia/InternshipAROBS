package com.internshipArobs.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/MyServlet", urlPatterns = "/user")
public class UserController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>Welcome customer</h1>");
        out.print("""
                <form action=\"login\">
                <br/><br/>First name:<br/><input type=\"text\" name=\"firstName\"/>
                <br/><br/>Last name:<br/><input type=\"text\" name=\"lastName\"/>
                <br/><br/>Phone number:<br/><input type=\"password\" name=\"phoneNumber\"/>
                <br/><br/><input type=\"submit\" value=\"Login\">
                </form> 
                <form action="register">
                    <input type="submit" value="Register" />
                </form>      
                """);
    }
}
