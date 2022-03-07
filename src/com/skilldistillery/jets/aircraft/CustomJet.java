package com.skilldistillery.jets.aircraft;

import com.skilldistillery.jets.abstractclasses.Jet;

public class CustomJet extends Jet {

	public CustomJet() {}
	
	public CustomJet(String type, String model, double speed, int range, double price) {
		super(type, model, speed, range, price);
	}

}
