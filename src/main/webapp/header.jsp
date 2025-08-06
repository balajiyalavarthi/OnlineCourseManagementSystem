<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Online Course Management System</title>
    <style>
        body { font-family: Arial, sans-serif; margin:0; padding:0; }
        nav { background-color:#333; padding:10px; }
        nav a { color:#fff; margin:0 10px; text-decoration:none; }
        nav a:hover { text-decoration:underline; }
    </style>
</head>
<body>
<nav>
    <a href="index.jsp">Home</a>
    <a href="CourseServlet?action=view">Courses</a>
    <a href="InstructorServlet?action=view">Instructors</a>
    <a href="StudentServlet?action=view">Students</a>
    <a href="logout.jsp">Logout</a>
</nav>
<hr>
