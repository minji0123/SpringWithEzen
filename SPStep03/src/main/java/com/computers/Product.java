package com.computers;

public class Product {
	private String model;
	private Computer computer;
	
	public Product() {}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	public void addUnit(String unit) {
		computer.addUnit(unit + "\n");
	}
	
	public void printUnits() {
		computer.printUnits(model);
	}
}
