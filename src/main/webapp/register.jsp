<%@ include file="header.jsp" %>

<div class="login-page">
    <div class="login-container">
        <div class="login-header">
            <div class="login-icon">
                <i class="fas fa-user-plus"></i>
            </div>
            <h2>Create Your Account</h2>
            <p>Join our educational platform today</p>
        </div>

        <form action="RegisterServlet" method="post" class="login-form">
            <div class="form-group">
                <label for="username" class="form-label">
                    <i class="fas fa-user"></i>
                    Username
                </label>
                <input 
                    type="text" 
                    id="username"
                    name="username" 
                    class="form-input"
                    placeholder="Enter your username"
                    required
                    autocomplete="username"
                >
                <div class="input-border"></div>
            </div>

            <div class="form-group">
                <label for="password" class="form-label">
                    <i class="fas fa-lock"></i>
                    Password
                </label>
                <div class="password-container">
                    <input 
                        type="password" 
                        id="password"
                        name="password" 
                        class="form-input"
                        placeholder="Enter your password"
                        required
                        autocomplete="new-password"
                    >
                    <button type="button" class="password-toggle" onclick="togglePassword()">
                        <i class="fas fa-eye" id="password-eye"></i>
                    </button>
                </div>
                <div class="input-border"></div>
            </div>

            <div class="form-group">
                <label for="role" class="form-label">
                    <i class="fas fa-user-tag"></i>
                    Role
                </label>
                <div class="select-container">
                    <select name="role" id="role" class="form-select" required>
                        <option value="">Choose your role</option>
                        <option value="admin">
                            <i class="fas fa-user-shield"></i> Administrator
                        </option>
                        <option value="instructor">
                            <i class="fas fa-chalkboard-teacher"></i> Instructor
                        </option>
                        <option value="student">
                            <i class="fas fa-user-graduate"></i> Student
                        </option>
                    </select>
                    <i class="fas fa-chevron-down select-arrow"></i>
                </div>
                <div class="input-border"></div>
            </div>

            <% if (request.getAttribute("error") != null) { %>
                <div class="error-message">
                    <i class="fas fa-exclamation-triangle"></i>
                    <span>${error}</span>
                </div>
            <% } %>

            <button type="submit" class="login-button">
                <span class="button-text">Register</span>
                <i class="fas fa-arrow-right button-icon"></i>
                <div class="button-ripple"></div>
            </button>

            <div class="login-divider">
                <span>or</span>
            </div>

            <div class="register-section">
                <p>Already have an account?</p>
                <a href="login.jsp" class="register-link">
                    <i class="fas fa-sign-in-alt"></i>
                    Sign In
                </a>
            </div>
        </form>
    </div>

    <div class="login-features">
        <div class="feature-card">
            <div class="feature-icon">
                <i class="fas fa-book-open"></i>
            </div>
            <h3>Rich Course Content</h3>
            <p>Access comprehensive learning materials and interactive content</p>
        </div>
        
        <div class="feature-card">
            <div class="feature-icon">
                <i class="fas fa-users"></i>
            </div>
            <h3>Collaborative Learning</h3>
            <p>Connect with instructors and fellow learners in our community</p>
        </div>
        
        <div class="feature-card">
            <div class="feature-icon">
                <i class="fas fa-chart-line"></i>
            </div>
            <h3>Track Progress</h3>
            <p>Monitor your learning journey with detailed analytics</p>
        </div>
    </div>
</div>

