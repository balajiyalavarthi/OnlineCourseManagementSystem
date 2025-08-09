<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%
    String role = (String) session.getAttribute("role");
    if (role == null || !"ADMIN".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h2>Welcome, Admin!</h2>
    <p>Email: <%= session.getAttribute("userEmail") %></p>

    <ul>
        <li><a href="#">Manage Courses</a></li>
        <li><a href="#">Manage Instructors</a></li>
        <li><a href="#">Manage Students</a></li>
    </ul>

    <a href="logout.jsp">Logout</a>
</body>
</html>
