package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.dto.Customer;

@Repository
public class CustomerDao {

	@Autowired
	private EntityManager manager;
	
	public Customer saveCustomer(Customer customer) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
		return customer;
	}
	
	public Customer updateCustomer(Customer customer) {
		Customer dbc = manager.find(Customer.class, customer.getId());
		if(dbc!=null) {
			EntityTransaction transaction = manager.getTransaction();
			dbc.setAddresses(customer.getAddresses());
			dbc.setAge(customer.getAge());
			dbc.setEmail(customer.getEmail());
			dbc.setGender(customer.getGender());
			dbc.setName(customer.getName());
			dbc.setPassword(customer.getPassword());
			dbc.setPhone(customer.getPhone());
			transaction.begin();
			transaction.commit();
			return dbc;
		}return null;
	}
	
	public Customer findbycid(int id) {
		return manager.find(Customer.class, id);
	}
	
	public Customer verify(long phone, String password) {
		Query query = manager.createQuery("select c from Customer c where c.phone=?1 and c.password=?2");
		query.setParameter(1, phone);
		query.setParameter(2, password);
		try {
			return (Customer) query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public Customer verify(String email, String password) {
		Query query = manager.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			return (Customer) query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
}
