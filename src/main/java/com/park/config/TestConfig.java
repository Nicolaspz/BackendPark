package com.park.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	com.park.service.DBService dbService;
	
	@Bean
	 public void InstanciarBaseDeDados() {
		 this.dbService.InstaciaBaseDeDados();
	 }
	

}
