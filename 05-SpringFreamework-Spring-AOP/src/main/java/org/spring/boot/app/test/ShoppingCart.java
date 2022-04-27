package org.spring.boot.app.test;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

	public void checkout() {
		System.out.println("Checkout Method Called....");
	}
	
}
