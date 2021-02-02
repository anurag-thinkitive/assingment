package com.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {

	@Bean
	public Employee getInstance() {
		return new Employee(2000,1000,"srijan");
	}
}
