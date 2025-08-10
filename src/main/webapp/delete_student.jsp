<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String idParam = request.getParameter("id");
    if (idParam == null) {
%>
        <h3>⚠️ No student ID provided.</h3>
        <a href="listStudents">🔙 Back to Student List</a>
<%
    } else {
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Delete Student</h2>
    <p>Are you sure you want to delete the student with ID: <strong><%= idParam %></strong>?</p>

    <form action="deleteStudent" method="get">
        <input type="hidden" name="id" value="<%= idParam %>">
        <input type="submit" value="✅ Yes, Delete">
    </form>

    <br>
    <a href="listStudents">❌ Cancel</a>
</body>
</html>
<%
    }
%>
