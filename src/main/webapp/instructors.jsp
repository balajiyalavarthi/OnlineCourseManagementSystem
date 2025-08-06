<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Instructor List</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Assigned Course</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="instructor" items="${instructorList}">
        <tr>
            <td>${instructor.instructorId}</td>
            <td>${instructor.instructorName}</td>
            <td>${instructor.instructorEmail}</td>
            <td>${instructor.instructorCourse}</td>
            <td>
                <a href="InstructorServlet?action=edit&id=${instructor.instructorId}">Edit</a> |
                <a href="InstructorServlet?action=delete&id=${instructor.instructorId}" onclick="return confirm('Delete this instructor?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="addInstructor.jsp">Add New Instructor</a>
<%@ include file="footer.jsp" %>
