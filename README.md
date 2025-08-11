# 🎓 Online Course Management System

A comprehensive web-based course management platform built with Java servlets, JSP, and MySQL, featuring role-based access control and assignment submission capabilities.

## 🌟 Features

### 👑 **Admin Dashboard**
- **Complete System Control**: Access to all features across student and instructor roles
- **User Management**: Add, view, edit, and delete admins, students, and instructors
- **Course Oversight**: Manage all courses with enhanced search functionality
- **Centralized Control**: Single dashboard to monitor entire system

### 👨‍🎓 **Student Portal**
- **Personal Profile**: View and update profile information
- **Course Access**: Browse available courses and view enrolled courses
- **Assignment Hub**: View assigned tasks and track deadlines
- **Submission System**: Submit assignments with file upload capability
- **Grade Tracking**: Monitor academic performance and grades
- **Peer Network**: Search and connect with other students

### 👨‍🏫 **Instructor Interface**
- **Course Management**: Create and manage courses
- **Assignment Creation**: Design and distribute assignments to students
- **Submission Review**: View, download, and evaluate student submissions
- **Grade Management**: Assign and track student grades
- **Profile Control**: Update personal information and credentials

## 🏗️ Architecture

### **Technology Stack**
- **Frontend**: JSP (JavaServer Pages), HTML5, CSS3
- **Backend**: Java Servlets (20+ servlets)
- **Database**: MySQL with JDBC connectivity
- **Session Management**: HTTP Sessions for role-based authentication
- **File Structure**: 25+ JSP files for comprehensive UI

### **Security Features**
- Role-based access control (Admin, Student, Instructor)
- Session-based authentication
- Secure logout functionality
- Protected routes with role validation

## 📊 Database Schema

The system uses a well-structured MySQL database with the following entities:

### **Core Tables**
- **`admin`** - System administrators
- **`student`** - Student information and credentials
- **`instructor`** - Faculty members and their details
- **`course`** - Course catalog and metadata

### **Relationship Tables**
- **`enrollment`** - Student-course associations
- **`assignment`** - Course assignments and deadlines
- **`submission`** - Student assignment submissions
- **`grades`** - Performance tracking and evaluation

### **Key Relationships**
```
instructor (1) ←→ (N) course
course (1) ←→ (N) enrollment ←→ (N) student
course (1) ←→ (N) assignment
assignment (1) ←→ (N) submission ←→ (N) student
submission (1) ←→ (1) grades
```

## 🚀 Getting Started

### **Prerequisites**
- Java Development Kit (JDK 8 or higher)
- Apache Tomcat Server
- MySQL Database Server
- IDE (Eclipse, IntelliJ IDEA, or VS Code)

### **Installation Steps**

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd course-management-system
   ```

2. **Database Setup**
   ```sql
   CREATE DATABASE courseManagement;
   -- Run the provided SQL script to create all tables
   ```

3. **Configure Database Connection**
   - Update JDBC connection parameters in your configuration files
   - Ensure MySQL driver is included in the classpath

4. **Deploy to Tomcat**
   - Build the WAR file
   - Deploy to your Tomcat server
   - Start the server

5. **Access the Application**
   ```
   http://localhost:8080/course-management-system
   ```

## 📱 User Interfaces

### **Dashboard Highlights**

#### **Student Dashboard**
- Clean, intuitive interface with quick access to courses and assignments
- Modern gradient-styled logout button with hover effects
- Comprehensive menu for all student activities

#### **Instructor Dashboard**
- Professional layout with organized course and assignment management
- Alert system for success/error messages
- Streamlined navigation for efficient workflow

#### **Admin Dashboard**
- Sophisticated card-based layout for different management sections
- Glassmorphism design elements with backdrop blur effects
- Advanced styling with gradients and modern typography

## 🔐 Authentication & Sessions

### **Role-Based Access**
- **Session Validation**: Each page validates user role and session
- **Automatic Redirects**: Unauthorized access redirects to login
- **Secure Logout**: Complete session cleanup on logout
- **Cross-Role Prevention**: Users cannot access unauthorized dashboards

### **Session Management**
```java
// Example session validation
String role = (String) session.getAttribute("role");
if (role == null || !"STUDENT".equals(role)) {
    response.sendRedirect("login.jsp");
    return;
}
```

## 📈 System Capabilities

### **File Management**
- Assignment file uploads
- Submission downloads for instructors
- Secure file storage and retrieval

### **Academic Tracking**
- Real-time grade monitoring
- Assignment deadline management
- Course progress tracking
- Enrollment history

### **Search & Discovery**
- Student search functionality
- Course catalog browsing
- Assignment filtering
- Instructor lookup

## 🛠️ Technical Implementation

### **Servlet Architecture**
- **20+ Servlets** handling different functionalities
- RESTful URL patterns for intuitive navigation
- Centralized error handling and logging

### **Database Optimization**
- **Indexed columns** for improved query performance
- **Foreign key constraints** ensuring data integrity
- **Unique constraints** preventing duplicate records
- **Cascade operations** for consistent data management

### **Frontend Design**
- **Responsive CSS** with modern styling techniques
- **Interactive elements** with JavaScript enhancements
- **Consistent theming** across all user interfaces
- **Accessibility features** for inclusive design

## 🔄 Future Enhancements

- **Real-time Notifications**: WebSocket integration for instant updates
- **Mobile Application**: React Native or Flutter mobile app
- **Advanced Analytics**: Course and student performance dashboards
- **Discussion Forums**: Interactive communication platform
- **Calendar Integration**: Assignment and course scheduling
- **Multi-language Support**: Internationalization features

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Contact

For any queries or support, please reach out:
- **Email**: [your-email@example.com]
- **Project Link**: [https://github.com/yourusername/course-management-system]

---

⭐ **If you found this project helpful, please consider giving it a star!** ⭐
