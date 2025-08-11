<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Search Course</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Search Course by ID</h2>
    
    <form action="adminFindCourse" method="post">
        <table>
            <tr>
                <td>Course ID:</td>
                <td><input type="number" name="courseId" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Search Course" />
                    <a href="admin_dashboard.jsp">Back to Dashboard</a>
                </td>
            </tr>
        </table>
    </form>

    <c:if test="${not empty foundCourse}">
        <h3>Course Found:</h3>
        <table border="1">
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Description</th>
                <th>Instructor</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Actions</th>
            </tr>
            <tr>
                <td>${foundCourse.courseId}</td>
                <td>${foundCourse.courseName}</td>
                <td>${foundCourse.courseDiscription}</td>
                <td>${foundCourse.instructorId}</td>
                <td>${foundCourse.startDate}</td>
                <td>${foundCourse.endDate}</td>
                <td>
                    <a href="adminEditCourse?id=${foundCourse.courseId}">Edit</a> |
                    <a href="adminDeleteCourse?courseName=${foundCourse.courseName}" 
                       onclick="return confirm('Are you sure you want to delete this course?')">Delete</a>
                </td>
            </tr>
        </table>
    </c:if>

    <c:if test="${not empty errorMessage}">
        <div style="color: red;">${errorMessage}</div>
        <c:remove var="errorMessage" scope="session" />
    </c:if>
</body>
</html>