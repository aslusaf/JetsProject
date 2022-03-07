package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.Scanner;
import com.skilldistillery.jets.abstractclasses.Jet;

public class JetsApplication { 
	
	public static void main(String[] args) {

		AirField airField = new AirField();
		Scanner kb = new Scanner(System.in);
		JetsApplication jetsApp = new JetsApplication();

		ArrayList<Jet> jetsOnAirfield = airField.getJetsFromFile();
		airField.addOneOfEachAircraft(jetsOnAirfield);
		jetsApp.displayUserMenu(kb, jetsOnAirfield);
		kb.close();
	}

	private void displayUserMenu(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		int choice;

		do {
			System.out.print("\u250c"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2510");
			System.out.println("\u2502 Air Force Reserve Command Fleet Management Console \u2502");
			System.out.print("\u251c"); for (int i = 0; i < 52; i++) System.out.print("\u2500");System.out.print("\u2524");
			System.out.println();
			System.out.println("\u2502 1) List fleet                                      \u2502");
			System.out.println("\u2502 2) Fly all jets                                    \u2502");
			System.out.println("\u2502 3) View the fastest jet                            \u2502");
			System.out.println("\u2502 4) View jet with longest range                     \u2502");
			System.out.println("\u2502 5) Load all Cargo Jets                             \u2502");
			System.out.println("\u2502 6) Fly a jet                                       \u2502");
			System.out.println("\u2502 7) Add a jet to Fleet                              \u2502");
			System.out.println("\u2502 8) Remove a jet from fleet                         \u2502");
			System.out.println("\u2502 9) Quit                                            \u2502");
			System.out.print("\u2514"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2518");
			System.out.print(" \u21f6 ");
			choice = kb.nextInt();
			kb.nextLine();
			System.out.println();

			AirField af = new AirField();
			
			switch (choice) {
			case (1):
				af.listFleet(jetsOnAirfield);
				break;
			case (2):
				displayClearanceForTakeOff();
				int index = 1;
				for (Jet jet : jetsOnAirfield) {
					jet.fly(index);
					index++;
				}
				break;
			case (3):
				af.displayFastestJet(jetsOnAirfield);
				break;
			case (4):
				af.displayJetWithLongestRange(jetsOnAirfield);
				break;
			case (5):
				af.loadAllCargoJets(jetsOnAirfield);
				break;
			case (6):
				af.flyAJet(kb, jetsOnAirfield);
				break;
			case (7):
				af.addJetToFleet(kb, jetsOnAirfield);
				break;
			case (8):
				af.removeJetFromFleet(kb, jetsOnAirfield);
				break;

			}
			
		} while (choice != 9);
		
		System.out.println(" - \"Farewell! Blue skies and tail winds!\"");

	}
	
	public void displayClearanceForTakeOff() {
		System.out.print("\u250c"); for (int i = 0; i < 100; i++) System.out.print("\u2500"); System.out.println("\u2510");
		System.out.println("\u2502              \u2508\u2509 ATC: \"Cleared for takeoff, Runway 7L. Unrestricted climb approved!\" \u2509\u2508             \u2502");
		System.out.print("\u2514"); for (int i = 0; i < 100; i++) System.out.print("\u2500"); System.out.println("\u2518");
		System.out.println();
	}

}
