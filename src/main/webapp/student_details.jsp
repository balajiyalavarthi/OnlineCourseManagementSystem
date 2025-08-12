<%@ page import="com.codegnan.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Details</title>
        <style>
        body {
            margin: 0;
            font-family: 'Plus Jakarta Sans', sans-serif;
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: #fff;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            padding: 40px;
        }

        h2 {
            font-size: 2rem;
            color: #4facfe;
            margin-bottom: 20px;
            text-align: center;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            background: rgba(255, 255, 255, 0.05);
            border-radius: 15px;
            overflow: hidden;
            backdrop-filter: blur(12px);
            box-shadow: 0 8px 32px rgba(0,0,0,0.2);
        }

        thead {
            background: linear-gradient(135deg, #4facfe, #00f2fe);
        }

        th, td {
            padding: 14px 18px;
            text-align: left;
        }

        th {
            color: #fff;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background: rgba(255, 255, 255, 0.03);
        }

        tr:hover {
            background: rgba(255, 255, 255, 0.08);
        }

        a.action-btn {
            padding: 6px 12px;
            border-radius: 8px;
            font-weight: 500;
            text-decoration: none;
            color: #fff;
            transition: 0.3s ease;
        }

        a.edit {
            background: linear-gradient(135deg, #4facfe, #00f2fe);
        }

        a.edit:hover {
            background: linear-gradient(135deg, #00f2fe, #4facfe);
        }

        a.delete {
            background: linear-gradient(135deg, #ff4e50, #f9d423);
        }

        a.delete:hover {
            background: linear-gradient(135deg, #f9d423, #ff4e50);
        }

        .back-btn {
            margin-top: 20px;
            padding: 10px 18px;
            font-size: 1rem;
            font-weight: bold;
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            color: #fff;
            text-decoration: none;
            border-radius: 12px;
            transition: 0.3s ease;
        }

        .back-btn:hover {
            background: linear-gradient(135deg, #00f2fe, #4facfe);
            transform: scale(1.05);
        }
    </style>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Student Details</h2>
<%
    Student s = (Student) request.getAttribute("student");
    if (s != null) {
%>
    <p><b>ID:</b> <%= s.getStudentId() %></p>
    <p><b>Name:</b> <%= s.getName() %></p>
    <p><b>Email:</b> <%= s.getEmail() %></p>
    
<%
    } else {
%>
    <p>No student found.</p>
<%
    }
%>
</body>
</html>
