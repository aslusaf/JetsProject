package com.skilldistillery.jets.abstractclasses;

import java.util.Scanner;

import com.skilldistillery.jets.interfaces.AirToGround;

public abstract class GlobalPrecisionAttack extends Jet implements AirToGround {
	
	private boolean lockedOn = false;

	@Override
	public void lockOnToGroundTarget() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (lockedOn) {
			System.out.println(" You are already locked on to the target!");
		} else {
			System.out.println(" Locking on.........ground target locked!");
			lockedOn = true;
		}

	}

	@Override
	public void dropPayload() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (lockedOn) {
			System.out.println(" Bombs away.............target destroyed!");
			lockedOn = false;
		} else {
			System.out.println(" You aren't locked on to a target.....");
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
			System.out.println("\u2502 3) Lock on to targets                              \u2502");
			System.out.println("\u2502 4) Drop the payload                                \u2502");
			System.out.println("\u2502 5) Return to main menu                             \u2502");
			System.out.print("\u2514"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2518");
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
				this.lockOnToGroundTarget();
				break;
			case (4):
				this.dropPayload();
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
