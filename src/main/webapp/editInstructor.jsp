<%@ include file="header.jsp" %>
<h2>Edit Instructor Details</h2>
<form action="InstructorServlet" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="instructorId" value="${instructor.instructorId}">

    <label>Instructor Name:</label><br>
    <input type="text" name="instructorName" value="${instructor.instructorName}" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="instructorEmail" value="${instructor.instructorEmail}" required><br><br>

    <label>Course Assigned:</label><br>
    <input type="text" name="instructorCourse" value="${instructor.instructorCourse}" required><br><br>

    <input type="submit" value="Update Instructor">
</form>
<%@ include file="footer.jsp" %>
