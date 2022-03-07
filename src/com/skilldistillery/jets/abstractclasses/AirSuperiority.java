package com.skilldistillery.jets.abstractclasses;

import java.util.Scanner;

import com.skilldistillery.jets.aircraft.FighterJet;
import com.skilldistillery.jets.interfaces.AirToGround;
import com.skilldistillery.jets.interfaces.Stealth;
import com.skilldistillery.jets.interfaces.SuperCruiser;

public abstract class AirSuperiority extends FighterJet implements AirToGround, Stealth, SuperCruiser {

	private boolean lockedOnGround;
	private boolean jammingRadar;
	private boolean inStealthMode;
	private boolean superCruiseEngaged;
	
	public AirSuperiority() {
		super();
		this.lockedOnGround = false;
		this.jammingRadar = false;
		this.inStealthMode = false;
		this.superCruiseEngaged = false;
	}

	@Override
	public void lockOnToGroundTarget() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (lockedOnGround) {
			System.out.println(" You are already locked on to the ground target!");
		} else {
			System.out.println(" Locking on.........ground target locked!");
			lockedOnGround = true;
		}

	}

	@Override
	public void dropPayload() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (lockedOnGround) {
			System.out.println(" Bombs away.............target destroyed!");
			lockedOnGround = false;
		} else {
			System.out.println(" You aren't locked on to a ground target.....");
		}

	}

	@Override
	public void engageRadarJamming() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (jammingRadar) {
			System.out.println(" You're already jamming enemy radar!");
		} else {
			System.out.println(" Radar jamming is engaged. Cleared to penetrate enemy airspace.");
			jammingRadar = true;
		}
	}

	@Override
	public void disengageRadarJamming() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (jammingRadar) {
			System.out.println(" Radar Jamming disengaged. Remain clear of hostile airspace.");
			jammingRadar = false;
		} else {
			System.out.println(" Radar jamming is not engaged.....");
		}

	}

	@Override
	public void engageStealthMode() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (inStealthMode) {
			System.out.println(" Stealth mode is already engaged!");
		} else {
			System.out.println(" Stealth mode engaged. Radar cross-section reduced. Cleared to engage enemy aircraft.");
			inStealthMode = true;
		}
	}

	@Override
	public void disengageStealthMode() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (inStealthMode) {
			System.out.println(" Stealth mode disengaged. Radar cross-section normal. Engaging enemy aircraft not advised.");
			inStealthMode = false;
		} else {
			System.out.println(" Stealth mode isn't engaged.....");
		}

	}

	@Override
	public void engageSuperCruise() {
		
		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		
		if (this.isAfterburnersEngaged()) {
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
		
		if (this.isAfterburnersEngaged() && superCruiseEngaged) {
			System.out.println(" Disengaging supercruise. Fuel burn increasing...");
			superCruiseEngaged = false;
		} else if (this.isAfterburnersEngaged() && !superCruiseEngaged) {
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
			System.out.print("\u250c"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2510");
			System.out.println("\u2502                 \u2508\u2509 Action Menu \u2509\u2508                  \u2502");
			System.out.print("\u251c"); for (int i = 0; i < 52; i++) System.out.print("\u2500");System.out.print("\u2524");
			System.out.println();
			System.out.println("\u2502 1)  Takeoff                                        \u2502");
			System.out.println("\u2502 2)  Land                                           \u2502");
			System.out.println("\u2502 3)  Lock on to ground target                       \u2502");
			System.out.println("\u2502 4)  Drop the payload                               \u2502");
			System.out.println("\u2502 5)  Engage enemy aircraft                          \u2502");
			System.out.println("\u2502 6)  Lock on to enemy aircraft                      \u2502");
			System.out.println("\u2502 7)  Fire Air-to-Air missles                        \u2502");
			System.out.println("\u2502 8)  Disengage enemy aircraft                       \u2502");
			System.out.println("\u2502 9)  Barrel roll                                    \u2502");
			System.out.println("\u2502 10) High-G turn                                    \u2502");
			System.out.println("\u2502 11) Engage Afterburners                            \u2502");
			System.out.println("\u2502 12) Disengage afterburners                         \u2502");
			System.out.println("\u2502 13) Engage supercruise                             \u2502");
			System.out.println("\u2502 14) Disengage supercruise                          \u2502");
			System.out.println("\u2502 15) Jam enemy radar                                \u2502");
			System.out.println("\u2502 16) Stop jamming enemy radar                       \u2502");
			System.out.println("\u2502 17) Engage stealth mode                            \u2502");
			System.out.println("\u2502 18) Disengage stealth mode                         \u2502");
			System.out.println("\u2502 19) Connect to fuel boom                           \u2502");
			System.out.println("\u2502 20) Refuel in flight                               \u2502");
			System.out.println("\u2502 21) Return to main menu                            \u2502");
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
				this.lockOnToGroundTarget();
			break;
			case (4):
				this.dropPayload();
			break;
			case (5):
				this.engageEnemyAircraft();
				break;
			case (6):
				this.lockOnToEnemyAircraft();
				break;
			case (7):
				this.launchAirToAirMissles();
			break;
			case (8):
				this.disengageEnemyAircraft();
			break;
			case (9):
				this.barrelRoll();
			break;
			case (10):
				this.highGTurn();
			break;
			case (11):
				this.engageAfterburners();
			break;
			case (12):
				this.disengageAfterburners();
			break;
			case (13):
				this.engageSuperCruise();
			break;
			case (14):
				this.disengageSuperCruise();
			break;
			case (15):
				this.engageRadarJamming();
			break;
			case (16):
				this.disengageRadarJamming();
			break;
			case (17):
				this.engageStealthMode();
			break;
			case (18):
				this.disengageStealthMode();
			break;
			case (19):
				this.connectToBoom();
			break;
			case (20):
				this.refuelInFlight();
			break;
			case (21):
				if (this.isFlying()) {
					selection = 0;
					System.out.println(" You need to land first!");
					continue;
				}
				break;

			}
		} while (selection != 21);

	}


}
