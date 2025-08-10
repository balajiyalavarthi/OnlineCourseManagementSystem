<!-- admin_add_student.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>

<html>
<head>
    <title>Add New Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Add New Student</h2>
    
    <form action="adminAddStudent" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" required /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required /></td>
            </tr>
            <tr>
                <td>Enrollment Date:</td>
                <td><input type="date" name="enrollmentDate" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add Student" />
                    <a href="admin_dashboard.jsp">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

<!-- admin_student_list.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Students</title>
</head>
<body>
    <h2>All Students</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Enrollment Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.studentId}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.enrollmentDate}</td>
                    <td>
                        <a href="adminEditStudent?id=${student.studentId}">Edit</a> |
                        <a href="adminDeleteStudent?id=${student.studentId}" 
                           onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <br/>
    <a href="admin_dashboard.jsp">Back to Dashboard</a>
</body>
</html>

<!-- admin_edit_student.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Student</title>
</head>
<body>
    <h2>Edit Student</h2>
    
    <form action="adminEditStudent" method="post">
        <input type="hidden" name="studentId" value="${student.studentId}" />
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${student.name}" required /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" value="${student.email}" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" value="${student.password}" required /></td>
            </tr>
            <tr>
                <td>Enrollment Date:</td>
                <td><input type="date" name="enrollmentDate" value="${student.enrollmentDate}" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update Student" />
                    <a href="admin_dashboard.jsp">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

<!-- admin_student_search.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Find Student by ID</title>
</head>
<body>
    <h2>Find Student by ID</h2>
    
    <form action="adminFindStudent" method="post">
        <table>
            <tr>
                <td>Student ID:</td>
                <td><input type="number" name="studentId" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Search Student" />
                    <a href="admin_dashboard.jsp">Back to Dashboard</a>
                </td>
            </tr>
        </table>
    </form>

    <c:if test="${not empty foundStudent}">
        <h3>Student Found:</h3>
        <table border="1">
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Enrollment Date</th>
                <th>Actions</th>
            </tr>
            <tr>
                <td>${foundStudent.studentId}</td>
                <td>${foundStudent.name}</td>
                <td>${foundStudent.email}</td>
                <td>${foundStudent.enrollmentDate}</td>
                <td>
                    <a href="adminEditStudent?id=${foundStudent.studentId}">Edit</a> |
                    <a href="adminDeleteStudent?id=${foundStudent.studentId}" 
                       onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                </td>
            </tr>
        </table>
    </c:if>

    <c:if test="${not empty errorMessage}">
        <div style="color: red;">${errorMessage}</div>
        <c:remove var="errorMessage" scope="session" />
    </c:if>
</body>
</html>