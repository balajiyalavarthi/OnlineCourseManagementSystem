package com.codegnan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.DbConnection.DbConnection;
import com.codegnan.model.InstructorDetails;


public class InstructorDaoImp implements InstructorDao {

	@Override
	public String addInstructor(InstructorDetails instructorDetails) {
		String result = "";
		String insertQuery = "INSERT INTO instructor_details "
				+ "(instructorId, instructorName, instructorEmail, instructorCourse )" + "VALUES " + "(?, ?, ?, ?)";

		try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(insertQuery)) {

			ps.setInt(1, instructorDetails.getInstructorId());
			ps.setString(2, instructorDetails.getInstructorName());
			ps.setString(3, instructorDetails.getInstructorEmail());
			ps.setString(4, instructorDetails.getInstructorCourse());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted >= 1) {
				result += "success";
			} else {
				result += "failure";
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<InstructorDetails> getAllInstructors() {

		List<InstructorDetails> instructorsList = new ArrayList<>();

		String sqlquery = "select* from instructor_details";

		try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlquery)) {

			System.out.println("Instructor Id\tInstructor Name\tInstructor Email\tInstructor Courses");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				instructorsList
						.add(new InstructorDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Student not found " + e.getMessage());
		}

		return instructorsList;
	}

	@Override
	public InstructorDetails getByInstructorId(int instructorId) {

		String sqlQuery = "select* " + "from instructor_details " + "where instructorId = (?)";

		try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlQuery)) {

			ps.setInt(1, instructorId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return new InstructorDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String updateInstructor(InstructorDetails instructorDetails) {
		String result = "";

		String updateQuery = "update instructor_details "
				+ "SET instructorName = (?), instructorEmail = (?), instructorCourse = (?) "
				+ "where instructorId = (?)";

		try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(updateQuery)) {

			
			ps.setString(1, instructorDetails.getInstructorName());
			ps.setString(2, instructorDetails.getInstructorEmail());
			ps.setString(3, instructorDetails.getInstructorCourse());
			ps.setInt(4, instructorDetails.getInstructorId());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated >= 1) {
				result += "success";
			} else {
				result += "failure";
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleteInstructorById(int instructorId) {
		String result = "";

		String sqlQuery = "delete from instructor_details " + "where instructorId = (?)";
		try (PreparedStatement ps = DbConnection.getConnection().prepareStatement(sqlQuery)) {

			ps.setInt(1, instructorId);
			int rowsDeleted = ps.executeUpdate();

			if (rowsDeleted == 1) {
				result += "success";
			} else {
				result += "failure";
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Instructor with id " + instructorId + " not found to delete" + e.getMessage());
		}
		return result;

	}

}
