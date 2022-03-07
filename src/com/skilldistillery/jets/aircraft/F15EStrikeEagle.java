package com.skilldistillery.jets.aircraft;

import java.util.Scanner;

import com.skilldistillery.jets.interfaces.SuperCruiser;

public class F15EStrikeEagle extends FighterJet implements SuperCruiser {
	
	FighterJet fj = new FighterJet();
	
	private boolean superCruiseEngaged;
	
	public F15EStrikeEagle() {

		this.setModel("F-15E Strike Eagle");
		this.setSpeed(1875);
		this.setRange(2400);
		this.setPrice(31100000);
		this.superCruiseEngaged = false;
	}
	
	@Override
	public void engageSuperCruise() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		
		if (fj.isAfterburnersEngaged()) {
			if (superCruiseEngaged) {
				System.out.println(" Supercruise is already engaged.....");
			} else {
				System.out.println(" Supercruise engaged. Fuel burn reduced.");
				superCruiseEngaged = true;
			}
		} else {
			System.out.println(" You need to engage the afterburners first.....");
		}
	}
	
	@Override
	public void disengageSuperCruise() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		
		if (fj.isAfterburnersEngaged() && superCruiseEngaged) {
			System.out.println(" Disengaging supercruise. Fuel burn increasing...");
			superCruiseEngaged = false;
		} else if (fj.isAfterburnersEngaged() && !superCruiseEngaged) {
			System.out.println(" Supercruise isn't engaged.....");
		} else {
			System.out.println(" You can't engage supercruise, you don't even have the afterburners engaged.");
			System.out.println(" Are you sure you're a fighter pilot?");
		}

		
	}
	
	@Override
	public void subMenu(Scanner kb) {

		int selection = 0;

		System.out.println(" You are in the " + this.getModel() + ".");

		do {

			System.out.println();
			System.out.print("\u250c");
			for (int i = 0; i < 52; i++)
				System.out.print("\u2500");
			System.out.println("\u2510");
			System.out.println("\u2502                 \u2508\u2509 Action Menu \u2509\u2508                  \u2502");
			System.out.print("\u251c");
			for (int i = 0; i < 52; i++)
				System.out.print("\u2500");
			System.out.print("\u2524");
			System.out.println();
			System.out.println("\u2502 1)  Takeoff                                        \u2502");
			System.out.println("\u2502 2)  Land                                           \u2502");
			System.out.println("\u2502 3)  Engage enemy aircraft                          \u2502");
			System.out.println("\u2502 4)  Lock on to enemy aircraft                      \u2502");
			System.out.println("\u2502 5)  Fire Air-to-Air missles                        \u2502");
			System.out.println("\u2502 6)  Disengage enemy aircraft                       \u2502");
			System.out.println("\u2502 7)  Barrel roll                                    \u2502");
			System.out.println("\u2502 8)  High-G turn                                    \u2502");
			System.out.println("\u2502 9)  Engage Afterburners                            \u2502");
			System.out.println("\u2502 10) Disengage afterburners                         \u2502");
			System.out.println("\u2502 11) Engage supercruise                             \u2502");
			System.out.println("\u2502 12) Disengage supercruise                          \u2502");
			System.out.println("\u2502 13) Connect to fuel boom                           \u2502");
			System.out.println("\u2502 14) Refuel in flight                               \u2502");
			System.out.println("\u2502 15) Return to main menu                            \u2502");
			System.out.print("\u2514");
			for (int i = 0; i < 52; i++)
				System.out.print("\u2500");
			System.out.println("\u2518");
			System.out.print(" \u21f6 ");

			selection = kb.nextInt();

			switch (selection) {
			case (1):
				this.fly();
				break;
			case (2):
				this.land();
				break;
			case (3):
				this.engageEnemyAircraft();
				break;
			case (4):
				this.lockOnToEnemyAircraft();
				break;
			case (5):
				this.launchAirToAirMissles();
				break;
			case (6):
				this.disengageEnemyAircraft();
				break;
			case (7):
				this.barrelRoll();
				break;
			case (8):
				this.highGTurn();
				break;
			case (9):
				this.engageAfterburners();
				break;
			case (10):
				this.disengageAfterburners();
				break;
			case (11):
				this.engageSuperCruise();
				break;
			case (12):
				this.disengageSuperCruise();
				break;
			case (13):
				this.connectToBoom();
				break;
			case (14):
				this.refuelInFlight();
				break;
			case (15):
				if (this.isFlying()) {
					selection = 0;
					System.out.println(" You need to land first!");
					continue;
				}
				break;

			}
		} while (selection != 15);

	}

}
