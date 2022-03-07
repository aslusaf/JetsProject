package com.skilldistillery.jets.abstractclasses;

import java.util.Objects;
import java.util.Scanner;

import com.skilldistillery.jets.app.JetsApplication;

public abstract class Jet {
	
	private String type;
	private String model;
	private double speed;
	private int range;
	private double price;
	private boolean flying;
	
	public Jet() {}
	
	public Jet(String type, String model, double speed, int range, double price) {
		this.type = type;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.flying = false;
	}
	
	public boolean isFlying() {
		return flying;
	}

	public void setFlying(boolean flying) {
		this.flying = flying;
	}

	@Override
	public String toString() {
		return "Type: " + getType() + " | Model: " + getModel() + " | Speed: " + getSpeed()
				+ " | Range: " + getRange() + " | Price: " + getPrice();
	}
	
	public void fly() {
		JetsApplication jetApp = new JetsApplication();
		
		jetApp.displayClearanceForTakeOff();
		System.out.println("\n TOGA..............V1.........Rotate.......clear of obstacles.");
		System.out.println(" We're off!");
		this.setFlying(true);
	}

	public void fly(int index) {
		System.out.printf(" %s %s | %s | %s | %s | $%,.2f", index + ".", this.getType(), this.getModel(), Math.round(getSpeed()) + " mph", this.getRange() + " nm", this.getPrice());
		System.out.printf("\n    This " + getModel() + " can continue flying for %.2f more hours at max speed.\n\n", (getRange() / getSpeed()));
		this.setFlying(true);
	}
	
	public void land() {
		if (this.isFlying()) {
			System.out.println(" On speed, on glidepath.");
			System.out.println(" 200, stabilized, continuing.");
			System.out.println(" 100.....50.....20.....touchdown!");
			this.setFlying(false);
		} else {
			System.out.println(" We're already on the ground.....");
		}
	}
	
	public void displayInfo(int counter) {
		
		System.out.printf(" %2d%s %-21s | %-22s | %-11s | %-11s | $%,.2f", counter, ")", this.getType(), this.getModel(), Math.round(getSpeed()) + " mph", this.getRange() + " nm", this.getPrice());
		System.out.println();
	}
	
	public void subMenu(Scanner kb) {
		
		int selection = 0;

		System.out.println(" You are in a " + this.getModel() + ".");

		do {
			
			System.out.println();
			System.out.print("\u250c"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2510");
			System.out.println("\u2502                 \u2508\u2509 Action Menu \u2509\u2508                  \u2502");
			System.out.print("\u251c"); for (int i = 0; i < 52; i++) System.out.print("\u2500");System.out.print("\u2524");
			System.out.println();
			System.out.println("\u2502 1) Takeoff                                         \u2502");
			System.out.println("\u2502 2) Land                                            \u2502");
			System.out.println("\u2502 3) Return to main menu                             \u2502");
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
				if (this.isFlying()) {
					selection = 0;
					System.out.println(" You need to land first!");
					continue;
				}
				break;

			}
		} while (selection != 3);

	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed)
				&& Objects.equals(type, other.type);
	}
	
}
