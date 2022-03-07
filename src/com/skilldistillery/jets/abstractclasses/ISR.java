package com.skilldistillery.jets.abstractclasses;

import java.util.Scanner;

import com.skilldistillery.jets.interfaces.Surveillance;

public abstract class ISR extends Jet implements Surveillance {

	private boolean liveFeedEngaged;

	public ISR() {
		this.liveFeedEngaged = false;
	}

	@Override
	public void engageLiveSatelliteFeed() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		if (liveFeedEngaged) {
			System.out.println(" The live feed is already engaged...");
		} else {
			System.out.println(" Establishing live feed.....");
			System.out.println(" Connection established. High resolution and infrared feeds online.");
			liveFeedEngaged = false;
		}
	}

	@Override
	public void disengageLiveSatelliteFeed() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (liveFeedEngaged) {
			System.out.println(" Disengaging.....");
			System.out.println(" Connection terminated.");
			liveFeedEngaged = false;
		} else {
			System.out.println(" There is no live feed established...");
		}

	}
	
	@Override
	public void subMenu(Scanner kb) {
		
		int selection = 0;

		System.out.println(" You are flying the " + this.getModel() + ".");

		do {
			
			System.out.println();
			System.out.print("\u250c"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2510");
			System.out.println("\u2502                 \u2508\u2509 Action Menu \u2509\u2508                  \u2502");
			System.out.print("\u251c"); for (int i = 0; i < 52; i++) System.out.print("\u2500");System.out.print("\u2524");
			System.out.println();
			System.out.println("\u2502 1) Takeoff                                         \u2502");
			System.out.println("\u2502 2) Land                                            \u2502");
			System.out.println("\u2502 3) Activate live satellite feed                    \u2502");
			System.out.println("\u2502 4) Deactivate live satellite feed                  \u2502");
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
				this.engageLiveSatelliteFeed();
				break;
			case (4):
				this.disengageLiveSatelliteFeed();
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
