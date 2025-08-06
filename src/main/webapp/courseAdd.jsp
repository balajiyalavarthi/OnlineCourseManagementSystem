<%@ include file="header.jsp" %>
<h2>Add New Course</h2>
<form action="CourseServlet" method="post">
    <input type="hidden" name="action" value="add">
    <label>Course Name:</label><br>
    <input type="text" name="courseName" required><br><br>

    <label>Course Price:</label><br>
    <input type="number" step="0.01" name="coursePrice" required><br><br>

    <label>Description:</label><br>
    <textarea name="courseDescription" rows="3" required></textarea><br><br>

    <label>Instructor Name:</label><br>
    <input type="text" name="instructorName" required><br><br>

    <input type="submit" value="Add Course">
</form>
<%@ include file="footer.jsp" %>
