<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Course Management System</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>
<body class="login-page">
    <div class="login-container">
        <!-- Login Header -->
        <div class="login-welcome">
            <h2>Login</h2>
            <p>Welcome back! Please sign in to your account</p>
        </div>

        <!-- Error Alert -->
        <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
        %>
        <div class="alert alert-danger" role="alert">
            <strong>Error:</strong> <%= error %>
        </div>
        <% } %>

        <!-- Login Form -->
        <form action="login" method="post" class="login-form">
            <div class="form-group">
                <label for="email" class="form-label">Email Address</label>
                <input type="email" 
                       id="email" 
                       name="email" 
                       placeholder="Enter your email" 
                       required 
                       autocomplete="email">
            </div>

            <div class="form-group">
                <label for="password" class="form-label">Password</label>
                <input type="password" 
                       id="password" 
                       name="password" 
                       placeholder="Enter your password" 
                       required 
                       autocomplete="current-password">
            </div>

            <button type="submit" class="login-button">
                <span>Login</span>
            </button>
        </form>

        <!-- Authentication Links -->
        <div class="auth-links">
            <p class="auth-text">Don't have an account?</p>
            <div>
                <a href="register_student.jsp" class="register-link">Register as Student</a>
                <span style="color: var(--text-muted); margin: 0 8px;">|</span>
                <a href="register_instructor.jsp" class="register-link">Register as Instructor</a>
            </div>
        </div>
    </div>

    <!-- Optional: Loading Animation -->
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const form = document.querySelector('.login-form');
            const button = document.querySelector('.login-button');
            
            form.addEventListener('submit', function(e) {
                button.classList.add('loading');
                button.innerHTML = '<span>Signing in...</span>';
                button.disabled = true;
            });

            // Auto-focus first input
            const emailInput = document.getElementById('email');
            emailInput.focus();

            // Add floating label effect
            const inputs = document.querySelectorAll('input[type="email"], input[type="password"]');
            inputs.forEach(input => {
                input.addEventListener('focus', function() {
                    this.parentElement.classList.add('focused');
                });
                
                input.addEventListener('blur', function() {
                    if (this.value === '') {
                        this.parentElement.classList.remove('focused');
                    }
                });
                
                // Check if input has value on page load
                if (input.value !== '') {
                    input.parentElement.classList.add('focused');
                }
            });
        });
    </script>

    <style>
        /* Additional floating label styles */
        .form-group.focused .form-label {
            transform: translateY(-8px) scale(0.85);
            color: #667eea;
        }
        
        .form-group .form-label {
            transition: all 0.3s ease;
            transform-origin: left top;
        }
        
        .loading {
            opacity: 0.7;
            pointer-events: none;
        }
        
        .loading span::after {
            content: '';
            display: inline-block;
            width: 12px;
            height: 12px;
            margin-left: 8px;
            border: 2px solid transparent;
            border-top-color: currentColor;
            border-radius: 50%;
            animation: spin 1s linear infinite;
        }
    </style>
</body>
</html>