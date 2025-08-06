<%@ include file="header.jsp" %>
<h2>Login</h2>
<form action="LoginServlet" method="post">
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

    <input type="submit" value="Login">
</form>
<p style="color:red;">${error}</p>
<a href="register.jsp">New User? Register here</a>
<%@ include file="footer.jsp" %>
