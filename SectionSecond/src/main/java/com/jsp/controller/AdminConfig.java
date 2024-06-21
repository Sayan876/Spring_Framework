package com.jsp.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class AdminConfig {
  public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("AC.xml");
	HibernateTemplate template = context.getBean("hibernateTemplate",HibernateTemplate.class);
	System.out.println(template);
}
}
