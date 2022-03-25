<%@ page import="com.internshipArobs.servlet.domain.User" %>
<%@ page import="com.internshipArobs.servlet.service.UserService" %>
<%@ page import="com.internshipArobs.servlet.service.CustomerService" %>
<%@ page import="com.internshipArobs.servlet.domain.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CustomerService customerService = (CustomerService) session.getServletContext().getAttribute("customerService");
    Customer customer = (Customer) session.getAttribute("customer");

    try {
        Long phoneNumber=null;
        if (!request.getParameter("phoneNumber").equals("")) {
            phoneNumber = Long.valueOf(request.getParameter("phoneNumber"));
        }
        customerService.updateAccount(customer, request.getParameter("firstName"), request.getParameter("lastName"), phoneNumber);

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
<h2 style="color:green"> Customer updated successfully!</h2>
<h2> Please log in with the new credentials. </h2>
<form action="login">
    <input type="submit" value="Back to login"/>
</form>
<h3> All customers: </h3>
<table>
    <tr>
        <th>Id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Phone number</th>
    </tr>

    <%
        for (Customer c : customerService.findAll()) {
    %>
    <tr>
        <td><%=c.getId()%>
        </td>
        <td><%=c.getFirstName()%>
        </td>
        <td><%=c.getLastName()%>
        </td>
        <td><%=c.getPhoneNumber()%>
        </td>

    </tr>

    <%
        }
    } catch (Exception e) {%>


    <h1 style="color:red">User could not be updated! <%=e.getMessage()%>
    </h1>
    <%
        }
    %>

</table>
</body>
</html>
