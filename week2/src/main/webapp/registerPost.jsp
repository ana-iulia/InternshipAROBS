<%@ page import="com.internshipArobs.servlet.domain.User" %>
<%@ page import="com.internshipArobs.servlet.service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserService userService = (UserService) session.getServletContext().getAttribute("service");
    try {
        userService.registerUser(request.getParameter("userName"), request.getParameter("userEmail"), request.getParameter("userPass"));

%>
<!Doctype html>
<style>
    table, th, td {
        border: 1px solid black;
    }

    th {
        background-color: #42d1f5;
    }
</style>
<body>
<h2 style="color:green"> User registered successfully!</h2>
<form action="user">
    <input type="submit" value="Login"/>
</form>
<h3> All users: </h3>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
    </tr>

    <%
        for (User u : userService.findAll()) {
    %>
    <tr>
        <td><%=u.getId()%>
        </td>
        <td><%=u.getName()%>
        </td>
        <td><%=u.getEmail()%>
        </td>
        <td><%=u.getPassword()%>
        </td>

    </tr>

    <%
        }
    } catch (Exception e) {%>


    <h1 style="color:red">User could not be registered! <%=e.getMessage()%>
    </h1>
    <%
        }
    %>

</table>
</body>
</html>
