<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    Integer instructorId = (Integer) session.getAttribute("instructorId");
    if (instructorId == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>My Courses</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .btn { padding: 5px 10px; text-decoration: none; }
        .btn-primary { background-color: #337ab7; color: white; }
    </style>
</head>
<body>
    <h2>My Courses</h2>
    <a href="add_course.jsp" class="btn btn-primary">Add New Course</a>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Course Name</th>
            <th>Description</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>${course.courseDiscription}</td>
                <td><fmt:formatDate value="${course.startDate}" pattern="MMM dd, yyyy"/></td>
                <td><fmt:formatDate value="${course.endDate}" pattern="MMM dd, yyyy"/></td>
                <td>
                    <a href="viewAssignments?courseId=${course.courseId}" class="btn btn-primary">View Assignments</a>
                    <a href="editCourse?id=${course.courseId}" class="btn btn-primary">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="instructorDashboard">Back to Dashboard</a>
</body>
</html>