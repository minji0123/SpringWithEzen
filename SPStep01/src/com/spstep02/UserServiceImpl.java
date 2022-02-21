package com.spstep02;

public class UserServiceImpl implements UserService {

	private String name;
	private int age;
	
	
	UserServiceImpl(){
		this.name = "none";
	}
	
	
	UserServiceImpl(String name){
		this.name = name;
	}
	
	UserServiceImpl(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public void setName(String name) {
		this.name= name;
	}
	
	@Override
	public void setAge(int age) {
		this.age = age;
		
	}

	
	@Override
	public void hiUser() {
		System.out.println("이름: "+ this.name);
		System.out.println("나이: "+ this.age);

	}



}
