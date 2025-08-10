<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Instructors</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>All Instructors</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>Instructor ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="instructor" items="${instructors}">
                <tr>
                    <td>${instructor.instructor_id}</td>
                    <td>${instructor.name}</td>
                    <td>${instructor.email}</td>
                    <td>
                        <a href="adminEditInstructor?id=${instructor.instructor_id}">Edit</a> |
                        <a href="adminDeleteInstructor?id=${instructor.instructor_id}" 
                           onclick="return confirm('Are you sure you want to delete this instructor?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br/>
    <a href="admin_dashboard.jsp">Back to Dashboard</a>
</body>
</html>

