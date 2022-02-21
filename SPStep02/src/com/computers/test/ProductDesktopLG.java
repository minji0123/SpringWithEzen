package com.computers.test;
import com.computers.*;
public class ProductDesktopLG {

	public static void main(String[] args) {
		Product product = new Product();
		product.setComputer(new Desktop());
		product.setModel("LG");
		product.addUnit("usbKeyboard");
		product.addUnit("wirelessMouse");
		product.printUnits();
	}

}
