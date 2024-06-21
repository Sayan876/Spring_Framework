package com.jsp.controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsp.dao.AdminDao;
import com.jsp.dto.Admin;

public class AdminCrud {
    public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AC.xml");
		AdminDao cdao = context.getBean(AdminDao.class);
		System.out.println("1.Save admin\n2.Update admin\n3.Find by id\n4.Delete ");
		
		Scanner sc = new Scanner(System.in);
		
		switch(sc.nextInt()) {
		case 1:{
			
			System.out.println("Enter detials one by one");
			Admin ad = new Admin();
			ad.setEmail(sc.next());
			ad.setName(sc.next());
			ad.setPassword(sc.next());
			ad.setPhone(sc.nextLong());
			
			ad = cdao.saveAdmin(ad);
			if(ad!=null) {
				System.out.println("Admin saved");
			}else {
				System.out.println("not saved");
			}
			
		}break;
		
		case 2:{
			System.out.println("Enter detials one by one");
			Admin ad = new Admin();
			ad.setId(sc.nextInt());
			ad.setEmail(sc.next());
			ad.setName(sc.next());
			ad.setPassword(sc.next());
			ad.setPhone(sc.nextLong());
			
			ad = cdao.updateAdmin(ad);
			
			if(ad!=null) {
				System.out.println("Updated");
			}else {
				System.out.println("not saved");
			}
			
		}break;
		
		case 3:{
			System.out.println("Enter the id to find");
			Admin ad = cdao.findbyid(sc.nextInt());
			if(ad!=null) {
				System.out.println(ad);
			}else {
				System.err.println("Cannot fetch");
			}
			
		}break;
		
		case 4:{System.out.println("Enter the id to find");
		Admin ad = cdao.deleteAdmin(sc.nextInt());
		if(ad!=null) {
			System.out.println("deleted");
		}else {
			System.err.println("Cannot fetch");
		}}break;
		}
	}
}
