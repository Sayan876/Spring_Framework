package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.dto.Address;
import com.jsp.dto.Customer;

@Repository
public class AddressDao {
	@Autowired
	private EntityManager manager;

	public Address saveaddress(Address address, int id) {
		Customer cust = manager.find(Customer.class, id);
		if (cust != null) {
			EntityTransaction transaction = manager.getTransaction();
			cust.getAddresses().add(address);
			address.setCustomer(cust);
			transaction.begin();
			manager.persist(address);
			transaction.commit();
			return address;
		}
		return null;

	}

	public Address updateAddress(Address address) {
		Address da = manager.find(Address.class, address.getId());
		if (da != null) {
			EntityTransaction transaction = manager.getTransaction();
			da.setBname(address.getBname());
			da.setCity(address.getCity());
			da.setCountry(address.getCountry());
			da.setHousenumber(address.getHousenumber());
			da.setLmark(address.getLmark());
			da.setPincode(address.getPincode());
			da.setState(address.getState());
			transaction.begin();
			transaction.commit();
			return da;
		}
		return null;
	}
	
	
	
	public List<Address> findbyCustid(int id) {
		Query query = manager.createQuery("select c.addresses from Customer c where c.id=?1");
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	
	public List<Address> findbyphoneandpass(long phone, String pass){
		Query query = manager.createQuery("select c.addresses from Customer c where c.phone=?1 and c.password=?2");
		query.setParameter(1, phone);
		query.setParameter(2, pass);
		return query.getResultList();
	}
	
	public Address findbyaid(int id) {
		return manager.find(Address.class, id);
	}
}
