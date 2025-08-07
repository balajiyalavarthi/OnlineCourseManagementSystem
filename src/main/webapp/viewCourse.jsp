<%@ include file="header.jsp" %>
<h2>Course Details</h2>
<p><strong>ID:</strong> ${course.courseId}</p>
<p><strong>Name:</strong> ${course.courseName}</p>
<p><strong>Price:</strong> ${course.coursePrice}</p>
<p><strong>Description:</strong> ${course.courseDescription}</p>
<p><strong>Instructor:</strong> ${course.instructorName}</p>
<p><strong>Students Enrolled:</strong> ${course.listOfStudents}</p>
<a href="courses.jsp">Back to Courses</a>
<%@ include file="footer.jsp" %>
