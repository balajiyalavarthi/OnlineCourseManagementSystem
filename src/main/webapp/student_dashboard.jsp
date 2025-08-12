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
<p style="position:absolute; top:15px; right:20px; margin:0;">
    <a class="logout" href="logout.jsp" 
       style="display:inline-block; padding:10px 18px; background:linear-gradient(135deg, #667eea, #764ba2); 
              color:white; font-weight:bold; text-decoration:none; border-radius:8px; 
              box-shadow:0 4px 10px rgba(0,0,0,0.15); transition:all 0.3s ease; 
              font-family:'Segoe UI', sans-serif; letter-spacing:0.5px;">
        Logout
    </a>
</p>

<script>
    // Add hover effect dynamically (since inline can't handle pseudo-classes)
    document.querySelector('.logout').addEventListener('mouseover', function() {
        this.style.transform = 'scale(1.05)';
        this.style.boxShadow = '0 6px 14px rgba(0,0,0,0.2)';
    });
    document.querySelector('.logout').addEventListener('mouseout', function() {
        this.style.transform = 'scale(1)';
        this.style.boxShadow = '0 4px 10px rgba(0,0,0,0.15)';
    });
</script>

<div class="dashboard">
    <h2>Welcome, Student!</h2>
    <p style="display:inline-block; padding:10px 20px; 
          background:rgba(0, 123, 255, 0.25); 
          color:rgba(255,255,255,0.85); 
          font-weight:bold; 
          border-radius:12px; 
          backdrop-filter:blur(8px); 
          -webkit-backdrop-filter:blur(8px); 
          box-shadow:0 4px 20px rgba(0,0,0,0.15); 
          border:1px solid rgba(255,255,255,0.3);
          font-family:'Segoe UI', sans-serif;
          letter-spacing:0.5px;
          text-shadow:0 1px 2px rgba(0,0,0,0.3);">
        <span style="color:rgba(255,255,255,0.85); text-shadow:0 1px 2px rgba(0,0,0,0.3);">
            <%= session.getAttribute("userEmail") %>
        </span>
    </p>
    

    <c:if test="${not empty successMessage}">
        <div class="alert alert-success">${successMessage}</div>
        <c:remove var="successMessage" scope="session" />
    </c:if>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
        <c:remove var="errorMessage" scope="session" />
    </c:if>

    <h3>Profile Management</h3>
    <div class="card-container">
        <div class="card"><a href="editstudent?id=${studentId}">Update My Profile</a></div>
        <div class="card"><a href="listStudents">View All Students</a></div>
        <div class="card"><a href="student_search.jsp">Search Other Students</a></div>
        <div class="card"><a href="deleteStudent?id=${studentId}" onclick="return confirm('Are you sure you want to delete your account?')">Delete My Account</a></div>
    </div>

    <h3>Course Management</h3>
    <div class="card-container">
        <div class="card"><a href="courseList">View All Courses</a></div>
        <div class="card"><a href="myCourses">My Enrolled Courses</a></div>
    </div>

    <h3>Academic Activities</h3>
    <div class="card-container">
        <div class="card"><a href="studentAssignments">My Assignments</a></div>
        <div class="card"><a href="studentsubmissions">My Submissions</a></div>
        <div class="card"><a href="viewGrades?studentId=${studentId}">My Grades</a></div>
    </div>

    
</div>
</body>
</html>