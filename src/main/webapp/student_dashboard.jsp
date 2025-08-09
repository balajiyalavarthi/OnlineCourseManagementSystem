<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%
    String role = (String) session.getAttribute("role");
    if (role == null || !"STUDENT".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Student Dashboard</title>
</head>
<body>
    <h2>Welcome, Student!</h2>
    <p>Email: <%= session.getAttribute("userEmail") %></p>

    <ul>
        <li><a href="#">View My Courses</a></li>
        <li><a href="#">View Assignments</a></li>
        <li><a href="#">Submit Assignment</a></li>
    </ul>

    <a href="logout.jsp">Logout</a>
</body>
</html>
