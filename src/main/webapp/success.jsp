<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #e8f5e9;
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
            color: #2e7d32;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 8px 15px;
            text-decoration: none;
            background: #2e7d32;
            color: white;
            border-radius: 5px;
        }
        a:hover {
            background: #1b5e20;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1> Action Successful!</h1>
        <p><%= request.getAttribute("message") != null ? request.getAttribute("message") : "Your operation completed successfully." %></p>
        <a href="dashboard.jsp">Go to Dashboard</a>
    </div>
</body>
</html>
