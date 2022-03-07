package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.jets.abstractclasses.Jet;
import com.skilldistillery.jets.aircraft.B1BLancer;
import com.skilldistillery.jets.aircraft.B52HStratofortress;
import com.skilldistillery.jets.aircraft.Bomber;
import com.skilldistillery.jets.aircraft.C130Hercules;
import com.skilldistillery.jets.aircraft.C17AGlobemaster;
import com.skilldistillery.jets.aircraft.C40C;
import com.skilldistillery.jets.aircraft.C5MGalaxy;
import com.skilldistillery.jets.aircraft.CargoJet;
import com.skilldistillery.jets.aircraft.CustomJet;
import com.skilldistillery.jets.aircraft.F15EStrikeEagle;
import com.skilldistillery.jets.aircraft.F16CFightingFalcon;
import com.skilldistillery.jets.aircraft.F22Raptor;
import com.skilldistillery.jets.aircraft.F35ALightningII;
import com.skilldistillery.jets.aircraft.FighterJet;
import com.skilldistillery.jets.aircraft.K46APegasus;
import com.skilldistillery.jets.aircraft.KC10AExtender;
import com.skilldistillery.jets.aircraft.KC135RStratotanker;
import com.skilldistillery.jets.aircraft.MQ9Reaper;
import com.skilldistillery.jets.aircraft.RPA;
import com.skilldistillery.jets.aircraft.RQ4GlobalHawk;
import com.skilldistillery.jets.aircraft.Tanker;
import com.skilldistillery.jets.interfaces.CargoCarrier;

public class AirField {
	
	private ArrayList<Jet> jetList = new ArrayList<>();

	public AirField() {
	}

	public ArrayList<Jet> getJetsFromFile() {

		try (BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {

				String[] newJetArr = line.split(",");
				String type = newJetArr[0];
				String model = newJetArr[1];
				double speed = Double.parseDouble(newJetArr[2]);
				int range = Integer.parseInt(newJetArr[3]);
				double price = Double.parseDouble(newJetArr[4]);

				Jet newJet = new CustomJet(type, model, speed, range, price);

				jetList.add(newJet);

			}
		} catch (IOException e) {
			System.err.println(e);
		}

		return jetList;

	}
	
	public void addOneOfEachAircraft(ArrayList<Jet> jetsOnAirfield) {
		
		Jet jet;
		//Fighter
		jet = new F22Raptor();
		jetsOnAirfield.add(jet);
		jet = new F15EStrikeEagle();
		jetsOnAirfield.add(jet);
		jet = new F16CFightingFalcon();
		jetsOnAirfield.add(jet);
		jet = new F35ALightningII();
		jetsOnAirfield.add(jet);
		//Bomber
		jet = new B1BLancer();
		jetsOnAirfield.add(jet);
		jet = new B52HStratofortress();
		jetsOnAirfield.add(jet);
		//Tanker
		jet = new KC10AExtender();
		jetsOnAirfield.add(jet);
		jet = new K46APegasus();
		jetsOnAirfield.add(jet);
		jet = new KC135RStratotanker();
		jetsOnAirfield.add(jet);
		//Cargo
		jet = new C5MGalaxy();
		jetsOnAirfield.add(jet);
		jet = new C40C();
		jetsOnAirfield.add(jet);
		jet = new C17AGlobemaster();
		jetsOnAirfield.add(jet);
		jet = new C130Hercules();
		jetsOnAirfield.add(jet);
		//RPA
		jet = new MQ9Reaper();
		jetsOnAirfield.add(jet);
		jet = new RQ4GlobalHawk();
		jetsOnAirfield.add(jet);
		
	}
	
	
	public void listFleet(ArrayList<Jet> jetsOnAirfield) {

		if (jetsOnAirfield.isEmpty()) {
			System.out.println(" There are no aircraft on the airfield!");
			return;
		}
		
		fleetListBanner();
		infoBanner();

		int counter = 1;

		for (Jet jet : jetsOnAirfield) {			
			jet.displayInfo(counter);
			counter++;
		}
		breakBar();

	}
	
	public void infoBanner() {
		
		System.out.print("\u251c"); for (int i = 0; i < 100; i++) System.out.print("\u2500"); System.out.println("\u2524");
		System.out.printf("\u2502       Aircraft Type      \u2502     Aircraft Model     \u2502  Top Speed  \u2502  Max Range  \u2502   Price per Unit   \u2502\n");
		System.out.print("\u2514"); for (int i = 0; i < 100; i++) System.out.print("\u2500"); System.out.println("\u2518");
		
	}
	
