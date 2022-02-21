package com.spstep01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class UserServiceSpringMain {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("user.xml"));
		UserService user = (UserService)factory.getBean("userService");
		user.hiUser();
	}

}
