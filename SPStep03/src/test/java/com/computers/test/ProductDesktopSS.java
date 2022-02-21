package com.computers.test;

// import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.computers.Product;

public class ProductDesktopSS {

	public static void main(String[] args) {
		// GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:context-product-test.xml");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("context-product-test.xml");
		
		Product product = (Product)context.getBean("product");
		product.addUnit("터치모니터");
		product.addUnit("무선마우스");
		product.printUnits();
		
		context.close();
	}

}
