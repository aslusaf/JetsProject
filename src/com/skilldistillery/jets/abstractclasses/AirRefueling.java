package com.skilldistillery.jets.abstractclasses;

import java.util.Scanner;

import com.skilldistillery.jets.interfaces.InAirRefueler;

public abstract class AirRefueling extends Jet implements InAirRefueler {

	private boolean boomExtended = false;
	private boolean fueling = false;
	private boolean boomConnected = false;

	@Override
	public void extendBoom() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (boomExtended) {
			System.out.println(" Unable. The boom is already extended!");
		} else {
			System.out.println(" Extending boom.....");
			System.out.println(" Extension complete.");
			boomExtended = true;
		}
	}

	@Override
	public void connectBoom() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (boomExtended) {
			if (boomConnected) {
				System.out.println(" Unable. The boom is already connected!");
			} else {
				System.out.println(" Connecting boom.....");
				System.out.println(" Connection complete.");
				boomConnected = true;
			}
		} else {
			System.out.println(" Unable. The boom must first be extended!");
		}

	}

	@Override
	public void beginFueling() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (fueling) {
			System.out.println(" Unable. You are already fueling an aircraft!");
		} else {
			if (boomExtended) {
				if (boomConnected) {
					System.out.println(" Fueling aircraft.....");
					fueling = true;
				} else {
					System.out.println(" Unable. The boom still needs to be connected!");
				}
			} else {
				System.out.println(" Unable. The boom must first be extended and connected!");
			}
		}

	}

	@Override
	public void stopFueling() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		
		if (fueling) {
			System.out.println(" Fueling complete!");
			fueling = false;
		} else {
			System.out.println(" You aren't currently fueling an aircraft.....");
		}
	}

	@Override
	public void disconnectBoom() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		
		if (boomConnected) {
			System.out.println(" Disconnecting boom.........boom disconnected.");
			boomConnected = false;
		} else {
			System.out.println("You aren't currently connected to an aircraft.....");
		}
	}

	@Override
	public void retractBoom() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		
		if (boomExtended) {
			System.out.println(" Retracting boom..........boom retracted.");
			boomExtended = false;
		} else {
			System.out.println(" The boom isn't currently extended.....");
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
			System.out.println("\u2502 3) Extend the boom                                 \u2502");
			System.out.println("\u2502 4) Connect the boom                                \u2502");
			System.out.println("\u2502 5) Begin fueling                                   \u2502");
			System.out.println("\u2502 6) Stop fueling                                    \u2502");
			System.out.println("\u2502 7) Disconnect the boom                             \u2502");
			System.out.println("\u2502 8) Retract the boom                                \u2502");
			System.out.println("\u2502 9) Return to main menu                             \u2502");
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
				this.extendBoom();
				break;
			case (4):
				this.connectBoom();
				break;
			case (5):
				this.beginFueling();
				break;
			case (6):
				this.stopFueling();
				break;
			case (7):
				this.disconnectBoom();
				break;
			case (8):
				this.retractBoom();
				break;
			case (9):
				if (this.isFlying()) {
					selection = 0;
					System.out.println(" You need to land first!");
					continue;
				}
				break;

			}
		} while (selection != 9);

	}


}
