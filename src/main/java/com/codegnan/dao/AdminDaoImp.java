package com.codegnan.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.model.Admin;
import com.codegnan.DbConnection.DbConnection;

public class AdminDaoImp implements AdminDao {

    @Override
    public String addAdmin(Admin admin) throws ClassNotFoundException {
    	
        String result = "failure";
        
  
        try (Connection con = DbConnection.getConnection()) {
        	
            String query = "INSERT INTO admin (name, email, password) VALUES (?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPassword());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                result = "success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Admin> getAllAdmin() throws ClassNotFoundException {
    	
        List<Admin> list = new ArrayList<>();
        try (Connection con = DbConnection.getConnection()) {
            String query = "SELECT * FROM admin";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setAdminId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                list.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Admin getByAdminId(int id) throws ClassNotFoundException {
        Admin admin = null;
        
        try (Connection con = DbConnection.getConnection()) {
            String query = "SELECT * FROM admin WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                admin = new Admin();
                admin.setAdminId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public String updateByAdminId(Admin admin) throws ClassNotFoundException {
        String result = "failure";
        
        try (Connection con = DbConnection.getConnection()) {
            String query = "UPDATE admin SET name=?, email=?, password=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPassword());
            ps.setInt(4, admin.getAdminId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                result = "success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String deleteByAdminId(int id) throws ClassNotFoundException {
        String result = "failure";
        try (Connection con = DbConnection.getConnection()) {
            String query = "DELETE FROM admin WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                result = "success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
