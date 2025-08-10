<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Search Student</h2>

<form action="searchstudent" method="get">
    <label>Enter Student ID:</label>
    <input type="text" name="studentId" value="<%= request.getParameter("studentId") != null ? request.getParameter("studentId") : "" %>">
    <input type="submit" value="Search">
</form>

<hr>

<% 
String message = (String) request.getAttribute("message");
if (message != null) {
%>
    <p style="color:red;"><%= message %></p>
<%
}

if (request.getAttribute("studentId") != null) {
%>
    <h3>Student Details</h3>
    <p><strong>ID:</strong> <%= request.getAttribute("studentId") %></p>
    <p><strong>Name:</strong> <%= request.getAttribute("studentName") %></p>
    <p><strong>Email:</strong> <%= request.getAttribute("studentEmail") %></p>
    <p><strong>Enrollment Date:</strong> <%= request.getAttribute("enrollmentDate") %></p>
    
<% 
}
%>

</body>
</html>
