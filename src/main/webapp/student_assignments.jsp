<%@ page import="java.sql.*, com.codegnan.DbConnection.DbConnection" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession sess = request.getSession();
    int studentId = (int) sess.getAttribute("studentId");

    Connection conn = DbConnection.getConnection();
    PreparedStatement ps = conn.prepareStatement(
        "SELECT id, course_id, title, description, due_date, status FROM assignments WHERE student_id = ?");
    ps.setInt(1, studentId);
    ResultSet rs = ps.executeQuery();
%>
<head>
<link rel="stylesheet" href="css/style.css">
</head>
<h2>My Assignments</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Course ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Due Date</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
<%
    while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getInt("course_id") %></td>
        <td><%= rs.getString("title") %></td>
        <td><%= rs.getString("description") %></td>
        <td><%= rs.getDate("due_date") %></td>
        <td><%= rs.getString("status") %></td>
        <td>
            <form action="submitAssignment" method="post">
                <input type="hidden" name="assignmentId" value="<%= rs.getInt("id") %>">
                <button type="submit">Submit</button>
            </form>
        </td>
    </tr>
<%
    }
    rs.close();
    ps.close();
    conn.close();
%>
</table>
<a href="student_dashboard.jsp">Back to Dashboard</a>
