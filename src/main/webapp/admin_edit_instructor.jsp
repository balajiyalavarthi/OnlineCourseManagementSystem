<!-- admin_edit_instructor.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Instructor</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Edit Instructor</h2>
    
    <form action="adminEditInstructor" method="post">
        <input type="hidden" name="instructorId" value="${instructor.instructor_id}" />
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${instructor.name}" required /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" value="${instructor.email}" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" value="${instructor.password}" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update Instructor" />
                    <a href="admin_dashboard.jsp">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
