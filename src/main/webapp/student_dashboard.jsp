<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codegnan.model.Assignment" %>
<%@ page import="com.codegnan.model.Submission" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String role = (String) session.getAttribute("role");
    if (role == null || !"STUDENT".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }
    Integer studentId = (Integer) session.getAttribute("studentId");
    if (studentId == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Student Dashboard</title>
    
    <link rel="stylesheet" href="css/style.css">
</head>

<body>
    <h2>Welcome, Student!</h2>
    <p>Email: <%= session.getAttribute("userEmail") %></p>

    <h3>Student Menu</h3>
    <ul>
        <li><a href="listStudents">View All Students</a></li>
        <li><a href="editstudent?id=${studentId}">Update My Profile</a></li>
        <li><a href="student_search.jsp">Search Other Students</a></li>
        <li><a href="courseList">View All Courses</a></li>
        <li><a href="myCourses">My Courses</a></li>
        <li><a href="studentAssignments">My Assignments</a></li>
        <li><a href="studentsubmissions">My Submissions</a></li>
        <li><a href="viewGrades?studentId=${studentId}">My Grades</a></li>
        <li><a href="deleteStudent?id=${studentId}" onclick="return confirm('Are you sure you want to delete your account?')">Delete My Account</a></li>
    </ul>



    <a class="logout" href="logout.jsp">Logout</a>
</body>
</html>
