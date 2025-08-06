<%@ include file="header.jsp" %>
<h2>Welcome, ${sessionScope.username}</h2>
<p>Select a module to manage:</p>
<ul>
    <li><a href="CourseServlet?action=view">Manage Courses</a></li>
    <li><a href="InstructorServlet?action=view">Manage Instructors</a></li>
    <li><a href="StudentServlet?action=view">Manage Students</a></li>
</ul>
<%@ include file="footer.jsp" %>
