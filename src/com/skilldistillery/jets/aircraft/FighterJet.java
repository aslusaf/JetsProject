package com.skilldistillery.jets.aircraft;

import java.util.Scanner;

import com.skilldistillery.jets.abstractclasses.Jet;
import com.skilldistillery.jets.interfaces.AirToAir;
import com.skilldistillery.jets.interfaces.InAirRefuelable;
import com.skilldistillery.jets.interfaces.Supersonic;

public class FighterJet extends Jet implements AirToAir, Supersonic, InAirRefuelable {

	private boolean engagingEnemyAircraft;
	private boolean lockedOnAir;
	private boolean afterburnersEngaged;
	private boolean connectedToBoom;
	private boolean refueled;

	public FighterJet(String model, double speed, int range, double price) {
		this.setType("Fighter Jet");
		this.setModel(model);
		this.setSpeed(speed);
		this.setRange(range);
		this.setPrice(price);
		this.engagingEnemyAircraft = false;
		this.lockedOnAir = false;
		this.afterburnersEngaged = false;
		this.connectedToBoom = false;
		this.refueled = false;
	}

	public FighterJet() {
		super();
		this.setType("Fighter Jet");
		this.engagingEnemyAircraft = false;
		this.lockedOnAir = false;
		this.afterburnersEngaged = false;
		this.connectedToBoom = false;
		this.refueled = false;
	}

	@Override
	public void engageEnemyAircraft() {

		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (engagingEnemyAircraft) {
			System.out.println(" You are already engaged!");
		} else {
			System.out.println(" Engaging enemy aircraft!");
			engagingEnemyAircraft = true;
		}
	}

	@Override
	public void disengageEnemyAircraft() {

		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		if (engagingEnemyAircraft) {
			System.out.println(" Disengaging!");
			engagingEnemyAircraft = false;
		} else {
			System.out.println(" You aren't in an engagement.....");
		}
	}

	@Override
	public void barrelRoll() {

		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		System.out.println(" Rollllllllllling..............whoah!");
	}

	@Override
	public void highGTurn() {

		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		System.out.println(" Hold.....on.....tight..............");
		System.out.println(" Whew! That was fun.");
	}

	@Override
	public void lockOnToEnemyAircraft() {

		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (lockedOnAir) {
			System.out.println(" You are already locked on to the enemy aircraft!");
		} else {
			if (engagingEnemyAircraft) {
				System.out.println(" Locking on....................target locked!");
				lockedOnAir = true;
			} else {
				System.out.println(" You aren't in an engagement.....");
			}
		}
	}

	@Override
	public void launchAirToAirMissles() {

		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		if (lockedOnAir) {
			System.out.println(" Weapons hot. Firing................target eliminated");
			lockedOnAir = false;
			engagingEnemyAircraft = false;
		} else {
			System.out.println(" You aren't locked on to any targets.....");
		}
	}

	@Override
	public void engageAfterburners() {

		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		if (afterburnersEngaged) {
			System.out.println(" Afterburners are already engaged.....");
		} else {
			System.out.println(" Engaging afterburners. Here comes the boom!");
			afterburnersEngaged = true;
		}
	}

	@Override
	public void disengageAfterburners() {

		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}

		if (afterburnersEngaged) {
			System.out.println(" Disengaging afterburners. Subsonic flight resumed.");
			afterburnersEngaged = false;
		} else {
			System.out.println(" The afterburners aren't engaged.....");
		}

	}

	@Override
	public void connectToBoom() {

		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		
		if (connectedToBoom) {
			System.out.println(" You are already connected to the boom!");
		} else {
			System.out.println(" Locks engaging.............connection complete!");
			System.out.println(" Cleared to begin refuleing.");
			connectedToBoom = true;
		}

	}

	@Override
	public void refuelInFlight() {

		if (!this.isFlying()) {
			System.out.println(" You're still on the ground.....");
			return;
		}
		
		if (refueled) {
			System.out.println(" Your tanks are already full buddy......");
		} else {
			if (connectedToBoom) {
				System.out.println(" Dispensing fuel. Fuel pressure is in the green.");
				System.out.println(" Fueling complete!\n");
				System.out.println(" Disengaging locks.....");
				System.out.println(" Locks are disengaged. Boom is clear. Happy hunting!");
				connectedToBoom = false;
				refueled = true;
			} else {
				System.out.println(" You need to connect to the boom first.....");
			}
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
			System.out.println("\u2502 11) Connect to fuel boom                           \u2502");
			System.out.println("\u2502 12) Refuel in flight                               \u2502");
			System.out.println("\u2502 13) Return to main menu                            \u2502");
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
				this.connectToBoom();
				break;
			case (12):
				this.refuelInFlight();
				break;
			case (13):
				if (this.isFlying()) {
					selection = 0;
					System.out.println(" You need to land first!");
					continue;
				}
				break;

			}
		} while (selection != 13);

	}

	public boolean isAfterburnersEngaged() {
		return afterburnersEngaged;
	}

}
