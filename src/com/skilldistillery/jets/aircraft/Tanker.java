package com.skilldistillery.jets.aircraft;

import com.skilldistillery.jets.abstractclasses.AirRefueling;

public class Tanker extends AirRefueling {

	public Tanker() {
		this.setType("Tanker");
	}

	public Tanker(String model, double speed, int range, double price) {
		super();
		this.setType("Tanker");
		this.setModel(model);
		this.setSpeed(speed);
		this.setRange(range);
		this.setPrice(price);
	}

}