	public void fleetListBanner() {
		
		System.out.print("\u250c"); for (int i = 0; i < 100; i++) System.out.print("\u2500"); System.out.println("\u2510");
		System.out.println("\u2502                                        \u2508\u2509 Fleet List \u2509\u2508                                            \u2502");
		
	}
	
	public void selectAircraftBanner() {
		
		System.out.print("\u250c"); for (int i = 0; i < 100; i++) System.out.print("\u2500"); System.out.println("\u2510");
		System.out.println("\u2502                                     \u2508\u2509 Select Aircraft \u2509\u2508                                          \u2502");
		
	}
	
	public void breakBar() {
		
		System.out.print(" "); for (int i = 0; i < 100; i++) System.out.print("\u2500");
		System.out.println("\n");
		
	}

	public void displayFastestJet(ArrayList<Jet> jetsOnAirfield) {
		
		if (jetsOnAirfield.isEmpty()) {
			System.out.println(" There are no aircraft on the airfield!");
			return;
		}

		int index = 0;
		double fastestSpeed = jetsOnAirfield.get(0).getSpeed();
		for (int i = 1; i < jetsOnAirfield.size(); i++) {
			
			System.out.println("Fastest Speed: " + fastestSpeed);
			System.out.println("Current Speed: " + jetsOnAirfield.get(i).getSpeed());
			System.out.println(jetsOnAirfield.get(i).getSpeed() >= fastestSpeed);
			if (jetsOnAirfield.get(i).getSpeed() >= fastestSpeed) {
				fastestSpeed = jetsOnAirfield.get(i).getSpeed();
				index = i;
			}
		}
		fastestJetBanner();
		infoBanner();
		jetsOnAirfield.get(index).displayInfo(index + 1);
		breakBar();
	}
	
	public void fastestJetBanner() {
		
		System.out.print("\u250c"); for (int i = 0; i < 100; i++) System.out.print("\u2500"); System.out.println("\u2510");
		System.out.println("\u2502                                       \u2508\u2509 Fastest Jet \u2509\u2508                                            \u2502");
		
	}

	public void displayJetWithLongestRange(ArrayList<Jet> jetsOnAirfield) {
		
		if (jetsOnAirfield.isEmpty()) {
			System.out.println(" There are no aircraft on the airfield!");
			return;
		}

		int index = 0;
		double longestRange = jetsOnAirfield.get(0).getRange();
		for (int i = 1; i < jetsOnAirfield.size(); i++) {

			if (jetsOnAirfield.get(i).getRange() > longestRange) {
				longestRange = jetsOnAirfield.get(i).getRange();
				index = i;
			}
		}
		longestRangeBanner();
		infoBanner();
		jetsOnAirfield.get(index).displayInfo(index + 1);
		breakBar();
	}
	
	public void longestRangeBanner() {
		
		System.out.print("\u250c"); for (int i = 0; i < 100; i++) System.out.print("\u2500"); System.out.println("\u2510");
		System.out.println("\u2502                                      \u2508\u2509 Longest Range \u2509\u2508                                           \u2502");
		
	}

	public void addJetToFleet(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		Jet newAircraft;
		boolean success = false;

		newAircraft = aircraftChoiceMenu(kb, jetsOnAirfield);

		if (newAircraft != null) {
			success = jetsOnAirfield.add(newAircraft);
		}

		if (success) {
			int newAircraftIndex = jetsOnAirfield.size() - 1;
			System.out.println(" The " + jetsOnAirfield.get(newAircraftIndex).getModel()
					+ " was successfully added to the fleet!\n");
		} 
		else {
			System.out.println();
		}

	}

	public void removeJetFromFleet(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		if (jetsOnAirfield.isEmpty()) {
			System.out.println(" There are no aircraft left to remove!\n");
			return;
		}
		
		removeAircraftBanner();
		infoBanner();

		int counter = 1;

		for (Jet jet : jetsOnAirfield) {			
			jet.displayInfo(counter);
			counter++;
		}
		breakBar();
		System.out.print(" \u21f6 ");
		int index = kb.nextInt();
		kb.nextLine();
		System.out.println();

		Jet removed = jetsOnAirfield.remove(index - 1);

		System.out.println(" The " + removed.getModel() + " was successfully removed.\n");

	}
	
