package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.dto.Merchant;

@Repository
public class MerchantDao {
    @Autowired
	private EntityManager manager;
    
    public Merchant saveMerchant(Merchant merchant) {
    	EntityTransaction transaction = manager.getTransaction();
    	transaction.begin();
    	manager.persist(merchant);
    	transaction.commit();
    	return merchant;
    }
    
    public Merchant updateMerchant(Merchant merchant) {
    	Merchant dm = manager.find(Merchant.class, merchant.getId());
    	if(dm!=null) {
    		EntityTransaction transaction = manager.getTransaction();
    		dm.setGnumber(merchant.getGnumber());
    		dm.setName(merchant.getName());
    		dm.setPassword(merchant.getPassword());
    		dm.setPhone(merchant.getPhone());
    		dm.setEmail(merchant.getEmail());
    		transaction.begin();
    		transaction.commit();
    		return dm;
    	}return null;
    }
    
    public Merchant verify(long phone, String password) {
    	Query query = manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
        query.setParameter(1, phone);
        query.setParameter(2, password);
        return (Merchant) query.getSingleResult();
    }
    
    
    public Merchant verify(String email, String password) {
    	Query query = manager.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
        query.setParameter(1, email);
        query.setParameter(2, password);
        return (Merchant) query.getSingleResult();
    }
}
