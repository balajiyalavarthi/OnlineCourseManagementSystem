<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Edit Student</h2>
    
    <form action="adminEditStudent" method="post">
        <input type="hidden" name="studentId" value="${student.studentId}" />
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${student.name}" required /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" value="${student.email}" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" value="${student.password}" required /></td>
            </tr>
            <tr>
                <td>Enrollment Date:</td>
                <td><input type="date" name="enrollmentDate" value="${student.enrollmentDate}" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update Student" />
                    <a href="admin_dashboard.jsp">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
