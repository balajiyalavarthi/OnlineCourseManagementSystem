package com.codegnan.web;

import java.io.IOException;
import java.util.List;

import com.codegnan.dao.SubmissionDao;
import com.codegnan.dao.SubmissionDaoImp;
import com.codegnan.model.Submission;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/studentsubmissions")
public class ViewSubmissionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SubmissionDaoImp submissionDao = new SubmissionDaoImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer studentId = (Integer) session.getAttribute("studentId");

        if (studentId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            List<Submission> submissions = submissionDao.findByStudentId(studentId);
            request.setAttribute("submissions", submissions);
            request.getRequestDispatcher("view_submissions.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", "Error loading submissions");
            response.sendRedirect("student_dashboard.jsp");
        }
    }
}
