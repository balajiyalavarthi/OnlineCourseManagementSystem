<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Courses</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>All Courses</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Description</th>
                <th>Instructor</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseId}</td>
                    <td>${course.courseName}</td>
                    <td>${course.courseDiscription}</td>
                    <td>${course.instructorName}</td>
                    <td>${course.startDate}</td>
                    <td>${course.endDate}</td>
                    <td>
                        <a href="adminEditCourse?id=${course.courseId}">Edit</a> |
                        <a href="adminDeleteCourse?courseName=${course.courseName}" 
                           onclick="return confirm('Are you sure you want to delete this course?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br/>
    <a href="admin_dashboard.jsp">Back to Dashboard</a>
</body>
</html>