package com.jsp.controller;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.CustomerConfig;
import com.jsp.dao.CustomerDao;
import com.jsp.dto.Customer;

public class CustomerControl {
  public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);
	CustomerDao cdao = context.getBean(CustomerDao.class);
	System.out.println("1.Save Customer\n2.Update Customer\n3.Verify by phone and pass\n4.Verify by email and pass\n5.Find by customer id");
	Scanner sc = new Scanner(System.in);
	
	switch(sc.nextInt()) {
	case 1:{
		System.out.println("Enter details one by one");
		Customer cu = new Customer();
		cu.setAge(sc.nextInt());
		cu.setEmail(sc.next());
		cu.setGender(sc.next());
		cu.setName(sc.next());
		cu.setPassword(sc.next());
		cu.setPhone(sc.nextLong());
		cu = cdao.saveCustomer(cu);
		if(cu!=null) {
			System.out.println("Saved");
		}else {
			System.err.println("not saved");
		}
	}break;
	
	case 2:{
		System.out.println("Enter details one by one");
		Customer cu = new Customer();
		cu.setId(sc.nextInt());
		cu.setAge(sc.nextInt());
		cu.setEmail(sc.next());
		cu.setGender(sc.next());
		cu.setName(sc.next());
		cu.setPassword(sc.next());
		cu.setPhone(sc.nextLong());
		cu = cdao.updateCustomer(cu);
		if(cu!=null) {
			System.out.println("Update");
		}else {
			System.err.println("not saved");
		}
	}break;
	case 3:{
		
		System.out.println("phone and password");
		Customer cu = cdao.verify(sc.nextLong(), sc.next());
		if(cu!=null) {
			System.out.println(cu);
		}else {
			System.err.println("not saved");
		}
	}break;
	
	
	case 4:{
		System.out.println("email and passwrod");
		Customer cu = cdao.verify(sc.next(), sc.next());
		if(cu!=null) {
			System.out.println(cu);
		}else {
			System.err.println("not saved");
		}
	}break;
	
	case 5:{
		System.out.println("Find by id");
		Customer cu = cdao.findbycid(sc.nextInt());
		if(cu!=null) {
			System.out.println(cu);
		}else {
			System.err.println("not saved");
		}
	}
	}
	

}
}
