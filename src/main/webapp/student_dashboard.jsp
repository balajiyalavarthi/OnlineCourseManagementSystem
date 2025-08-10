<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%
    String role = (String) session.getAttribute("role");
    if (role == null || !"STUDENT".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }
    Integer userId = (Integer) session.getAttribute("userId");
    if (userId == null) {
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

    <h3>Student Menu</h3>
    <ul>
        <li><a href="listStudents">View All Students</a></li>
        <li><a href="editstudent?id=<%= userId %>">Update My Profile</a></li>
        <li><a href="student_search.jsp">Search other students</a></li>
        <li><a href="deleteStudent?id=<%= userId %>" onclick="return confirm('Are you sure you want to delete your account?')">Delete My Account</a></li>
    </ul>

    <a href="logout.jsp">Logout</a>
</body>
</html>
