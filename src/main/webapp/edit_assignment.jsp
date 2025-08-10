<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.codegnan.model.Assignment" %>
<%
    Assignment a = (Assignment) request.getAttribute("assignment");
%>
<html>
<head><title>Edit Assignment</title>
<link rel="stylesheet" href="css/style.css"></head>
<body>
<h2>Edit Assignment</h2>
<form action="assignments" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="assignmentId" value="<%= a.getAssignmentId() %>">

    <label>Course ID:</label>
    <input type="number" name="courseId" value="<%= a.getCourseId() %>" required><br><br>

    <label>Title:</label>
    <input type="text" name="title" value="<%= a.getTitle() %>" required><br><br>

    <label>Description:</label>
    <textarea name="description" required><%= a.getDescription() %></textarea><br><br>

    <label>Due Date:</label>
    <input type="date" name="dueDate" value="<%= a.getDueDate() %>" required><br><br>

    <button type="submit">Update</button>
</form>
</body>
</html>
