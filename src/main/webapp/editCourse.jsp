<%@ include file="header.jsp" %>
<h2>Edit Course</h2>
<form action="CourseServlet" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="courseId" value="${course.courseId}">

    <label>Course Name:</label><br>
    <input type="text" name="courseName" value="${course.courseName}" required><br><br>

    <label>Course Price:</label><br>
    <input type="number" step="0.01" name="coursePrice" value="${course.coursePrice}" required><br><br>

    <label>Description:</label><br>
    <textarea name="courseDescription" rows="3">${course.courseDescription}</textarea><br><br>

    <label>Instructor Name:</label><br>
    <input type="text" name="instructorName" value="${course.instructorName}" required><br><br>

    <input type="submit" value="Update Course">
</form>
<%@ include file="footer.jsp" %>
