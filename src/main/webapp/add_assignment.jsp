<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>
<%
    Integer instructorId = (Integer) session.getAttribute("instructorId");
    if (instructorId == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Add New Assignment</title><style>
    
    	 body {
            margin: 0;
            font-family: 'Plus Jakarta Sans', sans-serif;
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: #fff;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            min-height: 100vh;
            padding: 40px;
        }
        form {
            background: rgba(255, 255, 255, 0.05);
            border-radius: 20px;
            backdrop-filter: blur(12px);
            padding: 30px;
            width: 400px;
            box-shadow: 0 8px 32px rgba(0,0,0,0.2);
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: 600;
            color: #4facfe;
        }

        input, textarea {
            width: 100%;
            padding: 12px;
            margin-bottom: 18px;
            border: none;
            border-radius: 12px;
            background: rgba(255, 255, 255, 0.1);
            color: #fff;
            font-size: 1rem;
            outline: none;
        }

        input[type="date"] {
            color-scheme: dark;
        }

        textarea {
            min-height: 80px;
            resize: none;
        }


		  h2 {
            font-size: 2rem;
            color: #4facfe;
            margin-bottom: 20px;
            text-align: center;
        }
        button {
            width: 100%;
            padding: 12px;
            font-size: 1.1rem;
            font-weight: bold;
            color: #fff;
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            border: none;
            border-radius: 12px;
            cursor: pointer;
            transition: 0.3s ease;
        }

        button:hover {
            background: linear-gradient(135deg, #00f2fe, #4facfe);
            transform: scale(1.03);
        }
    </style>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Add New Assignment</h2>
    <form action="assignments?action=add" method="post">
        <label>Course ID:</label>
        <input type="number" name="courseId" required>

        <label>Title:</label>
        <input type="text" name="title" required>

        <label>Description:</label>
        <textarea name="description" required></textarea>

        <label>Due Date:</label>
        <input type="date" name="dueDate" required>

        <button type="submit">Add Assignment</button>
    </form>
</body>
</html>
