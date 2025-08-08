<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EduFlow - Online Course Management System</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <style>
        :root {
            --primary-color: #1e3a8a;
            --primary-light: #3b82f6;
            --primary-dark: #1e40af;
            --secondary-color: #06b6d4;
            --accent-color: #8b5cf6;
            --success-color: #10b981;
            --warning-color: #f59e0b;
            --error-color: #ef4444;
            --bg-primary: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            --bg-secondary: #f8fafc;
            --text-primary: #1f2937;
            --text-secondary: #6b7280;
            --text-light: #ffffff;
            --shadow-sm: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
            --shadow-md: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
            --shadow-lg: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
            --shadow-xl: 0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04);
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Inter', 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: var(--bg-secondary);
            color: var(--text-primary);
            line-height: 1.6;
            min-height: 100vh;
        }

        /* Header Styles */
        .header-container {
            background: var(--bg-primary);
            box-shadow: var(--shadow-lg);
            position: relative;
            overflow: hidden;
        }

        .header-container::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: url('data:image/svg+xml,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1000 100" fill="white" opacity="0.1"><path d="M0,50 Q250,0 500,50 T1000,50 L1000,100 L0,100 Z"/></svg>') no-repeat bottom;
            background-size: cover;
        }

        .brand-section {
            padding: 1.5rem 2rem;
            text-align: center;
            position: relative;
            z-index: 2;
        }

        .logo-container {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 1rem;
            margin-bottom: 0.5rem;
        }

        .logo-icon {
            width: 50px;
            height: 50px;
            background: rgba(255, 255, 255, 0.2);
            border-radius: 12px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
            color: var(--text-light);
            backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.3);
        }

        .brand-text h1 {
            color: var(--text-light);
            font-size: 2rem;
            font-weight: 700;
            letter-spacing: -0.02em;
            margin-bottom: 0.25rem;
        }

        .brand-text p {
            color: rgba(255, 255, 255, 0.9);
            font-size: 0.9rem;
            font-weight: 400;
        }

        /* Navigation Styles */
        nav {
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(20px);
            border-top: 1px solid rgba(255, 255, 255, 0.2);
            position: relative;
            z-index: 2;
        }

        .nav-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 2rem;
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 0.5rem;
        }

        .nav-link {
            display: flex;
            align-items: center;
            gap: 0.5rem;
            padding: 1rem 1.5rem;
            color: var(--text-primary);
            text-decoration: none;
            font-weight: 500;
            transition: all 0.3s ease;
            position: relative;
            border-radius: 8px;
            margin: 0.5rem 0;
        }

        .nav-link:hover {
            color: var(--primary-color);
            background: rgba(30, 58, 138, 0.05);
            transform: translateY(-2px);
        }

        .nav-link::after {
            content: '';
            position: absolute;
            bottom: 0;
            left: 50%;
            width: 0;
            height: 2px;
            background: var(--primary-color);
            transition: all 0.3s ease;
            transform: translateX(-50%);
        }

        .nav-link:hover::after {
            width: 80%;
        }

        .nav-link.logout {
            color: var(--error-color);
        }

        .nav-link.logout:hover {
            background: rgba(239, 68, 68, 0.05);
            color: var(--error-color);
        }

        .nav-link.logout::after {
            background: var(--error-color);
        }

        /* Content Container */
        .content-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 2rem;
            min-height: calc(100vh - 200px);
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .brand-section {
                padding: 1rem;
            }

            .logo-container {
                flex-direction: column;
                gap: 0.5rem;
            }

            .brand-text h1 {
                font-size: 1.5rem;
            }

            .nav-container {
                padding: 0 1rem;
                justify-content: center;
            }

            .nav-link {
                padding: 0.75rem 1rem;
                font-size: 0.9rem;
            }

            .content-container {
                padding: 1rem;
            }
        }

        /* Animation Effects */
        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .brand-section {
            animation: fadeInUp 0.8s ease-out;
        }

        .nav-link {
            animation: fadeInUp 0.8s ease-out;
        }

        .nav-link:nth-child(1) { animation-delay: 0.1s; }
        .nav-link:nth-child(2) { animation-delay: 0.2s; }
        .nav-link:nth-child(3) { animation-delay: 0.3s; }
        .nav-link:nth-child(4) { animation-delay: 0.4s; }
        .nav-link:nth-child(5) { animation-delay: 0.5s; }
    </style>
</head>
<body>
    <header class="header-container">
        <div class="brand-section">
            <div class="logo-container">
                <div class="logo-icon">
                    <i class="fas fa-graduation-cap"></i>
                </div>
                <div class="brand-text">
                    <h1>EduFlow</h1>
                    <p>Empowering Education Through Technology</p>
                </div>
            </div>
        </div>
        
        <nav>
            <div class="nav-container">
                <a href="index.jsp" class="nav-link">
                    <i class="fas fa-home"></i>
                    <span>Dashboard</span>
                </a>
                <a href="CourseServlet?action=view" class="nav-link">
                    <i class="fas fa-book"></i>
                    <span>Courses</span>
                </a>
                <a href="InstructorServlet?action=view" class="nav-link">
                    <i class="fas fa-chalkboard-teacher"></i>
                    <span>Instructors</span>
                </a>
                <a href="StudentServlet?action=view" class="nav-link">
                    <i class="fas fa-users"></i>
                    <span>Students</span>
                </a>
                <a href="logout.jsp" class="nav-link logout">
                    <i class="fas fa-sign-out-alt"></i>
                    <span>Logout</span>
                </a>
            </div>
        </nav>
    </header>

    <main class="content-container">