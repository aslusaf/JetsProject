package com.skilldistillery.jets.aircraft;

import com.skilldistillery.jets.abstractclasses.ISR;

public class RPA extends ISR {

	public RPA() {
		this.setType("RPA");
	}

	public RPA(String model, double speed, int range, double price) {
		super();
		this.setType("RPA");
		this.setModel(model);
		this.setSpeed(speed);
		this.setRange(range);
		this.setPrice(price);
	}

}
