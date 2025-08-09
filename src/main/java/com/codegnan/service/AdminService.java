package com.codegnan.service;

import java.util.List;

import com.codegnan.model.Admin;

public interface AdminService {
	
	public String save(Admin admin) throws ClassNotFoundException;
    
    public List<Admin> findAll() throws ClassNotFoundException;
    
    public Admin findById(int id) throws ClassNotFoundException;
    
    public String update(Admin admin) throws ClassNotFoundException;
    
    public String delete(int id) throws ClassNotFoundException;
}
