<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>
    <h2>Admin Login</h2>

    <% String error = (String) request.getAttribute("error");
       if (error != null) { %>
       <p style="color:red;"><%= error %></p>
    <% } %>

    <form action="adminauth" method="post">
        <label>Email:</label>
        <input type="email" name="AdminEmail" required><br><br>

        <label>Password:</label>
        <input type="password" name="AdminPassword" required><br><br>

        <button type="submit">Login</button>
    </form>
</body>
</html>
