<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Login</title>
</head>
<body>
    <h2>Student Login</h2>

    <% String error = (String) request.getAttribute("error");
       if (error != null) { %>
       <p style="color:red;"><%= error %></p>
    <% } %>

    <form action="studentauth" method="post">
        <label>Email:</label>
        <input type="email" name="studentEmail" required><br><br>

        <label>Password:</label>
        <input type="password" name="studentPassword" required><br><br>

        <button type="submit">Login</button>
    </form>
</body>
</html>