<style>
    /* Login Page Styles (same as login.jsp) */
    .login-page {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 4rem;
        align-items: center;
        min-height: calc(100vh - 400px);
        padding: 2rem 0;
    }

    .login-container {
        background: white;
        border-radius: 20px;
        padding: 3rem;
        box-shadow: var(--shadow-xl);
        border: 1px solid rgba(30, 58, 138, 0.1);
        position: relative;
        overflow: hidden;
    }

    .login-container::before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        height: 4px;
        background: linear-gradient(90deg, var(--primary-color), var(--secondary-color), var(--accent-color));
    }

    .login-header {
        text-align: center;
        margin-bottom: 2.5rem;
    }

    .login-icon {
        width: 80px;
        height: 80px;
        background: linear-gradient(135deg, var(--primary-color), var(--primary-light));
        border-radius: 20px;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 0 auto 1.5rem;
        font-size: 2rem;
        color: white;
        box-shadow: var(--shadow-lg);
    }

    .login-header h2 {
        font-size: 2rem;
        color: var(--text-primary);
        margin-bottom: 0.5rem;
        font-weight: 700;
    }

    .login-header p {
        color: var(--text-secondary);
        font-size: 1rem;
    }

    .form-group {
        margin-bottom: 1.5rem;
        position: relative;
    }

    .form-label {
        display: flex;
        align-items: center;
        gap: 0.5rem;
        font-weight: 600;
        color: var(--text-primary);
        margin-bottom: 0.5rem;
        font-size: 0.9rem;
    }

    .form-input, .form-select {
        width: 100%;
        padding: 1rem 1.25rem;
        border: 2px solid #e5e7eb;
        border-radius: 12px;
        font-size: 1rem;
        transition: all 0.3s ease;
        background: #fafafa;
        color: var(--text-primary);
    }

    .form-input:focus, .form-select:focus {
        outline: none;
        border-color: var(--primary-color);
        background: white;
        box-shadow: 0 0 0 3px rgba(30, 58, 138, 0.1);
    }

    .password-container {
        position: relative;
        display: flex;
        align-items: center;
    }

    .password-toggle {
        position: absolute;
        right: 1rem;
        background: none;
        border: none;
        color: var(--text-secondary);
        cursor: pointer;
        padding: 0.5rem;
        transition: color 0.3s ease;
    }

    .password-toggle:hover {
        color: var(--primary-color);
    }

    .select-container {
        position: relative;
    }

    .select-arrow {
        position: absolute;
        right: 1rem;
        top: 50%;
        transform: translateY(-50%);
        color: var(--text-secondary);
        pointer-events: none;
    }

    .form-select {
        appearance: none;
        background-image: none;
        cursor: pointer;
    }

    .input-border {
        position: absolute;
        bottom: 0;
        left: 0;
        width: 0;
        height: 2px;
        background: var(--primary-color);
        transition: width 0.3s ease;
    }

    .form-input:focus + .input-border,
    .form-select:focus + .input-border {
        width: 100%;
    }

    .error-message {
        display: flex;
        align-items: center;
        gap: 0.5rem;
        background: rgba(239, 68, 68, 0.1);
        color: var(--error-color);
        padding: 1rem;
        border-radius: 8px;
        border-left: 4px solid var(--error-color);
        margin-bottom: 1.5rem;
        font-size: 0.9rem;
    }

    .login-button {
        width: 100%;
        background: linear-gradient(135deg, var(--primary-color), var(--primary-light));
        color: white;
        border: none;
        padding: 1.25rem;
        border-radius: 12px;
        font-size: 1.1rem;
        font-weight: 600;
        cursor: pointer;
        position: relative;
        overflow: hidden;
        transition: all 0.3s ease;
        margin-bottom: 1.5rem;
        display: flex;
        align-items: center;
        justify-content: center;
        gap: 0.75rem;
    }

    .login-button:hover {
        transform: translateY(-2px);
        box-shadow: var(--shadow-lg);
    }

    .button-icon {
        transition: transform 0.3s ease;
    }

    .login-button:hover .button-icon {
        transform: translateX(5px);
    }

    .login-divider {
        text-align: center;
        position: relative;
        margin: 2rem 0;
    }

    .login-divider::before {
        content: '';
        position: absolute;
        top: 50%;
        left: 0;
        right: 0;
        height: 1px;
        background: #e5e7eb;
    }

    .login-divider span {
        background: white;
        padding: 0 1rem;
        color: var(--text-secondary);
        font-size: 0.9rem;
    }

    .register-section {
        text-align: center;
    }

    .register-section p {
        color: var(--text-secondary);
        margin-bottom: 1rem;
    }

    .register-link {
        display: inline-flex;
        align-items: center;
        gap: 0.5rem;
        color: var(--primary-color);
        text-decoration: none;
        font-weight: 600;
        padding: 0.75rem 1.5rem;
        border: 2px solid var(--primary-color);
        border-radius: 8px;
        transition: all 0.3s ease;
    }

    .register-link:hover {
        background: var(--primary-color);
        color: white;
        transform: translateY(-2px);
    }

    /* Features Section */
    .login-features {
        display: flex;
        flex-direction: column;
        gap: 1.5rem;
        padding-left: 2rem;
    }

    .feature-card {
        background: white;
        padding: 2rem;
        border-radius: 16px;
        box-shadow: var(--shadow-md);
        border: 1px solid rgba(30, 58, 138, 0.1);
        transition: all 0.3s ease;
        position: relative;
        overflow: hidden;
    }

    .feature-card:hover {
        transform: translateY(-5px);
        box-shadow: var(--shadow-xl);
    }

    .feature-card::before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 3px;
        background: linear-gradient(90deg, var(--primary-color), var(--secondary-color));
    }

    .feature-icon {
        width: 60px;
        height: 60px;
        background: linear-gradient(135deg, var(--secondary-color), var(--accent-color));
        border-radius: 12px;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 1.5rem;
        color: white;
        margin-bottom: 1rem;
        box-shadow: var(--shadow-md);
    }

    .feature-card h3 {
        color: var(--text-primary);
        font-size: 1.25rem;
        font-weight: 600;
        margin-bottom: 0.75rem;
    }

    .feature-card p {
        color: var(--text-secondary);
        line-height: 1.6;
        font-size: 0.95rem;
    }

    /* Responsive Design */
    @media (max-width: 1024px) {
        .login-page {
            grid-template-columns: 1fr;
            gap: 2rem;
        }

        .login-features {
            padding-left: 0;
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 1rem;
        }
    }

    @media (max-width: 768px) {
        .login-container {
            padding: 2rem 1.5rem;
            margin: 0 1rem;
        }

        .login-header h2 {
            font-size: 1.75rem;
        }

        .login-icon {
            width: 60px;
            height: 60px;
            font-size: 1.5rem;
        }

        .feature-card {
            padding: 1.5rem;
        }

        .login-features {
            grid-template-columns: 1fr;
        }
    }

    /* Animation Effects */
    @keyframes slideInLeft {
        from {
            opacity: 0;
            transform: translateX(-30px);
        }
        to {
            opacity: 1;
            transform: translateX(0);
        }
    }

    @keyframes slideInRight {
        from {
            opacity: 0;
            transform: translateX(30px);
        }
        to {
            opacity: 1;
            transform: translateX(0);
        }
    }

    .login-container {
        animation: slideInLeft 0.8s ease-out;
    }

    .login-features {
        animation: slideInRight 0.8s ease-out;
    }

    .feature-card {
        animation: slideInRight 0.8s ease-out;
    }

    .feature-card:nth-child(1) { animation-delay: 0.1s; }
    .feature-card:nth-child(2) { animation-delay: 0.2s; }
    .feature-card:nth-child(3) { animation-delay: 0.3s; }

    /* Custom checkbox and radio styles */
    .form-check {
        display: flex;
        align-items: center;
        gap: 0.75rem;
        margin: 1rem 0;
    }

    .form-check input[type="checkbox"] {
        width: 20px;
        height: 20px;
        accent-color: var(--primary-color);
    }

    .form-check label {
        color: var(--text-secondary);
        font-size: 0.9rem;
        cursor: pointer;
    }

    /* Loading state for button */
    .login-button:disabled {
        opacity: 0.7;
        cursor: not-allowed;
    }

    .login-button.loading .button-text {
        opacity: 0;
    }

    .login-button.loading::after {
        content: '';
        position: absolute;
        width: 20px;
        height: 20px;
        border: 2px solid transparent;
        border-top: 2px solid white;
        border-radius: 50%;
        animation: spin 1s linear infinite;
    }

    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }

    /* Focus visible styles for accessibility */
    .login-button:focus-visible,
    .register-link:focus-visible {
        outline: 2px solid var(--primary-color);
        outline-offset: 2px;
    }

    .form-input:focus-visible,
    .form-select:focus-visible {
        outline: none;
        box-shadow: 0 0 0 3px rgba(30, 58, 138, 0.2);
    }
