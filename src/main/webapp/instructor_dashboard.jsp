<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
Integer instructorId = (Integer) session.getAttribute("instructorId");
if (instructorId == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<html>
<head>
<title>Instructor Dashboard</title>
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
    <h2>Welcome, Instructor!</h2>
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
            <%=session.getAttribute("userEmail")%>
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
        <div class="card"><a href="editInstructor?id=<%=instructorId%>">Update My Profile</a></div>
    </div>

    <h3>Course Management</h3>
    <div class="card-container">
        <div class="card"><a href="instructorCourses">View My Courses</a></div>
        <div class="card"><a href="add_course.jsp">Add New Course</a></div>
    </div>

    <h3>Assignment Management</h3>
    <div class="card-container">
        <div class="card"><a href="assignments?action=viewAll">View All Assignments</a></div>
        <div class="card"><a href="add_assignment.jsp">Add New Assignment</a></div>
    </div>

    <h3>Student Evaluation</h3>
    <div class="card-container">
        <div class="card"><a href="viewSubmissions">View Student Submissions</a></div>
    </div>

    
</div>
</body>
</html>