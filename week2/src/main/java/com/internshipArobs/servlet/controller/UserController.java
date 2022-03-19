package com.internshipArobs.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/MyServlet", urlPatterns = "/user")
public class UserController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>Welcome</h1>");
        out.print("""
                <form action=\"login\">
                <br/><br/>Email:<br/><input type=\"text\" name=\"email\"/>
                <br/><br/>Password:<br/><input type=\"password\" name=\"password\"/><br/><br/>
                <input type=\"submit\" value=\"Login\">
                </form> 
                <form action="register">
                    <input type="submit" value="Register" />
                </form>      
                """);
    }
}
