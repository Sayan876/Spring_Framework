package com.jsp.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.jsp.dto.Admin;

@Repository
public class AdminDao {
	@Autowired
  private HibernateTemplate ht;
	@Transactional
	public Admin saveAdmin(Admin admin) {
		ht.save(admin);
		return admin;
	}
	
	public Admin findbyid(int id) {
		return ht.get(Admin.class, id);
	}
	
	@Transactional
	public Admin updateAdmin(Admin admin) {
		Admin dmin = findbyid(admin.getId());
		if(dmin!=null) {
			dmin.setEmail(admin.getEmail());
			dmin.setName(admin.getName());
			dmin.setPassword(admin.getPassword());
			dmin.setPhone(admin.getPhone());
			return dmin;
		}return null;
	}
	
	@Transactional
	public Admin deleteAdmin(int id) {
		Admin dmin = findbyid(id);
		if(dmin!=null) {
			ht.delete(dmin);
			return dmin;
		}return null;
	}
}
