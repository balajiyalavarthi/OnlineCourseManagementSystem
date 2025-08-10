<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>

<html>
<head>
    <title>Add New Admin</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Add New Admin</h2>
    
    <form action="addAdmin" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" required /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add Admin" />
                    <a href="admin_dashboard.jsp">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

