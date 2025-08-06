<%@ include file="header.jsp" %>
<h2>Register New User</h2>
<form action="RegisterServlet" method="post">
    <label>Username:</label><br>
    <input type="text" name="username" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <label>Role:</label><br>
    <select name="role" required>
        <option value="admin">Admin</option>
        <option value="instructor">Instructor</option>
        <option value="student">Student</option>
    </select><br><br>

    <input type="submit" value="Register">
</form>
<%@ include file="footer.jsp" %>
