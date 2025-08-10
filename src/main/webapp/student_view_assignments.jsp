<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codegnan.model.Assignment" %>
<%@ page import="com.codegnan.model.Submission" %>
<head><link rel="stylesheet" href="css/style.css"></head>
<%
    String role = (String) session.getAttribute("role");
    if (role == null || !"STUDENT".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }
    Integer studentId = (Integer) session.getAttribute("studentId");
    if (studentId == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Assignment> assignmentList = (List<Assignment>) request.getAttribute("assignmentList");
    List<Submission> mySubmissions = (List<Submission>) request.getAttribute("mySubmissions");
%>

<html>
<head>
    <title>My Assignments</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 100%; }
        table, th, td { border: 1px solid #ccc; padding: 8px; }
    </style>
</head>

<body>
    <h2>My Assignments</h2>
    <table>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Due Date</th>
            <th>Action</th>
        </tr>
        <%
            if (assignmentList != null) {
                for (Assignment a : assignmentList) {
                    boolean alreadySubmitted = false;
                    if (mySubmissions != null) {
                        for (Submission s : mySubmissions) {
                            if (s.getAssignmentId() == a.getAssignmentId() && s.getStudentId() == studentId) {
                                alreadySubmitted = true;
                                break;
                            }
                        }
                    }
        %>
        <tr>
            <td><%= a.getTitle() %></td>
            <td><%= a.getDescription() %></td>
            <td><%= a.getDueDate() %></td>
            <td>
                <% if (!alreadySubmitted) { %>
                    <form action="submitAssignment" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="assignmentId" value="<%= a.getAssignmentId() %>">
                        <input type="hidden" name="studentId" value="<%= studentId %>">
                        <input type="file" name="assignmentFile" required>
                        <button type="submit">Upload</button>
                    </form>
                <% } else { %>
                    ✅ Submitted
                <% } %>
            </td>
        </tr>
        <% 
                }
            }
        %>
    </table>

    <p><a href="studentDashboard">Back to Dashboard</a></p>
</body>
</html>
