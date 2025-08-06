<%@ include file="header.jsp" %>
<h2>Edit Student Details</h2>
<form action="StudentServlet" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="studentId" value="${student.studentId}">

    <label>Student Name:</label><br>
    <input type="text" name="studentName" value="${student.studentName}" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="studentEmail" value="${student.studentEmail}" required><br><br>

    <label>Courses (comma separated):</label><br>
    <input type="text" name="listOfStudentCourses" value="${student.listOfStudentCourses}" placeholder="e.g., Java, Python"><br><br>

    <input type="submit" value="Update Student">
</form>
<%@ include file="footer.jsp" %>
