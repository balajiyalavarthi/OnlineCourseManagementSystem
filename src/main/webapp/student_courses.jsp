
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${not empty successMessage}">
    <div class="alert alert-success">${successMessage}</div>
    <c:remove var="successMessage" scope="session"/>
</c:if>

<c:if test="${not empty errorMessage}">
    <div class="alert alert-danger">${errorMessage}</div>
    <c:remove var="errorMessage" scope="session"/>
</c:if>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Instructor</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Action</th>
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.courseId}</td>
            <td>${course.courseName}</td>
            <td>${course.courseDiscription}</td>
            <td>${course.instructorName}</td>
            <td><fmt:formatDate value="${course.startDate}" pattern="MMM dd, yyyy"/></td>
            <td><fmt:formatDate value="${course.endDate}" pattern="MMM dd, yyyy"/></td>
            <td>
                <form action="enrollCourse" method="post">
                    <input type="hidden" name="courseId" value="${course.courseId}">
                    <button type="submit" class="btn btn-primary">Enroll</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>