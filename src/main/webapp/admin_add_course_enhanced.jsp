<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codegnan.dao.InstructorDaoImp" %>
<%@ page import="com.codegnan.model.Instructor" %>

<%
    // Fetch instructor list for dropdown
    List<Instructor> instructors = null;
    try {
        InstructorDaoImp instructorDao = new InstructorDaoImp();
        instructors = instructorDao.getAllInstructors();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Course</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="form-container">
    <h2>Add New Course</h2>

    <form action="AdminAddCourseServlet" method="post">
        <label for="title">Course Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="description">Description:</label>
        <textarea id="description" name="description" rows="3"></textarea>

        <label for="instructor_id">Instructor:</label>
        <select id="instructor_id" name="instructor_id" required>
            <option value="">-- Select Instructor --</option>
            <% if (instructors != null) {
                for (Instructor i : instructors) { %>
                    <option value="<%= i.getInstructor_id() %>"><%= i.getName() %></option>
            <%  }
            } %>
        </select>

        <label for="start_date">Start Date:</label>
        <input type="date" id="start_date" name="start_date" required>

        <label for="end_date">End Date:</label>
        <input type="date" id="end_date" name="end_date" required>

        <button type="submit">Add Course</button>
    </form>

    <% if (request.getAttribute("message") != null) { %>
        <div class="message"><%= request.getAttribute("message") %></div>
    <% } %>
</div>

</body>
</html>
