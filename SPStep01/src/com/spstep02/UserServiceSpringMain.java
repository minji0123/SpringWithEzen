package com.spstep02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class UserServiceSpringMain {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("user2.xml"));
		
		UserService user = (UserService)factory.getBean("userService");
		user.hiUser();
		
		
		UserService user1 = (UserService)factory.getBean("userService1");
		user1.hiUser();
		
		
		UserService user2 = (UserService)factory.getBean("userService2");
		user2.hiUser();
		
		UserService user3 = (UserService)factory.getBean("userService3");
		user3.hiUser();
		
		System.out.println("user1 == user2 ?  "+ (user1 == user2));
		System.out.println("user2 == user3 ?  "+ (user2 == user3));
		System.out.println("user1 == user3 ?  "+ (user1 == user3));
		// 얘네는 빈이 다 달라서 다른 객체
	}

}
