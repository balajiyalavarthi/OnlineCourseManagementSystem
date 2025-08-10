<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Find Instructor by ID</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Find Instructor by ID</h2>
    
    <form action="adminFindInstructor" method="post">
        <table>
            <tr>
                <td>Instructor ID:</td>
                <td><input type="number" name="instructorId" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Search Instructor" />
                    <a href="admin_dashboard.jsp">Back to Dashboard</a>
                </td>
            </tr>
        </table>
    </form>

    <c:if test="${not empty foundInstructor}">
        <h3>Instructor Found:</h3>
        <table border="1">
            <tr>
                <th>Instructor ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <tr>
                <td>${foundInstructor.instructor_id}</td>
                <td>${foundInstructor.name}</td>
                <td>${foundInstructor.email}</td>
                <td>
                    <a href="adminEditInstructor?id=${foundInstructor.instructor_id}">Edit</a> |
                    <a href="adminDeleteInstructor?id=${foundInstructor.instructor_id}" 
                       onclick="return confirm('Are you sure you want to delete this instructor?')">Delete</a>
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