package com.computers;

public class NoteBook implements Computer {
	private StringBuffer units = new StringBuffer();

	// @Override
	public void addUnit(String spec) {
		units.append(spec);
	}

	// @Override
	public void printUnits(String model) {
		System.out.println(model + ":" + units.toString());

	}

}
