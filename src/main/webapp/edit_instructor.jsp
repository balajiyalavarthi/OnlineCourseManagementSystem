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
    <title>Update Instructor Profile</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: inline-block; width: 150px; }
        input[type="text"], input[type="password"] {
            width: 300px; padding: 5px;
        }
        .btn { padding: 5px 15px; margin-right: 10px; }
        .alert { padding: 10px; margin: 10px 0; border-radius: 4px; }
        .alert-danger { background-color: #f2dede; color: #a94442; }
    </style>
</head>
<body>
    <h2>Update Your Profile</h2>
    
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>
    
    <form action="editInstructor" method="post">
        <input type="hidden" name="id" value="${instructor.instructor_id}">
        
        <div class="form-group">
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" value="${instructor.name}" required>
        </div>
        
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="${instructor.email}" required>
        </div>
        
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${instructor.password}" required>
        </div>
        
        <div class="form-group">
            <input type="submit" value="Update Profile" class="btn">
            <a href="instructorDashboard" class="btn">Cancel</a>
        </div>
    </form>
</body>
</html>