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
<style>
body {
	font-family: Arial, sans-serif;
	margin: 20px;
}

h2 {
	color: #333;
}

.menu {
	list-style: none;
	padding: 0;
}

.menu li {
	margin-bottom: 10px;
}

.alert {
	padding: 10px;
	margin: 10px 0;
	border-radius: 4px;
}

.alert-success {
	background-color: #dff0d8;
	color: #3c763d;
}

.alert-danger {
	background-color: #f2dede;
	color: #a94442;
}
</style>
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
	<h2>Welcome, Instructor!</h2>
	<p>
		Email:
		<%=session.getAttribute("userEmail")%></p>

	<c:if test="${not empty successMessage}">
		<div class="alert alert-success">${successMessage}</div>
		<c:remove var="successMessage" scope="session" />
	</c:if>
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger">${errorMessage}</div>
		<c:remove var="errorMessage" scope="session" />
	</c:if>

	<h3>Instructor Menu</h3>
	<ul class="menu">
		<li><a href="instructorCourses">View My Courses</a></li>
		<li><a href="add_course.jsp">Add New Course</a></li>
		<li><a href="viewSubmissions">View Student Submissions</a></li>
		<li><a href="editInstructor?id=<%=instructorId%>">Update My
				Profile</a></li>
		<li><a href="assignments?action=viewAll">View All Assignments</a></li>
		<li><a href="add_assignment.jsp">Add New Assignment</a></li>
		<li><a href="viewSubmissions">View Student Submissions</a></li>
		
	</ul>
</body>
</html>