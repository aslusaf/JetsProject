package com.skilldistillery.jets.aircraft;

import com.skilldistillery.jets.abstractclasses.RapidGlobalMobility;

public class CargoJet extends RapidGlobalMobility {

	public CargoJet() {
		this.setType("Military Cargo Jet");
	}

	public CargoJet(String model, double speed, int range, double price) {
		this.setType("Cargo Jet");
		this.setModel(model);
		this.setSpeed(speed);
		this.setRange(range);
		this.setPrice(price);
	}

}
