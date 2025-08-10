<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h2>My Enrolled Courses</h2>
<head><link rel="stylesheet" href="css/style.css"></head>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Instructor</th>
        <th>Start Date</th>
        <th>End Date</th>
    </tr>
    <c:forEach var="course" items="${enrolledCourses}">
        <tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.courseDiscription}</td>
            <td>${course.instructorName}</td>
            <td><fmt:formatDate value="${course.startDate}" pattern="MMM dd, yyyy"/></td>
            <td><fmt:formatDate value="${course.endDate}" pattern="MMM dd, yyyy"/></td>
        </tr>
    </c:forEach>
</table>

<a href="student_dashboard.jsp">Back to Dashboard</a>