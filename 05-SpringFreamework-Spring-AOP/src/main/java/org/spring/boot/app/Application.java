package org.spring.boot.app;

import org.spring.boot.app.configuration.BeanConfiguration;
import org.spring.boot.app.test.ShoppingCart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		ShoppingCart cart = context.getBean(ShoppingCart.class);
		cart.checkout();
		
	}

}