</style>

<script>
    function togglePassword() {
        const passwordInput = document.getElementById('password');
        const passwordEye = document.getElementById('password-eye');
        
        if (passwordInput.type === 'password') {
            passwordInput.type = 'text';
            passwordEye.classList.remove('fa-eye');
            passwordEye.classList.add('fa-eye-slash');
        } else {
            passwordInput.type = 'password';
            passwordEye.classList.remove('fa-eye-slash');
            passwordEye.classList.add('fa-eye');
        }
    }

    // Add loading state to register button
    document.querySelector('.login-form').addEventListener('submit', function(e) {
        const button = document.querySelector('.login-button');
        button.classList.add('loading');
        button.disabled = true;
        
        // Remove loading state after 3 seconds (fallback)
        setTimeout(() => {
            button.classList.remove('loading');
            button.disabled = false;
        }, 3000);
    });

    // Add focus effects
    document.querySelectorAll('.form-input, .form-select').forEach(input => {
        input.addEventListener('focus', function() {
            this.parentElement.classList.add('focused');
        });
        
        input.addEventListener('blur', function() {
            this.parentElement.classList.remove('focused');
        });
    });

    // Add ripple effect to button
    document.querySelector('.login-button').addEventListener('click', function(e) {
        const button = this;
        const rect = button.getBoundingClientRect();
        const size = Math.max(rect.width, rect.height);
        const x = e.clientX - rect.left - size / 2;
        const y = e.clientY - rect.top - size / 2;
        
        const ripple = document.createElement('span');
        ripple.style.cssText = `
            position: absolute;
            border-radius: 50%;
            background: rgba(255, 255, 255, 0.3);
            width: ${size}px;
            height: ${size}px;
            left: ${x}px;
            top: ${y}px;
            animation: ripple 0.6s ease-out;
            pointer-events: none;
        `;
        
        button.appendChild(ripple);
        
        setTimeout(() => {
            ripple.remove();
        }, 600);
    });

    // Add CSS for ripple animation
    const style = document.createElement('style');
    style.textContent = `
        @keyframes ripple {
            0% {
                transform: scale(0);
                opacity: 1;
            }
            100% {
                transform: scale(1);
                opacity: 0;
            }
        }
    `;
    document.head.appendChild(style);
</script>

<%@ include file="footer.jsp" %>