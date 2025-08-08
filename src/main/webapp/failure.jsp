<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Failure</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #ffebee;
        }
        .container {
            margin-top: 100px;
            padding: 20px;
            display: inline-block;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0px 4px 6px rgba(0,0,0,0.1);
        }
        h1 {
            color: #c62828;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 8px 15px;
            text-decoration: none;
            background: #c62828;
            color: white;
            border-radius: 5px;
        }
        a:hover {
            background: #8e0000;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1> Action Failed!</h1>
        <p><%= request.getAttribute("message") != null ? request.getAttribute("message") : "Something went wrong. Please try again." %></p>
        <a href="index.jsp">Back to Home</a>
    </div>
</body>
</html>
