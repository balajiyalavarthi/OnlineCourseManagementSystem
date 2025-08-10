<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Course Search Result</title></head>
<body>
<h2>Course Search Result</h2>
<c:if test="${course != null}">
    <p><strong>ID:</strong> ${course.courseId}</p>
    <p><strong>Title:</strong> ${course.courseName}</p>
    <p><strong>Description:</strong> ${course.courseDiscription}</p>
    <p><strong>Instructor:</strong> ${course.instructorName}</p>
    <p><strong>Start Date:</strong> ${course.startDate}</p>
    <p><strong>End Date:</strong> ${course.endDate}</p>
<else>
    <p>No course found with that name.</p>
</c:if>
</body>
</html>
