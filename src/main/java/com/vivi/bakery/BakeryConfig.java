package com.vivi.bakery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BakeryConfig {	
	@Bean
	public GroceryShop getGroceryShop() {
		return new GroceryShop();		
	}
}
