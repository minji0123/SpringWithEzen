package com.spstep01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class UserServiceSpringMain2 {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("user.xml"));
		UserService user1 = (UserService)factory.getBean("userService");
		UserService user2 = (UserService)factory.getBean("userService");
		user1.hiUser();
		user2.hiUser();
		
		System.out.println("user1 == user2 ?  "+ (user1 == user2)); // 얘는 빈이 다 같아서 같은 객체
	}

}
