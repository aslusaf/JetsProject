package com.skilldistillery.jets.aircraft;

import com.skilldistillery.jets.abstractclasses.GlobalPrecisionAttack;

public class Bomber extends GlobalPrecisionAttack {

	public Bomber() {
		this.setType("Bomber");
	}

	public Bomber(String model, double speed, int range, double price) {
		super();
		this.setType("Bomber");
		this.setModel(model);
		this.setSpeed(speed);
		this.setRange(range);
		this.setPrice(price);
	}

}
