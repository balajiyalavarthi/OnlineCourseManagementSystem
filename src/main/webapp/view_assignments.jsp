<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Assignments</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>All Assignments</h2>

<c:if test="${not empty successMessage}">
    <div style="color:green;">${successMessage}</div>
    <c:remove var="successMessage" scope="session"/>
</c:if>
<c:if test="${not empty errorMessage}">
    <div style="color:red;">${errorMessage}</div>
    <c:remove var="errorMessage" scope="session"/>
</c:if>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Course ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Due Date</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="a" items="${assignmentList}">
        <tr>
            <td>${a.assignmentId}</td>
            <td>${a.courseId}</td>
            <td>${a.title}</td>
            <td>${a.description}</td>
            <td>${a.dueDate}</td>
            <td>
                <a href="assignments?action=edit&id=${a.assignmentId}">Edit</a> |
                <a href="assignments?action=delete&id=${a.assignmentId}" onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
</body>
</html>
