<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%
    Integer instructorId = (Integer) session.getAttribute("instructorId");
    if (instructorId == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Add New Course</title>
    <style>
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 150px; }
        input[type="text"], input[type="date"], textarea {
            width: 300px; padding: 5px;
        }
        .btn { padding: 5px 15px; }
    </style>
</head>
<body>
    <h2>Add New Course</h2>
    <form action="addCourse" method="post">
        <div class="form-group">
            <label for="courseName">Course Name:</label>
            <input type="text" id="courseName" name="courseName" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4" required></textarea>
        </div>
        <div class="form-group">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" required>
        </div>
        <div class="form-group">
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" required>
        </div>
        <div class="form-group">
            <input type="submit" value="Add Course" class="btn">
            <a href="instructorCourses" class="btn">Cancel</a>
        </div>
    </form>
</body>
</html>
