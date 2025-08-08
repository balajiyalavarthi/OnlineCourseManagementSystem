</main>

    <footer class="footer-container">
        <div class="footer-content">
            <div class="footer-section">
                <div class="footer-brand">
                    <div class="footer-logo">
                        <i class="fas fa-graduation-cap"></i>
                        <span>EduFlow</span>
                    </div>
                    <p class="footer-description">
                        Transforming education through innovative online course management solutions.
                    </p>
                </div>
            </div>
            
            <div class="footer-section">
                <h4>Quick Links</h4>
                <ul class="footer-links">
                    <li><a href="index.jsp"><i class="fas fa-home"></i> Dashboard</a></li>
                    <li><a href="CourseServlet?action=view"><i class="fas fa-book"></i> Courses</a></li>
                    <li><a href="InstructorServlet?action=view"><i class="fas fa-chalkboard-teacher"></i> Instructors</a></li>
                    <li><a href="StudentServlet?action=view"><i class="fas fa-users"></i> Students</a></li>
                </ul>
            </div>
            
            <div class="footer-section">
                <h4>Support</h4>
                <ul class="footer-links">
                    <li><a href="#"><i class="fas fa-question-circle"></i> Help Center</a></li>
                    <li><a href="#"><i class="fas fa-envelope"></i> Contact Us</a></li>
                    <li><a href="#"><i class="fas fa-shield-alt"></i> Privacy Policy</a></li>
                    <li><a href="#"><i class="fas fa-file-contract"></i> Terms of Service</a></li>
                </ul>
            </div>
            
            <div class="footer-section">
                <h4>Connect</h4>
                <div class="social-links">
                    <a href="#" class="social-link">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a href="#" class="social-link">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a href="#" class="social-link">
                        <i class="fab fa-linkedin-in"></i>
                    </a>
                    <a href="#" class="social-link">
                        <i class="fab fa-instagram"></i>
                    </a>
                </div>
            </div>
        </div>
        
        <div class="footer-bottom">
            <div class="footer-bottom-content">
                <p>&copy; 2025 EduFlow - Online Course Management System. All rights reserved.</p>
                <p class="footer-tech">Built with ❤️ for educational excellence</p>
            </div>
        </div>
    </footer>

    <style>
        /* Footer Styles */
        .footer-container {
            background: linear-gradient(135deg, #1e3a8a 0%, #3b82f6 100%);
            color: var(--text-light);
            margin-top: auto;
            position: relative;
            overflow: hidden;
        }

        .footer-container::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: url('data:image/svg+xml,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1000 100" fill="white" opacity="0.05"><path d="M0,50 Q250,100 500,50 T1000,50 L1000,0 L0,0 Z"/></svg>') no-repeat top;
            background-size: cover;
        }

        .footer-content {
            max-width: 1200px;
            margin: 0 auto;
            padding: 3rem 2rem 2rem;
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 2rem;
            position: relative;
            z-index: 2;
        }

        .footer-section h4 {
            font-size: 1.1rem;
            font-weight: 600;
            margin-bottom: 1rem;
            color: rgba(255, 255, 255, 0.95);
        }

        .footer-brand {
            margin-bottom: 1.5rem;
        }

        .footer-logo {
            display: flex;
            align-items: center;
            gap: 0.75rem;
            margin-bottom: 1rem;
            font-size: 1.5rem;
            font-weight: 700;
        }

        .footer-logo i {
            font-size: 1.8rem;
            color: var(--secondary-color);
        }

        .footer-description {
            color: rgba(255, 255, 255, 0.8);
            line-height: 1.6;
            font-size: 0.95rem;
        }

        .footer-links {
            list-style: none;
        }

        .footer-links li {
            margin-bottom: 0.75rem;
        }

        .footer-links a {
            color: rgba(255, 255, 255, 0.8);
            text-decoration: none;
            display: flex;
            align-items: center;
            gap: 0.5rem;
            transition: all 0.3s ease;
            padding: 0.25rem 0;
        }

        .footer-links a:hover {
            color: var(--secondary-color);
            transform: translateX(5px);
        }

        .social-links {
            display: flex;
            gap: 1rem;
            margin-top: 1rem;
        }

        .social-link {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 40px;
            height: 40px;
            background: rgba(255, 255, 255, 0.1);
            border-radius: 50%;
            color: rgba(255, 255, 255, 0.8);
            text-decoration: none;
            transition: all 0.3s ease;
            backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.2);
        }

        .social-link:hover {
            background: var(--secondary-color);
            color: white;
            transform: translateY(-2px);
        }

        .footer-bottom {
            border-top: 1px solid rgba(255, 255, 255, 0.2);
            padding: 1.5rem 2rem;
            text-align: center;
            position: relative;
            z-index: 2;
        }

        .footer-bottom-content p {
            color: rgba(255, 255, 255, 0.8);
            font-size: 0.9rem;
            margin-bottom: 0.5rem;
        }

        .footer-tech {
            font-size: 0.85rem !important;
            color: rgba(255, 255, 255, 0.6) !important;
        }

        /* Responsive Footer */
        @media (max-width: 768px) {
            .footer-content {
                padding: 2rem 1rem 1.5rem;
                grid-template-columns: 1fr;
                gap: 1.5rem;
                text-align: center;
            }

            .footer-bottom {
                padding: 1rem;
            }

            .social-links {
                justify-content: center;
            }
        }

        /* Page Layout */
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        .content-container {
            flex: 1;
        }
    </style>

</body>
</html>