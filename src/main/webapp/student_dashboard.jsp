<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
</head>
<body>
    <%
        HttpSession sess = request.getSession(false);
        if (session == null || session.getAttribute("studentEmail") == null) {
            response.sendRedirect("student_login.jsp");
            return;
        }
    %>
    <h2>Welcome, Student: <%= session.getAttribute("studentEmail") %></h2>
    <p>View available courses and track your progress.</p>

    <a href="logout.jsp">Logout</a>
</body>
</html>
