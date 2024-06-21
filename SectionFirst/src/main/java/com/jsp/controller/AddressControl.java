package com.jsp.controller;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.CustomerConfig;
import com.jsp.dao.AddressDao;
import com.jsp.dto.Address;
public class AddressControl {
    public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);
		AddressDao adao = context.getBean(AddressDao.class);
		System.out.println("1.Add address\n2.Update Address\n3.Find by customer id\n4.Find by phone and password\n5.Find by id");
		Scanner sc = new Scanner(System.in);
		
		switch(sc.nextInt()) {
		case 1:{
			System.out.println("Enter the cust id to begin with");
			int id = sc.nextInt();
			Address ad = new Address();
			ad.setBname(sc.next());
			ad.setCity(sc.next());
			ad.setCountry(sc.next());
			ad.setHousenumber(sc.next());
			ad.setLmark(sc.next());
			ad.setPincode(sc.nextInt());
			ad.setState(sc.next());
			
			ad = adao.saveaddress(ad, id);
			
			if(ad!=null) {
				System.out.println("Saved");
			}else {
				System.out.println("not saved");
			}
		}break;
		
		case 2:{
			System.out.println("Enter theid to begin with");
			
			Address ad = new Address();
			ad.setId(sc.nextInt());
			ad.setBname(sc.next());
			ad.setCity(sc.next());
			ad.setCountry(sc.next());
			ad.setHousenumber(sc.next());
			ad.setLmark(sc.next());
			ad.setPincode(sc.nextInt());
			ad.setState(sc.next());
			
			ad = adao.updateAddress(ad);
			
			if(ad!=null) {
				System.out.println("UPdated");
			}else {
				System.out.println("not saved");
			}
		}break;
		
		case 3:{
			System.out.println("Enter the customer id");
			List<Address> ad = adao.findbyCustid(sc.nextInt());
			if(ad.isEmpty()) {
				System.out.println("Nothing is here");
			}else {
				for(Address a:ad) {
					System.out.println(a);
				}
			}
		}break;
		
		case 4:{
			System.out.println("Enter phone and password");
			List<Address> ad = adao.findbyphoneandpass(sc.nextLong(), sc.next());
			if(ad.isEmpty()) {
				System.out.println("Nothing is here");
			}else {
				for(Address a:ad) {
					System.out.println(a);
				}
			}
		}break;
		
		case 5:{
			System.out.println("Enter the address id");
			
			Address ad = adao.findbyaid(sc.nextInt());
			if(ad!=null) {
				System.out.println(ad);
			}else {
				System.out.println("not saved");
			}
		}break;
		}
		
	}
}
