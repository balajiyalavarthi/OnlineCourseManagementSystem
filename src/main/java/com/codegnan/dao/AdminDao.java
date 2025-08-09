package com.codegnan.dao;

import java.util.List;
import com.codegnan.model.Admin;

public interface AdminDao {
    
    public String addAdmin(Admin admin) throws ClassNotFoundException;
    
    public List<Admin> getAllAdmin() throws ClassNotFoundException;
    
    public Admin getByAdminId(int id) throws ClassNotFoundException;
    
    public String updateByAdminId(Admin admin) throws ClassNotFoundException;
    
    public String deleteByAdminId(int id) throws ClassNotFoundException;
}
