<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Submissions</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>All submissions</h2>

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
        <th>submissionId</th>
        <th>assignmentId</th>
        <th>studentId</th>
        <th>filePath</th>
        <th>submittedOn</th>
    </tr>
    <c:forEach var="a" items="${submissions}">
        <tr>
            <td>${a.submissionId}</td>
            <td>${a.assignmentId}</td>
            <td>${a.studentId}</td>
            <td>${a.filePath}</td>
            <td>${a.submittedOn}</td>
            <td>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
</body>
</html>
