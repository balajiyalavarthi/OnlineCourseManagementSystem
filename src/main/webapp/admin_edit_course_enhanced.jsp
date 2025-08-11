<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Course</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Edit Course</h2>
    
    <form action="adminEditCourseEnhanced" method="post">
        <input type="hidden" name="courseId" value="${course.courseId}" />
        <table>
            <tr>
                <td>Course Name:</td>
                <td><input type="text" name="courseName" value="${course.courseName}" required /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><textarea name="courseDescription" rows="4" cols="50" required>${course.courseDiscription}</textarea></td>
            </tr>
            <tr>
                <td>Instructor:</td>
                <td>
                    <select name="instructorId" required>
                        <c:forEach var="instructor" items="${instructors}">
                            <option value="${instructor.instructor_id}" 
                                    ${instructor.name == course.instructorId ? 'selected' : ''}>
                                ${instructor.name} (${instructor.email})
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Start Date:</td>
                <td><input type="date" name="startDate" value="${course.startDate}" required /></td>
            </tr>
            <tr>
                <td>End Date:</td>
                <td><input type="date" name="endDate" value="${course.endDate}" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update Course" />
                    <a href="admin_dashboard.jsp">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>