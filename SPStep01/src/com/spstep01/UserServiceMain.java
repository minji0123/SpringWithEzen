package com.spstep01;

public class UserServiceMain {

	public static void main(String[] args) {
		UserService user1 = new UserServiceImpl();
		user1.setName("스프링");
		user1.setAge(5);
		user1.hiUser();
		
		
		UserService user2 = new UserServiceImpl();
		user2.setName("스프링");
		user2.setAge(5);
		user2.hiUser();

		System.out.println("user1 == user2 ?  "+ (user1 == user2));
	}
}
