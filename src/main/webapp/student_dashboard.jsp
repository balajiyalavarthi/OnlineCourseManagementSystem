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
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #333;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        ul li {
            margin-bottom: 8px;
        }
        a {
            text-decoration: none;
            color: blue;
        }
        a:hover {
            text-decoration: underline;
        }
        .logout {
            margin-top: 20px;
            display: inline-block;
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h2>Welcome, Student!</h2>
    <p>Email: <%= session.getAttribute("userEmail") %></p>

    <h3>Student Menu</h3>
    <ul>
        <li><a href="listStudents">View All Students</a></li>
        <li><a href="editstudent?id=<%= userId %>">Update My Profile</a></li>
        <li><a href="student_search.jsp">Search Other Students</a></li>
        <li><a href="courseList">View All Courses</a></li>
		<li><a href="myCourses">View My Enrolled Courses</a></li>
        <li><a href="viewGrades?studentId=<%= userId %>">View My Grades</a></li>
        <li><a href="deleteStudent?id=<%= userId %>" 
               onclick="return confirm('Are you sure you want to delete your account?')">Delete My Account</a></li>
    </ul>

    <a class="logout" href="logout.jsp">Logout</a>
</body>
</html>
