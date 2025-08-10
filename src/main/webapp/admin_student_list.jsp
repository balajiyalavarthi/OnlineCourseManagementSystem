<!-- admin_student_list.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Students</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>All Students</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Enrollment Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.studentId}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.enrollmentDate}</td>
                    <td>
                        <a href="adminEditStudent?id=${student.studentId}">Edit</a> |
                        <a href="adminDeleteStudent?id=${student.studentId}" 
                           onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br/>
    <a href="admin_dashboard.jsp">Back to Dashboard</a>
</body>
</html>
