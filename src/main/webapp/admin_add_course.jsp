<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>

<html>
<head>
    <title>Add New Course</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Add New Course</h2>
    
    <form action="adminAddCourse" method="post">
        <table>
            <tr>
                <td>Course Name:</td>
                <td><input type="text" name="courseName" required /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><textarea name="courseDescription" rows="4" cols="50" required></textarea></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="number" step="0.01" name="coursePrice" required /></td>
            </tr>
            <tr>
                <td>Instructor Name:</td>
                <td><input type="text" name="instructorName" required /></td>
            </tr>
            <tr>
                <td>Start Date:</td>
                <td><input type="date" name="startDate" required /></td>
            </tr>
            <tr>
                <td>End Date:</td>
                <td><input type="date" name="endDate" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add Course" />
                    <a href="admin_dashboard.jsp">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
