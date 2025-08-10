package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.Assignment;

public class AssignmentDaoImp implements AssignmentDao {

	@Override
	public String addAssignment(Assignment assignment) throws ClassNotFoundException {

		String sql = "INSERT INTO assignment (course_id, title, description, due_date) VALUES (?, ?, ?, ?)";
		try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, assignment.getCourseId());
			ps.setString(2, assignment.getTitle());
			ps.setString(3, assignment.getDescription());
			ps.setDate(4, assignment.getDueDate());

			int rows = ps.executeUpdate();
			return rows > 0 ? "success" : "failure";

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}
	}

	@Override
	public List<Assignment> getAllAssignment() throws ClassNotFoundException {

		List<Assignment> list = new ArrayList<>();
		String sql = "SELECT * FROM assignment";

		try (Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Assignment a = new Assignment(rs.getInt("assignment_id"), rs.getInt("course_id"), rs.getString("title"),
						rs.getString("description"), rs.getDate("due_date"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Assignment getByAssignmentId(int assignmentId) throws ClassNotFoundException {
		Assignment a = null;
		String sql = "SELECT * FROM assignment WHERE assignment_id = ?";

		try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, assignmentId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					a = new Assignment(rs.getInt("assignment_id"), rs.getInt("course_id"), rs.getString("title"),
							rs.getString("description"), rs.getDate("due_date"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public List<Assignment> getAssignmentsForStudent(int studentId) throws ClassNotFoundException {
	    List<Assignment> list = new ArrayList<>();
	    String sql = "SELECT a.* FROM assignment a " +
	                 "JOIN course c ON a.course_id = c.course_id " +
	                 "JOIN enrollment e ON e.course_id = c.course_id " +
	                 "WHERE e.student_id = ?";
	    try (Connection con = DbConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, studentId);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Assignment a = new Assignment();
	                a.setAssignmentId(rs.getInt("assignment_id"));
	                a.setCourseId(rs.getInt("course_id"));
	                a.setTitle(rs.getString("title"));
	                a.setDescription(rs.getString("description"));
	                a.setDueDate(rs.getDate("due_date"));
	                list.add(a);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}


	@Override
	public String updateByAssignmentId(Assignment assignment) throws ClassNotFoundException {
		String sql = "UPDATE assignment SET course_id=?, title=?, description=?, due_date=? WHERE assignment_id=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, assignment.getCourseId());
			ps.setString(2, assignment.getTitle());
			ps.setString(3, assignment.getDescription());
			ps.setDate(4, assignment.getDueDate());
			ps.setInt(5, assignment.getAssignmentId());

			int rows = ps.executeUpdate();
			return rows > 0 ? "success" : "notFound";

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}
	}

	@Override
	public String deleteByAssignmentId(int assignmentId) throws ClassNotFoundException {
		String sql = "DELETE FROM assignment WHERE assignment_id=?";
		try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, assignmentId);
			int rows = ps.executeUpdate();
			return rows > 0 ? "success" : "notFound";

		} catch (SQLException e) {
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}
	}

	public void saveSubmission(int studentId, int assignmentId, String filePath) throws ClassNotFoundException {
		String sql = "INSERT INTO submission (assignment_id, student_id, file_path, submitted_on) VALUES (?, ?, ?, CURRENT_DATE)";

		try (Connection conn = DbConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, assignmentId);
			stmt.setInt(2, studentId);
			stmt.setString(3, filePath);

			stmt.executeUpdate();

		} catch (SQLException e) {
			if (e.getMessage().contains("Duplicate entry")) {
				throw new RuntimeException("You have already submitted this assignment.");
			}
			e.printStackTrace();
			throw new RuntimeException("Error saving submission", e);
		}
	}
}