	public void removeAircraftBanner() {
		
		System.out.print("\u250c"); for (int i = 0; i < 100; i++) System.out.print("\u2500"); System.out.println("\u2510");
		System.out.println("\u2502                                     \u2508\u2509 Remove Aircraft \u2509\u2508                                          \u2502");
		
	}

	public void loadAllCargoJets(ArrayList<Jet> jetsOnAirfield) {

		int counter = 1;
		boolean cargoJetFound = false;

		for (Jet jet : jetsOnAirfield) {

			if (jet instanceof CargoCarrier) {

				System.out.print(" " + counter + ". " + jet.getModel() + ":\n\n");
				((CargoCarrier) jet).loadCargo();
				System.out.println();
				cargoJetFound = true;
			}
			counter++;

		}
		if (!cargoJetFound) {
			System.out.println(" There are no cargo jets in the fleet to load.\n");
			// TODO unicode frame
		}

	}

	public void flyAJet(Scanner kb, ArrayList<Jet> jetsOnAirfield) {
		
		if (jetsOnAirfield.isEmpty()) {
			System.out.println(" There are no aircraft on the airfield!");
			return;
		}
		
		selectAircraftBanner();
		infoBanner();

		int counter = 1;

		for (Jet jet : jetsOnAirfield) {			
			jet.displayInfo(counter);
			counter++;
		}
		breakBar();
		System.out.print(" \u21f6 ");
		int index = kb.nextInt();
		kb.nextLine();
		System.out.println();
		Jet jetToFly = jetsOnAirfield.get(index - 1);
		jetToFly.subMenu(kb);

	}

	public Jet addCustomJetToFleet(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		System.out.print(" Enter the aircraft's type: ");
		String type = kb.next();
		kb.nextLine();
		System.out.print(" Enter the aircraft's model: ");
		String model = kb.next();
		kb.nextLine();
		System.out.print(" Enter the aircraft's top speed: ");
		double speed = kb.nextDouble();
		kb.nextLine();
		System.out.print(" Enter the aircraft's max range: ");
		int range = kb.nextInt();
		kb.nextLine();
		System.out.print(" Enter the aircraft's price: ");
		double price = kb.nextDouble();
		kb.nextLine();
		System.out.println();

		Jet customJet = new CustomJet(type, model, speed, range, price);

		return customJet;
	}

