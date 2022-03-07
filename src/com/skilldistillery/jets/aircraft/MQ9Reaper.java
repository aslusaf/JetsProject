package com.skilldistillery.jets.aircraft;

import java.util.Scanner;

import com.skilldistillery.jets.interfaces.AirToGround;

public class MQ9Reaper extends RPA implements AirToGround {

	private boolean lockedOn;

	public MQ9Reaper() {
		super();
		this.setModel("MQ-9 Reaper");
		this.setSpeed(300);
		this.setRange(1150);
		this.setPrice(32000000);
		this.lockedOn = false;
	}

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
			System.out.println(" Weapons hot. Firing..............ground target eliminated");
			lockedOn = false;
		} else {
			System.out.println(" You aren't locked on to any targets.....");
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
			System.out.println("\u2502 5) Lock on to targets                              \u2502");
			System.out.println("\u2502 6) Drop the payload                                \u2502");
			System.out.println("\u2502 7) Return to main menu                             \u2502");
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
				this.lockOnToGroundTarget();
			break;
			case (6):
				this.dropPayload();
			break;
			case (7):
				if (this.isFlying()) {
					selection = 0;
					System.out.println(" You need to land first!");
					continue;
				}
				break;

			}
		} while (selection != 7);

	}

}
