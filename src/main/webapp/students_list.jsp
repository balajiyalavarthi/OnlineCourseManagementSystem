<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.codegnan.model.Student" %>
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Student List</h2>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <%
        if (students != null) {
            for (Student s : students) {
    %>
    <tr>
        <td><%= s.getStudentId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr><td colspan="6">No students found</td></tr>
    <% } %>
</table>
</body>
</html>
