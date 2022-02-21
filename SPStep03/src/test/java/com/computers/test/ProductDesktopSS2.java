package com.computers.test;

// import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.computers.Product;

public class ProductDesktopSS2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("context-product-test.xml");
		
		Product product = (Product)context.getBean("product");
		product.addUnit("터치모니터");
		product.addUnit("무선마우스");
		product.printUnits();

		// 캐스팅을 하지 않아도 된다.
		Product product2 = context.getBean("product", Product.class);
		product2.printUnits();
		
		// 싱클톤
		System.out.println("[product == product2] ? " + (product == product2));
		
		context.close();
	}

}
