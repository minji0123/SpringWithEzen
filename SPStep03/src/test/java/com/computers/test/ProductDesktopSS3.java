package com.computers.test;

import java.awt.Desktop;

// import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.computers.Computer;
import com.computers.Product;

public class ProductDesktopSS3 {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("context-product.xml");
		
		Product product = context.getBean("product", Product.class);
		product.addUnit("터치모니터");
		product.addUnit("무선마우스");
		product.printUnits();

		Computer computer = context.getBean("desktop", Computer.class);
		computer.printUnits("HP-DESKTOP-x7");
		
		// 싱클톤
		System.out.println("[computert == product.getComputer()] ? " + (computer == product.getComputer()));
		
		context.close();
	}

}
