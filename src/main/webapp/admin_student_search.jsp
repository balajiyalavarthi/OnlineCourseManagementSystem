<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Find Student by ID</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Find Student by ID</h2>
    
    <form action="adminFindStudent" method="post">
        <table>
            <tr>
                <td>Student ID:</td>
                <td><input type="number" name="studentId" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Search Student" />
                    <a href="admin_dashboard.jsp">Back to Dashboard</a>
                </td>
            </tr>
        </table>
    </form>

    <c:if test="${not empty foundStudent}">
        <h3>Student Found:</h3>
        <table border="1">
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Enrollment Date</th>
                <th>Actions</th>
            </tr>
            <tr>
                <td>${foundStudent.studentId}</td>
                <td>${foundStudent.name}</td>
                <td>${foundStudent.email}</td>
                <td>${foundStudent.enrollmentDate}</td>
                <td>
                    <a href="adminEditStudent?id=${foundStudent.studentId}">Edit</a> |
                    <a href="adminDeleteStudent?id=${foundStudent.studentId}" 
                       onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                </td>
            </tr>
        </table>
    </c:if>

    <c:if test="${not empty errorMessage}">
        <div style="color: red;">${errorMessage}</div>
        <c:remove var="errorMessage" scope="session" />
    </c:if>
</body>
</html>