	public Jet aircraftChoiceMenu(Scanner kb, ArrayList<Jet> jetsOnAirfield) {
		// TODO unicode menu

		Jet newAircraft = null;
		
		System.out.print("\u250c"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2510");
		System.out.println("\u2502               \u2508\u2509 Add Aircraft Menu \u2509\u2508              \u2502");
		System.out.print("\u251c"); for (int i = 0; i < 52; i++) System.out.print("\u2500");System.out.print("\u2524");
		System.out.println();
		System.out.println("\u2502 1) Custom Civilian Aircraft                        \u2502");
		System.out.println("\u2502 2) Fighter                                         \u2502");
		System.out.println("\u2502 3) Bomber                                          \u2502");
		System.out.println("\u2502 4) Tanker                                          \u2502");
		System.out.println("\u2502 5) Cargo                                           \u2502");
		System.out.println("\u2502 6) Remotely Piloted Aircraft (RPA)                 \u2502");
		System.out.println("\u2502 7) Return to main menu                             \u2502");
		System.out.print("\u2514"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2518");
		System.out.print(" \u21f6 ");
		int aircraftChoice = kb.nextInt();
		kb.nextLine();

		switch (aircraftChoice) {
		case (1):
			newAircraft = addCustomJetToFleet(kb, jetsOnAirfield);
			break;
		case (2):
			newAircraft = fighterMenu(kb, jetsOnAirfield);
			break;
		case (3):
			newAircraft = bomberMenu(kb, jetsOnAirfield);
			break;
		case (4):
			newAircraft = tankerMenu(kb, jetsOnAirfield);
			break;
		case (5):
			newAircraft = cargoJetMenu(kb, jetsOnAirfield);
			break;
		case (6):
			newAircraft = rpaMenu(kb, jetsOnAirfield);
			break;
		case (7):
			break;
		}

		return newAircraft;
	}
	
	public void addAircraftMenuBanner() {
		
		System.out.println();
		System.out.print("\u250c"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2510");
		System.out.println("\u2502               \u2508\u2509 Add Aircraft Menu \u2509\u2508              \u2502");
		System.out.print("\u251c"); for (int i = 0; i < 52; i++) System.out.print("\u2500");System.out.print("\u2524");
		System.out.println();
		
	}

	public Jet fighterMenu(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		Jet newAircraft = null;
		addAircraftMenuBanner();
		System.out.println("\u2502 1) Custom Fighter Jet                              \u2502");
		System.out.println("\u2502 2) F-22 Raptor                                     \u2502");
		System.out.println("\u2502 3) F-15E Strike Eagle                              \u2502");
		System.out.println("\u2502 4) F-16C Fighting Falcon                           \u2502");
		System.out.println("\u2502 5) F-35A Lightning II                              \u2502");
		System.out.println("\u2502 6) Return to main menu                             \u2502");
		System.out.print("\u2514"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2518");
		System.out.print(" \u21f6 ");
		int aircraftChoice = kb.nextInt();
		kb.nextLine();
		System.out.println();

		switch (aircraftChoice) {
		case (1):
			newAircraft = customFighterJet(kb, jetsOnAirfield);
			break;
		case (2):
			newAircraft = new F22Raptor();
			break;
		case (3):
			newAircraft = new F15EStrikeEagle();
			break;
		case (4):
			newAircraft = new F16CFightingFalcon();
			break;
		case (5):
			newAircraft = new F35ALightningII();
			break;
		case (6):
			break;
		}
		return newAircraft;
	}

	public Jet customFighterJet(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		System.out.print(" Enter the aircraft's model: ");
		String model = kb.next();
		kb.nextLine();
		System.out.print(" Enter the aircraft's top speed: ");
		double speed = kb.nextDouble();
		kb.nextLine();
		System.out.print(" Enter the aircraft's max range: ");
		int range = kb.nextInt();
		kb.nextLine();
		System.out.print(" Enter the aircraft's price: ");
		double price = kb.nextDouble();
		kb.nextLine();
		System.out.println();

		return new FighterJet(model, speed, range, price);

	}

	public Jet bomberMenu(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		Jet newAircraft = null;
		addAircraftMenuBanner();
		System.out.println("\u2502 1) Custom Bomber                                   \u2502");
		System.out.println("\u2502 2) B1-B Lancer                                     \u2502");
		System.out.println("\u2502 3) B-52H Stratofortress                            \u2502");
		System.out.println("\u2502 4) Return to main menu                             \u2502");
		System.out.print("\u2514"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2518");
		System.out.print(" \u21f6 ");
		int aircraftChoice = kb.nextInt();
		kb.nextLine();
		System.out.println();

		switch (aircraftChoice) {
		case (1):
			newAircraft = customBomber(kb, jetsOnAirfield);
			break;
		case (2):
			newAircraft = new B1BLancer();
			break;
		case (3):
			newAircraft = new B52HStratofortress();
			break;
		case (4):
			break;
		}
		return newAircraft;
	}

	public Jet customBomber(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		System.out.print(" Enter the aircraft's model: ");
		String model = kb.next();
		kb.nextLine();
		System.out.print(" Enter the aircraft's top speed: ");
		double speed = kb.nextDouble();
		kb.nextLine();
		System.out.print(" Enter the aircraft's max range: ");
		int range = kb.nextInt();
		kb.nextLine();
		System.out.print(" Enter the aircraft's price: ");
		double price = kb.nextDouble();
		kb.nextLine();
		System.out.println();

		return new Bomber(model, speed, range, price);

	}

	public Jet tankerMenu(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		Jet newAircraft = null;
		
		addAircraftMenuBanner();
		System.out.println("\u2502 1) Custom Tanker                                   \u2502");
		System.out.println("\u2502 2) KC-10A Extender                                 \u2502");
		System.out.println("\u2502 3) KC-46A Pegasus                                  \u2502");
		System.out.println("\u2502 4) KC-135R Stratotanker                            \u2502");
		System.out.println("\u2502 5) Return to main menu                             \u2502");
		System.out.print("\u2514"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2518");
		System.out.print(" \u21f6 ");
		int aircraftChoice = kb.nextInt();
		kb.nextLine();
		System.out.println();

		switch (aircraftChoice) {
		case (1):
			newAircraft = customTanker(kb, jetsOnAirfield);
			break;
		case (2):
			newAircraft = new KC10AExtender();
			break;
		case (3):
			newAircraft = new K46APegasus();
			break;
		case (4):
			newAircraft = new KC135RStratotanker();
			break;
		case (5):
			break;
		}
		return newAircraft;
	}

	public Jet customTanker(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		System.out.print(" Enter the aircraft's model: ");
		String model = kb.next();
		kb.nextLine();
		System.out.print(" Enter the aircraft's top speed: ");
		double speed = kb.nextDouble();
		kb.nextLine();
		System.out.print(" Enter the aircraft's max range: ");
		int range = kb.nextInt();
		kb.nextLine();
		System.out.print(" Enter the aircraft's price: ");
		double price = kb.nextDouble();
		kb.nextLine();
		System.out.println();

		return new Tanker(model, speed, range, price);

	}

	public Jet cargoJetMenu(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		Jet newAircraft = null;
		
		addAircraftMenuBanner();
		System.out.println("\u2502 1) Custom Cargo Jet                                \u2502");
		System.out.println("\u2502 2) C-5M Galaxy                                     \u2502");
		System.out.println("\u2502 3) C-40C                                           \u2502");
		System.out.println("\u2502 4) C-130 Hercules                                  \u2502");
		System.out.println("\u2502 5) C-17A Globesmaster                              \u2502");
		System.out.println("\u2502 6) Return to main menu                             \u2502");
		System.out.print("\u2514"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2518");
		System.out.print(" \u21f6 ");
		int aircraftChoice = kb.nextInt();
		kb.nextLine();
		System.out.println();

		switch (aircraftChoice) {
		case (1):
			newAircraft = customCargoJet(kb, jetsOnAirfield);
			break;
		case (2):
			newAircraft = new C5MGalaxy();
			break;
		case (3):
			newAircraft = new C40C();
			break;
		case (4):
			newAircraft = new C130Hercules();
			break;
		case (5):
			newAircraft = new C17AGlobemaster();
			break;
		case (6):
			break;
		}
		return newAircraft;
	}

	public Jet customCargoJet(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		System.out.print(" Enter the aircraft's model: ");
		String model = kb.next();
		kb.nextLine();
		System.out.print(" Enter the aircraft's top speed: ");
		double speed = kb.nextDouble();
		kb.nextLine();
		System.out.print(" Enter the aircraft's max range: ");
		int range = kb.nextInt();
		kb.nextLine();
		System.out.print(" Enter the aircraft's price: ");
		double price = kb.nextDouble();
		kb.nextLine();
		System.out.println();

		return new CargoJet(model, speed, range, price);

	}

	public Jet rpaMenu(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		Jet newAircraft = null;
		
		addAircraftMenuBanner();
		System.out.println("\u2502 1) Custom RPA                                      \u2502");
		System.out.println("\u2502 2) MQ-9 Reaper                                     \u2502");
		System.out.println("\u2502 3) RQ-4 Global Hawk                                \u2502");
		System.out.println("\u2502 4) Return to main menu                             \u2502");
		System.out.print("\u2514"); for (int i = 0; i < 52; i++) System.out.print("\u2500"); System.out.println("\u2518");
		System.out.print(" \u21f6 ");
		int aircraftChoice = kb.nextInt();
		kb.nextLine();
		System.out.println();

		switch (aircraftChoice) {
		case (1):
			newAircraft = customRPA(kb, jetsOnAirfield);
			break;
		case (2):
			newAircraft = new MQ9Reaper();
			break;
		case (3):
			newAircraft = new RQ4GlobalHawk();
			break;
		case (4):
			break;
		}
		return newAircraft;
	}

	public Jet customRPA(Scanner kb, ArrayList<Jet> jetsOnAirfield) {

		System.out.print(" Enter the aircraft's model: ");
		String model = kb.next();
		kb.nextLine();
		System.out.print(" Enter the aircraft's top speed: ");
		double speed = kb.nextDouble();
		kb.nextLine();
		System.out.print(" Enter the aircraft's max range: ");
		int range = kb.nextInt();
		kb.nextLine();
		System.out.print(" Enter the aircraft's price: ");
		double price = kb.nextDouble();
		kb.nextLine();
		System.out.println();

		return new RPA(model, speed, range, price);

	}
}