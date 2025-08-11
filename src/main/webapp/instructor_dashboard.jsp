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
		<li><a href="logout.jsp">Logout</a></li>
	</ul>
</body>
</html>