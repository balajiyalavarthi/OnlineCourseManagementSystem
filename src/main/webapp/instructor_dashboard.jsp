<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%
    String role = (String) session.getAttribute("role");
    if (role == null || !"INSTRUCTOR".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Instructor Dashboard</title>
</head>
<body>
    <h2>Welcome, Instructor!</h2>
    <p>Email: <%= session.getAttribute("userEmail") %></p>

    <ul>
        <li><a href="#">View My Courses</a></li>
        <li><a href="#">Create Assignment</a></li>
        <li><a href="#">Grade Submissions</a></li>
    </ul>

    <a href="logout.jsp">Logout</a>
</body>
</html>
