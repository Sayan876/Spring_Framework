package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.jsp"})
public class CustomerConfig {
    @Bean
	public EntityManager manager() {
		return Persistence.createEntityManagerFactory("development").createEntityManager();
	}
}
