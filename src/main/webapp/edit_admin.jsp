<!-- edit_admin.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Admin</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Edit Admin Profile</h2>
    
    <form action="editAdmin" method="post">
        <input type="hidden" name="adminId" value="${admin.adminId}" />
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${admin.name}" required /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" value="${admin.email}" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" value="${admin.password}" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update Admin" />
                    <a href="admin_dashboard.jsp">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

