<!-- register_student.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Instructor Registration</title>
</head>
<body>
<h2>Register as New Instructor</h2>
<form action="registerinstructor" method="post">
    <p>Name: <input type="text" name="name" required></p>
    <p>Email: <input type="email" name="email" required></p>
    <p>Password: <input type="password" name="password" required></p>
    <p><input type="submit" value="Register"></p>
</form>
<p>Already have an account? <a href="login.jsp">Login here</a></p>
</body>
</html>
