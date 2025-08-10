<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String role = (String) session.getAttribute("role");
if (role == null || !"ADMIN".equals(role)) {
    response.sendRedirect("login.jsp");
    return;
}
Integer adminId = (Integer) session.getAttribute("adminId");
if (adminId == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>
<html>
<head>
<title>Admin Dashboard</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="dashboard">
    <h2>Welcome, Admin!</h2>
    <p>Email: <%= session.getAttribute("userEmail") %></p>

    <c:if test="${not empty successMessage}">
        <div class="alert alert-success">${successMessage}</div>
        <c:remove var="successMessage" scope="session" />
    </c:if>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
        <c:remove var="errorMessage" scope="session" />
    </c:if>

    <h3>Admin Management</h3>
    <div class="card-container">
        <div class="card"><a href="adminList">View All Admins</a></div>
        <div class="card"><a href="add_admin.jsp">Add New Admin</a></div>
        <div class="card"><a href="editAdmin?id=<%=adminId%>">Edit My Profile</a></div>
        <div class="card"><a href="deleteAdmin?id=<%=adminId%>" onclick="return confirm('Are you sure?')">Delete My Account</a></div>
    </div>

    <h3>Course Management</h3>
    <div class="card-container">
        <div class="card"><a href="adminCourseList">View All Courses</a></div>
        <div class="card"><a href="admin_add_course.jsp">Add New Course</a></div>
        <div class="card"><a href="admin_course_search.jsp">Search Course</a></div>
    </div>

    <h3>Student Management</h3>
    <div class="card-container">
        <div class="card"><a href="adminStudentList">View All Students</a></div>
        <div class="card"><a href="admin_add_student.jsp">Add New Student</a></div>
        <div class="card"><a href="admin_student_search.jsp">Find Student by ID</a></div>
    </div>

    <h3>Instructor Management</h3>
    <div class="card-container">
        <div class="card"><a href="adminInstructorList">View All Instructors</a></div>
        <div class="card"><a href="admin_add_instructor.jsp">Add New Instructor</a></div>
        <div class="card"><a href="admin_instructor_search.jsp">Find Instructor by ID</a></div>
    </div>

    <p><a class="logout" href="logout.jsp">Logout</a></p>
</div>
</body>
</html>
