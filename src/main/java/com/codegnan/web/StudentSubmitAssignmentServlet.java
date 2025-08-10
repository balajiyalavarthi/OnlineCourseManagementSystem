package com.codegnan.web;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import com.codegnan.model.Submission;
import com.codegnan.service.SubmissionServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/submitAssignment")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,     // 10MB
                 maxRequestSize = 1024 * 1024 * 50) // 50MB
public class StudentSubmitAssignmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SubmissionServiceImp submissionService = new SubmissionServiceImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));

        // Get uploaded file
        Part filePart = request.getPart("assignmentFile");
        String fileName = filePart.getSubmittedFileName();

        // Save to uploads directory (make sure it exists)
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        // Create Submission object
        Submission submission = new Submission();
        submission.setAssignmentId(assignmentId);
        submission.setStudentId(studentId);
        submission.setFilePath("uploads/" + fileName); // relative path for web access
        submission.setSubmittedOn(Date.valueOf(LocalDate.now()));

        try {
            String result = submissionService.save(submission);
            if ("success".equals(result)) {
                request.setAttribute("message", "Assignment submitted successfully!");
            } else {
                request.setAttribute("error", "Failed to submit assignment: " + result);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while submitting the assignment.");
        }

        request.getRequestDispatcher("student_dashboard.jsp").forward(request, response);
    }
}
