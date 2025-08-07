<%@ include file="header.jsp" %>
<h2>Student Details</h2>
<p><strong>ID:</strong> ${student.studentId}</p>
<p><strong>Name:</strong> ${student.studentName}</p>
<p><strong>Email:</strong> ${student.studentEmail}</p>
<p><strong>Courses Enrolled:</strong> ${student.listOfCourses}</p>
<a href="students.jsp">Back to Students</a>
<%@ include file="footer.jsp" %>
