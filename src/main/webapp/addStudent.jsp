<%@ include file="header.jsp" %>
<h2>Add New Student</h2>
<form action="StudentServlet" method="post">
    <input type="hidden" name="action" value="add">

    <label>Student Name:</label><br>
    <input type="text" name="studentName" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="studentEmail" required><br><br>

    <label>Courses (comma separated):</label><br>
    <input type="text" name="listOfStudentCourses" placeholder="e.g., Java, Python"><br><br>

    <input type="submit" value="Add Student">
</form>
<%@ include file="footer.jsp" %>
