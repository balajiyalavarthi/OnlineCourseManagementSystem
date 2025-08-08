<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <%
    jakarta.servlet.http.HttpSession sess = request.getSession(false);
        if (sess == null || sess.getAttribute("adminEmail") == null) {
            response.sendRedirect("admin_login.jsp");
            return;
        }
    %>
    <h2>Welcome, Admin: <%= session.getAttribute("adminEmail") %></h2>
    <p>Manage courses, instructors, and students here.</p>

    <a href="logout.jsp">Logout</a>
</body>
</html>
