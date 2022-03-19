<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<head>
</head>
<body>
<h1><%=session.getServletContext().getAttribute("register")%> Registration Form </h1>
<form action="register" method="post">
    Name:<br/><input type="text" name="userName"/><br/><br/>
    Email:<br/><input type="text" name="userEmail"/><br/><br/>
    Password:<br/><input type="password" name="userPass"/><br/><br/><br/>
    <input type="submit" value=" Register "/>
</form>
</body>
</html>
