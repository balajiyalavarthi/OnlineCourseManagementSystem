<%@ include file="header.jsp" %>
<h2>Add New Instructor</h2>
<form action="InstructorServlet" method="post">
    <input type="hidden" name="action" value="add">

    <label>Instructor Name:</label><br>
    <input type="text" name="instructorName" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="instructorEmail" required><br><br>

    <label>Course Assigned:</label><br>
    <input type="text" name="instructorCourse" required><br><br>

    <input type="submit" value="Add Instructor">
</form>
<%@ include file="footer.jsp" %>
