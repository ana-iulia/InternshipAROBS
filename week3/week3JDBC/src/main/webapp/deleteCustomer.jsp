<%@ page import="com.internshipArobs.servlet.domain.User" %>
<%@ page import="com.internshipArobs.servlet.service.UserService" %>
<%@ page import="com.internshipArobs.servlet.service.CustomerService" %>
<%@ page import="com.internshipArobs.servlet.domain.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CustomerService customerService = (CustomerService) session.getServletContext().getAttribute("customerService");
    Customer customer = (Customer) session.getAttribute("customer");
    try {
        customerService.deleteAccount(customer.getId());

%>
<!Doctype html>

<body>
<h2 style="color:green"> Account deleted successfully!</h2>
<form action="login">
    <input type="submit" value="Back to Login page"/>
</form>
<%
} catch (Exception e) {%>


<h1 style="color:red">Account could not be deleted! <%=e.getMessage()%>
</h1>
<%
    }
%>


</body>
</html>
