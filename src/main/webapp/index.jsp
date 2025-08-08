<%@ include file="header.jsp" %>

<div class="dashboard-container">
    <!-- Welcome Hero Section -->
    <div class="welcome-hero">
        <div class="welcome-content">
            <div class="welcome-avatar">
                <i class="fas fa-user-circle"></i>
            </div>
            <div class="welcome-text">
                <h1>Welcome back, <span class="username">${sessionScope.username}</span>!</h1>
                <p class="welcome-subtitle">Ready to manage your educational platform? Let's make learning happen.</p>
                <div class="welcome-stats">
                    <div class="stat-item">
                        <i class="fas fa-clock"></i>
                        <span>Last login: Today</span>
                    </div>
                    <div class="stat-item">
                        <i class="fas fa-calendar"></i>
                        <span id="current-date"></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="welcome-illustration">
            <div class="floating-icon icon-1"><i class="fas fa-graduation-cap"></i></div>
            <div class="floating-icon icon-2"><i class="fas fa-book"></i></div>
            <div class="floating-icon icon-3"><i class="fas fa-users"></i></div>
        </div>
    </div>

    <!-- Quick Actions Section -->
    <div class="dashboard-section">
        <div class="section-header">
            <h2><i class="fas fa-rocket"></i> Quick Actions</h2>
            <p>Jump right into managing your platform</p>
        </div>
        
        <div class="action-cards">
            <a href="CourseServlet?action=view" class="action-card courses">
                <div class="card-icon">
                    <i class="fas fa-book-open"></i>
                </div>
                <div class="card-content">
                    <h3>Manage Courses</h3>
                    <p>Create, edit, and organize course content</p>
                    <div class="card-stats">
                        <span class="stat-badge">
                            <i class="fas fa-plus"></i> Add New
                        </span>
                    </div>
                </div>
                <div class="card-arrow">
                    <i class="fas fa-arrow-right"></i>
                </div>
            </a>

            <a href="InstructorServlet?action=view" class="action-card instructors">
                <div class="card-icon">
                    <i class="fas fa-chalkboard-teacher"></i>
                </div>
                <div class="card-content">
                    <h3>Manage Instructors</h3>
                    <p>Handle instructor profiles and assignments</p>
                    <div class="card-stats">
                        <span class="stat-badge">
                            <i class="fas fa-user-plus"></i> Add Instructor
                        </span>
                    </div>
                </div>
                <div class="card-arrow">
                    <i class="fas fa-arrow-right"></i>
                </div>
            </a>

            <a href="StudentServlet?action=view" class="action-card students">
                <div class="card-icon">
                    <i class="fas fa-user-graduate"></i>
                </div>
                <div class="card-content">
                    <h3>Manage Students</h3>
                    <p>View student progress and enrollments</p>
                    <div class="card-stats">
                        <span class="stat-badge">
                            <i class="fas fa-chart-line"></i> View Progress
                        </span>
                    </div>
                </div>
                <div class="card-arrow">
                    <i class="fas fa-arrow-right"></i>
                </div>
            </a>
        </div>
    </div>

    <!-- Dashboard Stats Overview -->
    <div class="dashboard-section">
        <div class="section-header">
            <h2><i class="fas fa-chart-pie"></i> Platform Overview</h2>
            <p>Get insights into your educational platform</p>
        </div>
        
        <div class="stats-grid">
            <div class="stat-card">
                <div class="stat-icon courses-bg">
                    <i class="fas fa-book"></i>
                </div>
                <div class="stat-info">
                    <h3>Active Courses</h3>
                    <div class="stat-number">24</div>
                    <div class="stat-change positive">
                        <i class="fas fa-arrow-up"></i>
                        <span>+3 this month</span>
                    </div>
                </div>
            </div>

            <div class="stat-card">
                <div class="stat-icon instructors-bg">
                    <i class="fas fa-chalkboard-teacher"></i>
                </div>
                <div class="stat-info">
                    <h3>Instructors</h3>
                    <div class="stat-number">18</div>
                    <div class="stat-change positive">
                        <i class="fas fa-arrow-up"></i>
                        <span>+2 this month</span>
                    </div>
                </div>
            </div>

            <div class="stat-card">
                <div class="stat-icon students-bg">
                    <i class="fas fa-users"></i>
                </div>
                <div class="stat-info">
                    <h3>Enrolled Students</h3>
                    <div class="stat-number">342</div>
                    <div class="stat-change positive">
                        <i class="fas fa-arrow-up"></i>
                        <span>+47 this month</span>
                    </div>
                </div>
            </div>

            <div class="stat-card">
                <div class="stat-icon completion-bg">
                    <i class="fas fa-certificate"></i>
                </div>
                <div class="stat-info">
                    <h3>Completion Rate</h3>
                    <div class="stat-number">87%</div>
                    <div class="stat-change positive">
                        <i class="fas fa-arrow-up"></i>
                        <span>+5% this month</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Recent Activity -->
    <div class="dashboard-section">
        <div class="section-header">
            <h2><i class="fas fa-history"></i> Recent Activity</h2>
            <p>Latest updates from your platform</p>
        </div>
        
        <div class="activity-feed">
            <div class="activity-item">
                <div class="activity-icon new-course">
                    <i class="fas fa-plus"></i>
                </div>
                <div class="activity-content">
                    <h4>New Course Added</h4>
                    <p>"Advanced JavaScript Programming" has been created</p>
                    <span class="activity-time">2 hours ago</span>
                </div>
            </div>

            <div class="activity-item">
                <div class="activity-icon new-student">
                    <i class="fas fa-user-plus"></i>
                </div>
                <div class="activity-content">
                    <h4>Student Enrollment</h4>
                    <p>5 new students enrolled in "Web Development Basics"</p>
                    <span class="activity-time">4 hours ago</span>
                </div>
            </div>

            <div class="activity-item">
                <div class="activity-icon assignment">
                    <i class="fas fa-tasks"></i>
                </div>
                <div class="activity-content">
                    <h4>Assignment Submitted</h4>
                    <p>12 students submitted "React Components" assignment</p>
                    <span class="activity-time">6 hours ago</span>
                </div>
            </div>

            <div class="activity-item">
                <div class="activity-icon instructor-update">
                    <i class="fas fa-edit"></i>
                </div>
                <div class="activity-content">
                    <h4>Course Updated</h4>
                    <p>Dr. Smith updated "Database Design" course materials</p>
                    <span class="activity-time">1 day ago</span>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
    .dashboard-container {
        max-width: 1400px;
        margin: 0 auto;
        padding: 0 2rem;
    }

    /* Welcome Hero Section */
    .welcome-hero {
        background: linear-gradient(135deg, var(--primary-color), var(--primary-light));
        border-radius: 24px;
        padding: 3rem;
        margin-bottom: 3rem;
        color: white;
        position: relative;
        overflow: hidden;
        display: flex;
        align-items: center;
        justify-content: space-between;
        min-height: 200px;
    }

    .welcome-hero::before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background: url('data:image/svg+xml,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1000 300" fill="white" opacity="0.1"><circle cx="100" cy="100" r="50"/><circle cx="300" cy="200" r="30"/><circle cx="800" cy="150" r="40"/></svg>');
        pointer-events: none;
    }

    .welcome-content {
        display: flex;
        align-items: center;
        gap: 2rem;
        flex: 1;
        position: relative;
        z-index: 2;
    }

    .welcome-avatar {
        font-size: 4rem;
        color: rgba(255, 255, 255, 0.9);
        background: rgba(255, 255, 255, 0.1);
        border-radius: 50%;
        padding: 1rem;
        backdrop-filter: blur(10px);
        border: 2px solid rgba(255, 255, 255, 0.2);
    }

    .welcome-text h1 {
        font-size: 2.5rem;
        font-weight: 700;
        margin-bottom: 0.5rem;
        line-height: 1.2;
    }

    .username {
        color: var(--secondary-color);
        text-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
    }

    .welcome-subtitle {
        font-size: 1.1rem;
        opacity: 0.9;
        margin-bottom: 1.5rem;
        line-height: 1.4;
    }

    .welcome-stats {
        display: flex;
        gap: 2rem;
        flex-wrap: wrap;
    }

    .stat-item {
        display: flex;
        align-items: center;
        gap: 0.5rem;
        font-size: 0.95rem;
        opacity: 0.8;
    }

    .welcome-illustration {
        position: relative;
        width: 200px;
        height: 200px;
        flex-shrink: 0;
    }

    .floating-icon {
        position: absolute;
        background: rgba(255, 255, 255, 0.15);
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        backdrop-filter: blur(10px);
        border: 1px solid rgba(255, 255, 255, 0.2);
        animation: float 3s ease-in-out infinite;
    }

    .icon-1 {
        width: 80px;
        height: 80px;
        font-size: 2rem;
        top: 20px;
        right: 20px;
        animation-delay: 0s;
    }

    .icon-2 {
        width: 60px;
        height: 60px;
        font-size: 1.5rem;
        bottom: 40px;
        right: 60px;
        animation-delay: 1s;
    }

    .icon-3 {
        width: 70px;
        height: 70px;
        font-size: 1.75rem;
        top: 80px;
        left: 10px;
        animation-delay: 2s;
    }

    @keyframes float {
        0%, 100% { transform: translateY(0px); }
        50% { transform: translateY(-10px); }
    }

    /* Dashboard Sections */
    .dashboard-section {
        margin-bottom: 3rem;
    }

    .section-header {
        text-align: center;
        margin-bottom: 2.5rem;
    }

    .section-header h2 {
        font-size: 2rem;
        color: var(--text-primary);
        margin-bottom: 0.5rem;
        display: flex;
        align-items: center;
        justify-content: center;
        gap: 0.75rem;
    }

    .section-header p {
        color: var(--text-secondary);
        font-size: 1.1rem;
    }

    /* Action Cards */
    .action-cards {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
        gap: 2rem;
        margin-bottom: 2rem;
    }

    .action-card {
        background: white;
        border-radius: 20px;
        padding: 2rem;
        text-decoration: none;
        color: inherit;
        box-shadow: var(--shadow-md);
        border: 1px solid rgba(0, 0, 0, 0.05);
        transition: all 0.4s ease;
        position: relative;
        overflow: hidden;
        display: flex;
        align-items: center;
        gap: 1.5rem;
    }

    .action-card::before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 4px;
        transition: all 0.3s ease;
    }

    .action-card.courses::before { background: linear-gradient(90deg, #3b82f6, #06b6d4); }
    .action-card.instructors::before { background: linear-gradient(90deg, #8b5cf6, #ec4899); }
    .action-card.students::before { background: linear-gradient(90deg, #10b981, #06b6d4); }

    .action-card:hover {
        transform: translateY(-8px);
        box-shadow: var(--shadow-xl);
    }

    .card-icon {
        width: 80px;
        height: 80px;
        border-radius: 16px;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 2rem;
        color: white;
        flex-shrink: 0;
        position: relative;
        overflow: hidden;
    }

    .courses .card-icon { background: linear-gradient(135deg, #3b82f6, #06b6d4); }
    .instructors .card-icon { background: linear-gradient(135deg, #8b5cf6, #ec4899); }
    .students .card-icon { background: linear-gradient(135deg, #10b981, #06b6d4); }

    .card-content {
        flex: 1;
    }

    .card-content h3 {
        font-size: 1.5rem;
        font-weight: 700;
        color: var(--text-primary);
        margin-bottom: 0.5rem;
    }

    .card-content p {
        color: var(--text-secondary);
        margin-bottom: 1rem;
        line-height: 1.5;
    }

    .stat-badge {
        background: rgba(59, 130, 246, 0.1);
        color: var(--primary-color);
        padding: 0.5rem 1rem;
        border-radius: 20px;
        font-size: 0.85rem;
        font-weight: 600;
        display: inline-flex;
        align-items: center;
        gap: 0.5rem;
    }

    .card-arrow {
        font-size: 1.5rem;
        color: var(--text-secondary);
        transition: all 0.3s ease;
    }

    .action-card:hover .card-arrow {
        color: var(--primary-color);
        transform: translateX(5px);
    }

    /* Stats Grid */
    .stats-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
        gap: 1.5rem;
        margin-bottom: 2rem;
    }

    .stat-card {
        background: white;
        border-radius: 16px;
        padding: 2rem;
        box-shadow: var(--shadow-md);
        border: 1px solid rgba(0, 0, 0, 0.05);
        transition: all 0.3s ease;
        display: flex;
        align-items: center;
        gap: 1.5rem;
    }

    .stat-card:hover {
        transform: translateY(-4px);
        box-shadow: var(--shadow-lg);
    }

    .stat-icon {
        width: 60px;
        height: 60px;
        border-radius: 12px;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 1.5rem;
        color: white;
        flex-shrink: 0;
    }

    .courses-bg { background: linear-gradient(135deg, #3b82f6, #1e40af); }
    .instructors-bg { background: linear-gradient(135deg, #8b5cf6, #7c3aed); }
    .students-bg { background: linear-gradient(135deg, #10b981, #059669); }
    .completion-bg { background: linear-gradient(135deg, #f59e0b, #d97706); }

    .stat-info h3 {
        color: var(--text-secondary);
        font-size: 0.9rem;
        font-weight: 600;
        margin-bottom: 0.5rem;
        text-transform: uppercase;
        letter-spacing: 0.5px;
    }

    .stat-number {
        font-size: 2.5rem;
        font-weight: 700;
        color: var(--text-primary);
        margin-bottom: 0.5rem;
    }

    .stat-change {
        display: flex;
        align-items: center;
        gap: 0.25rem;
        font-size: 0.85rem;
        font-weight: 600;
    }

    .stat-change.positive {
        color: var(--success-color);
    }

    /* Activity Feed */
    .activity-feed {
        background: white;
        border-radius: 16px;
        box-shadow: var(--shadow-md);
        border: 1px solid rgba(0, 0, 0, 0.05);
        overflow: hidden;
    }

    .activity-item {
        display: flex;
        align-items: center;
        gap: 1.5rem;
        padding: 1.5rem 2rem;
        border-bottom: 1px solid rgba(0, 0, 0, 0.05);
        transition: all 0.3s ease;
    }

    .activity-item:last-child {
        border-bottom: none;
    }

    .activity-item:hover {
        background: rgba(59, 130, 246, 0.02);
    }

    .activity-icon {
        width: 50px;
        height: 50px;
        border-radius: 12px;
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
        font-size: 1.25rem;
        flex-shrink: 0;
    }

    .new-course { background: linear-gradient(135deg, #3b82f6, #1e40af); }
    .new-student { background: linear-gradient(135deg, #10b981, #059669); }
    .assignment { background: linear-gradient(135deg, #8b5cf6, #7c3aed); }
    .instructor-update { background: linear-gradient(135deg, #f59e0b, #d97706); }

    .activity-content h4 {
        color: var(--text-primary);
        font-weight: 600;
        margin-bottom: 0.25rem;
    }

    .activity-content p {
        color: var(--text-secondary);
        margin-bottom: 0.5rem;
        line-height: 1.4;
    }

    .activity-time {
        color: var(--text-secondary);
        font-size: 0.85rem;
        opacity: 0.7;
    }

    /* Responsive Design */
    @media (max-width: 1024px) {
        .welcome-hero {
            flex-direction: column;
            text-align: center;
            gap: 2rem;
        }

        .welcome-content {
            flex-direction: column;
            text-align: center;
        }

        .welcome-illustration {
            width: 150px;
            height: 150px;
        }
    }

    @media (max-width: 768px) {
        .dashboard-container {
            padding: 0 1rem;
        }

        .welcome-hero {
            padding: 2rem 1.5rem;
        }

        .welcome-text h1 {
            font-size: 2rem;
        }

        .action-cards {
            grid-template-columns: 1fr;
            gap: 1.5rem;
        }

        .action-card {
            padding: 1.5rem;
        }

        .stats-grid {
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 1rem;
        }

        .stat-card {
            padding: 1.5rem;
            flex-direction: column;
            text-align: center;
        }

        .activity-item {
            padding: 1rem 1.5rem;
            flex-direction: column;
            text-align: center;
            gap: 1rem;
        }
    }

    /* Animations */
    .dashboard-section {
        animation: fadeInUp 0.8s ease-out;
    }

    .action-card {
        animation: fadeInUp 0.8s ease-out;
    }

    .action-card:nth-child(1) { animation-delay: 0.1s; }
    .action-card:nth-child(2) { animation-delay: 0.2s; }
    .action-card:nth-child(3) { animation-delay: 0.3s; }

    .stat-card {
        animation: fadeInUp 0.8s ease-out;
    }

    .stat-card:nth-child(1) { animation-delay: 0.1s; }
    .stat-card:nth-child(2) { animation-delay: 0.2s; }
    .stat-card:nth-child(3) { animation-delay: 0.3s; }
    .stat-card:nth-child(4) { animation-delay: 0.4s; }
</style>

<script>
    // Set current date
    document.addEventListener('DOMContentLoaded', function() {
        const currentDate = new Date().toLocaleDateString('en-US', {
            weekday: 'long',
            year: 'numeric',
            month: 'long',
            day: 'numeric'
        });
        document.getElementById('current-date').textContent = currentDate;
    });

    // Add hover effects to cards
    document.querySelectorAll('.action-card').forEach(card => {
        card.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-8px) scale(1.02)';
        });
        
        card.addEventListener('mouseleave', function() {
            this.style.transform = 'translateY(0) scale(1)';
        });
    });

    // Animate numbers on scroll
    function animateNumbers() {
        const statNumbers = document.querySelectorAll('.stat-number');
        statNumbers.forEach(number => {
            const finalNumber = parseInt(number.textContent);
            if (finalNumber < 100) {
                animateNumber(number, 0, finalNumber, 1000);
            } else {
                animateNumber(number, 0, finalNumber, 1500);
            }
        });
    }

    function animateNumber(element, start, end, duration) {
        let startTime = null;
        const step = (timestamp) => {
            if (!startTime) startTime = timestamp;
            const progress = Math.min((timestamp - startTime) / duration, 1);
            const current = Math.floor(progress * (end - start) + start);
            
            if (element.textContent.includes('%')) {
                element.textContent = current + '%';
            } else {
                element.textContent = current.toLocaleString();
            }
            
            if (progress < 1) {
                requestAnimationFrame(step);
            }
        };
        requestAnimationFrame(step);
    }

    // Trigger animation when page loads
    setTimeout(animateNumbers, 500);

    // Add ripple effect to action cards
    document.querySelectorAll('.action-card').forEach(card => {
        card.addEventListener('click', function(e) {
            const ripple = document.createElement('span');
            const rect = this.getBoundingClientRect();
            const size = Math.max(rect.width, rect.height);
            const x = e.clientX - rect.left - size / 2;
            const y = e.clientY - rect.top - size / 2;
            
            ripple.style.cssText = `
                position: absolute;
                border-radius: 50%;
                background: rgba(59, 130, 246, 0.3);
                width: ${size}px;
                height: ${size}px;
                left: ${x}px;
                top: ${y}px;
                animation: ripple 0.6s ease-out;
                pointer-events: none;
                z-index: 1;
            `;
            
            this.appendChild(ripple);
            
            setTimeout(() => {
                ripple.remove();
            }, 600);
        });
    });
</script>

<%@ include file="footer.jsp" %>