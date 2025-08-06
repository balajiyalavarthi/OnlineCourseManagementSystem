<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Student List</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Enrolled Courses</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.studentName}</td>
            <td>${student.studentEmail}</td>
            <td>
                <c:forEach var="course" items="${student.listOfStudentCourses}">
                    ${course}<br>
                </c:forEach>
            </td>
            <td>
                <a href="StudentServlet?action=edit&id=${student.studentId}">Edit</a> |
                <a href="StudentServlet?action=delete&id=${student.studentId}" onclick="return confirm('Delete this student?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="addStudent.jsp">Add New Student</a>
<%@ include file="footer.jsp" %>
