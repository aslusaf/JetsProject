package com.skilldistillery.jets.abstractclasses;

import java.util.Scanner;

import com.skilldistillery.jets.interfaces.CargoCarrier;

public abstract class RapidGlobalMobility extends Jet implements CargoCarrier {

	private boolean cargoLoaded;
	private boolean airDroppedCargo;

	public RapidGlobalMobility() {
		this.cargoLoaded = false;
		this.airDroppedCargo = false;
	}

	@Override
	public void loadCargo() {
		
		if (this.isFlying()) {
			System.out.println(" You can't load cargo in the middle of the sky.....");
			return;
		}

		if (cargoLoaded) {
			System.out.println(" The cargo hold is full.....");
		} else {
			System.out.println(" Loading cargo........loading complete");
			System.out.println(" Weight and balance are within limits.");
			cargoLoaded = true;
		}

	}

	@Override
	public void airDropCargo() {

		if (!this.isFlying()) {
			System.out.println(" Unable. You are on the ground.....");
			return;
		}

		if (cargoLoaded) {
			System.out.println(" Green light, cleared for drop.....");
			System.out.println(" All cargo deployed.");
			airDroppedCargo = true;
			cargoLoaded = false;
		} else {
			if (airDroppedCargo) {
				System.out.println(" We already dropped the cargo Sir......");
			} else {
			System.out.println(" Uh oh, we forgot to load the cargo before takeoff.....");
			}
		}

	}
	
	@Override
	public void subMenu(Scanner kb) {
		
		int selection = 0;

		System.out.println(" You are in the " + this.getModel() + ".");

		do {
			
			System.out.println();
			System.out.print("\u250c"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2510");
			System.out.println("\u2502                 \u2508\u2509 Action Menu \u2509\u2508                  \u2502");
			System.out.print("\u251c"); for (int i = 0; i < 52; i++) System.out.print("\u2500");System.out.print("\u2524");
			System.out.println();
			System.out.println("\u2502 1) Takeoff                                         \u2502");
			System.out.println("\u2502 2) Land                                            \u2502");
			System.out.println("\u2502 3) Load Cargo                                      \u2502");
			System.out.println("\u2502 4) Airdrop the cargo                               \u2502");
			System.out.println("\u2502 5) Return to main menu                             \u2502");
			System.out.print("\u2514"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2518");
			System.out.print(" \u21f6 ");
			selection = kb.nextInt();
			kb.nextLine();
			System.out.println();

			switch (selection) {
			case (1):
				this.fly();
				break;
			case (2):
				this.land();
				break;
			case (3):
				this.loadCargo();;
				break;
			case (4):
				this.airDropCargo();;
				break;
			case (5):
				if (this.isFlying()) {
					selection = 0;
					System.out.println(" You need to land first!");
					continue;
				}
				break;

			}
		} while (selection != 5);

	}


}
