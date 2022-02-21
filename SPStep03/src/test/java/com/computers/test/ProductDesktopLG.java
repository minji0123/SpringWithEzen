package com.computers.test;

import com.computers.*;

public class ProductDesktopLG {

	public static void main(String[] args) {
		Product product = new Product();
		product.setComputer(new Desktop());
		product.setModel("LG-DESKTOP-10");
		product.addUnit("usb-keyboard");
		product.addUnit("wireless-mouse");
		product.printUnits();
	}

}
