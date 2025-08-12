<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="true" %>

<html>
<head>
    <title>Add New Admin</title>
    <style>
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

        h2 {
            font-size: 2rem;
            color: #4facfe;
            margin-bottom: 20px;
            text-align: center;
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

        input {
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

        input::placeholder {
            color: rgba(255, 255, 255, 0.6);
        }

        .btn-container {
            display: flex;
            gap: 10px;
        }

        button, .cancel-btn {
            flex: 1;
            padding: 12px;
            font-size: 1.1rem;
            font-weight: bold;
            color: #fff;
            text-align: center;
            text-decoration: none;
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            border: none;
            border-radius: 12px;
            cursor: pointer;
            transition: 0.3s ease;
        }

        button:hover, .cancel-btn:hover {
            background: linear-gradient(135deg, #00f2fe, #4facfe);
            transform: scale(1.03);
        }

        .cancel-btn {
            background: linear-gradient(135deg, #ff4e50, #f9d423);
        }

        .cancel-btn:hover {
            background: linear-gradient(135deg, #f9d423, #ff4e50);
        }
    </style>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Add New Admin</h2>
    
    <form action="addAdmin" method="post">
        <label>Name:</label>
        <input type="text" name="name" placeholder="Enter full name" required />

        <label>Email:</label>
        <input type="email" name="email" placeholder="Enter email" required />

        <label>Password:</label>
        <input type="password" name="password" placeholder="Enter password" required />

        <div class="btn-container">
            <button type="submit">Add Admin</button>
            <a href="admin_dashboard.jsp" class="cancel-btn">Cancel</a>
        </div>
    </form>
</body>
</html>
