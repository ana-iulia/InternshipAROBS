<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<head>
</head>
<body>
<h1><%=session.getServletContext().getAttribute("register")%> Registration Form </h1>
<form action="register" method="post">
    First name:<br/><input type="text" name="firstName"/><br/><br/>
    Last name:<br/><input type="text" name="lastName"/><br/><br/>
    Phone number:<br/><input type="password" name="phoneNumber"/><br/><br/><br/>
    <input type="submit" value=" Register "/>
</form>
</body>
</html>
