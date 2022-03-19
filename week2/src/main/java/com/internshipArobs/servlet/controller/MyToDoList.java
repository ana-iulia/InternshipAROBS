package com.internshipArobs.servlet.controller;

import com.internshipArobs.servlet.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/myToDoList")
public class MyToDoList extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        User user = (User) session.getAttribute("user");
        List<String> toDoList = (List<String>) session.getAttribute("toDoList");
        out.print("<h3>Session id: " + session.getId() + "</h3>");
        out.print("<h1>" + user.getName() + "'s To Do List:" + "</h1>");
        out.print("""
                <form action="user">
                    <input type="submit" value="Logout"/>
                </form>
                """);

        out.print("""
                <form action=\"myToDoList\">
                <br/><br/>New item:<br/><input type=\"text\" name=\"item\"/>
                <input type=\"submit\" value=\"Add\">
                """);

        String newItem = req.getParameter("item");
        if (newItem != null) {
            toDoList.add(newItem);
        }
        out.print("""
                <html>
                    <body> 
                        <ol>""");
        for (String item : toDoList) {
            out.print("<li>" + item + "</li>");
        }

        out.print("""
                        </ol>
                    </body>
                </html>
                """);
        if (toDoList.size() == 0) {
            out.print("<h3>The list is empty!</h3>");
        }


        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registerPost.jsp");
        requestDispatcher.forward(request, response);


    }

}

