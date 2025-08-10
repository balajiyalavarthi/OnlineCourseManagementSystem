<%@ page import="com.codegnan.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Details</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Student Details</h2>
<%
    Student s = (Student) request.getAttribute("student");
    if (s != null) {
%>
    <p><b>ID:</b> <%= s.getStudentId() %></p>
    <p><b>Name:</b> <%= s.getName() %></p>
    <p><b>Email:</b> <%= s.getEmail() %></p>
    
<%
    } else {
%>
    <p>No student found.</p>
<%
    }
%>
</body>
</html>
