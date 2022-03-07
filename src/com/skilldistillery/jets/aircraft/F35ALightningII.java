package com.skilldistillery.jets.aircraft;

import com.skilldistillery.jets.interfaces.Stealth;

public class F35ALightningII extends FighterJet implements Stealth {
	
	private boolean jammingRadar;
	private boolean inStealthMode;
	
	public F35ALightningII() {

		this.setModel("F-35A Lightning II");
		this.setSpeed(1200);
		this.setRange(1350);
		this.setPrice(117300000);
		this.jammingRadar = false;
		this.inStealthMode = false;
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
			System.out.println(
					" Stealth mode disengaged. Radar cross-section normal. Engaging enemy aircraft not advised.");
			inStealthMode = false;
		} else {
			System.out.println(" Stealth mode isn't engaged.....");
		}
		
	}

}
