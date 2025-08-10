<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Admins</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>All Admins</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>Admin ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="admin" items="${admins}">
                <tr>
                    <td>${admin.adminId}</td>
                    <td>${admin.name}</td>
                    <td>${admin.email}</td>
                    <td>
                        <a href="editAdmin?id=${admin.adminId}">Edit</a> |
                        <a href="deleteAdmin?id=${admin.adminId}" 
                           onclick="return confirm('Are you sure you want to delete this admin?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br/>
    <a href="admin_dashboard.jsp">Back to Dashboard</a>
</body>
</html>

