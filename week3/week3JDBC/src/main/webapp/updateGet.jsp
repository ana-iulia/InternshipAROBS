<%@ page import="com.internshipArobs.servlet.service.CustomerService" %>
<%@ page import="com.internshipArobs.servlet.domain.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session = request.getSession(false);
    Customer oldCustomer = (Customer) session.getAttribute("customer");

%>
<!Doctype html>
<head>
</head>
<body>
<h3>AICIIIII</h3>
<h3>
    <%
        String.join(" ", oldCustomer.getFirstName(), oldCustomer.getLastName(), String.valueOf(oldCustomer.getPhoneNumber()));
    %>
</h3>
<h3>
    <%
        session.getAttribute("customer");
    %>
</h3>
<form action="updateAccount" method="post">
    First name:<br/><input type="text" name="firstName"/><br/><br/>
    Last name:<br/><input type="text" name="lastName"/><br/><br/>
    Phone number:<br/><input type="password" name="phoneNumber"/><br/><br/><br/>
    <input type="submit" value=" Update "/>
</form>
</body>
</html>
