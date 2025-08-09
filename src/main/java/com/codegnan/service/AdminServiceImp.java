package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.AdminDaoImp;
import com.codegnan.model.Admin;

public class AdminServiceImp implements AdminService{

	
	AdminDaoImp adminImp = new AdminDaoImp();
	
	@Override
	public String save(Admin admin) throws ClassNotFoundException {
		
		return adminImp.addAdmin(admin);
	}

	@Override
	public List<Admin> findAll() throws ClassNotFoundException {
		
		return adminImp.getAllAdmin();
	}

	@Override
	public Admin findById(int id) throws ClassNotFoundException {
		
		return adminImp.getByAdminId(id);
	}

	@Override
	public String update(Admin admin) throws ClassNotFoundException {
		
		return adminImp.updateByAdminId(admin);
	}

	@Override
	public String delete(int id) throws ClassNotFoundException {
		
		return adminImp.deleteByAdminId(id);
	}

}
 