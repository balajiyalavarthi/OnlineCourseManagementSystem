<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.codegnan.model.Student" %>
<%
    Student student = (Student) request.getAttribute("student");
    if (student == null) {
        out.println("<p>No student data to edit.</p>");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Edit Student</h2>
<form action="editstudent" method="post">
    <input type="hidden" name="id" value="<%= student.getStudentId() %>">
    <p>Name: <input type="text" name="name" value="<%= student.getName() %>" required></p>
    <p>Email: <input type="email" name="email" value="<%= student.getEmail() %>" required></p>
    <p>Password: <input type="password" name="password" value="<%= student.getPassword() %>" required></p>
    <p>Enrollment Date: <input type="date" name="enrollmentDate" value="<%= student.getEnrollmentDate() %>" required></p>
    <p><input type="submit" value="Update Student"></p>
</form>
</body>
</html>
