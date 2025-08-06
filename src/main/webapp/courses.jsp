<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Available Courses</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Instructor</th>
        <th>Students Enrolled</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="course" items="${courseList}">
        <tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.coursePrice}</td>
            <td>${course.courseDescription}</td>
            <td>${course.instructorName}</td>
            <td>
                <c:forEach var="student" items="${course.listOfStudentsNames}">
                    ${student}<br>
                </c:forEach>
            </td>
            <td>
                <a href="CourseServlet?action=edit&id=${course.courseId}">Edit</a> |
                <a href="CourseServlet?action=delete&id=${course.courseId}" onclick="return confirm('Delete this course?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="addCourse.jsp">Add New Course</a>
<%@ include file="footer.jsp" %>
