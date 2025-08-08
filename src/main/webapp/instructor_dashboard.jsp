<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Instructor Dashboard</title>
</head>
<body>
    <%
        HttpSession sess = request.getSession(false);
        if (session == null || session.getAttribute("instructorEmail") == null) {
            response.sendRedirect("instructor_login.jsp");
            return;
        }
    %>
    <h2>Welcome, Instructor: <%= session.getAttribute("instructorEmail") %></h2>
    <p>Manage your courses and view enrolled students.</p>

    <a href="logout.jsp">Logout</a>
</body>
</html>
