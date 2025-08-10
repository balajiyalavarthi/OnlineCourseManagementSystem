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
    <title>Add New Assignment</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Add New Assignment</h2>
    <form action="addAssignment" method="post">
        <label>Course ID:</label>
        <input type="number" name="courseId" required><br><br>

        <label>Title:</label>
        <input type="text" name="title" required><br><br>

        <label>Description:</label>
        <textarea name="description" required></textarea><br><br>

        <label>Due Date:</label>
        <input type="date" name="dueDate" required><br><br>

        <button type="submit">Add Assignment</button>
    </form>
</body>
</html>
