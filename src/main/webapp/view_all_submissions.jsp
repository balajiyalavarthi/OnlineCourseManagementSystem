<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Student Submissions</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; }
        th { background-color: #f2f2f2; }
        a { text-decoration: none; color: blue; }
    </style>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>All Student Submissions</h2>

<c:if test="${empty submissions}">
    <p>No submissions found.</p>
</c:if>

<c:if test="${not empty submissions}">
    <table>
        <tr>
            <th>Submission ID</th>
            <th>Course</th>
            <th>Assignment</th>
            <th>Student</th>
            <th>File</th>
            <th>Submitted On</th>
        </tr>
        <c:forEach var="s" items="${submissions}">
            <tr>
                <td>${s.submissionId}</td>
                <td>${s.courseName}</td>
                <td>${s.assignmentTitle}</td>
                <td>${s.studentName} (ID: ${s.studentId})</td>
                <td><a href="${pageContext.request.contextPath}/${s.filePath}" target="_blank">Download</a></td>
                <td>${s.submittedOn}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<a href="instructor_dashboard.jsp">Back to Dashboard</a>
</body>
</html>
