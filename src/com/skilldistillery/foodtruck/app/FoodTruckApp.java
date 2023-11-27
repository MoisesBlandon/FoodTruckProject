package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;
import java.util.Scanner;
public class FoodTruckApp {

	FoodTruck[] Fleet = new FoodTruck[5];
	private int count = 0;

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		System.out.println("\nEat Smart With The Food Truck App!\n" + "----------------------------------");
		app.run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		String selection;

		do {
			displayMainMenu();
			selection = sc.nextLine();

			switch (selection) {
			case "1":
				if (count == Fleet.length) {
					System.out.println("UH OH!!!\nMaximum number of food trucks listed. Press any key for Main Menu: ");
					sc.nextLine();
					break;
				} else {
					newTruck(sc);
					break;
				}
			case "2":
				displayTrucks();
				System.out.print("\nPress any key for Main Menu: ");
				sc.nextLine();
				System.out.println("");
				break;
			case "3":
				displayAverage();
				System.out.print("\nPress any key for Main Menu: ");
				sc.nextLine();
				break;
			case "4":
				displayHighestRated();
				System.out.print("\nPress any key for Main Menu: ");
				sc.nextLine();
				break;
			case "5":
				System.out.println("Good Bye and Happy Eating!");
				break;
			default:
				System.out.print("\nInvalid choice. Press any key for Main Menu: \n");
				sc.nextLine();
			}
		} while (!selection.equals("5"));

		sc.close();
	} 

	private void displayMainMenu() {
		System.out.print("\n*** MAIN MENU ***" + "\n\n" + 
				"(1) Add New Food Truck\n" + 
				"(2) Show All Food Trucks\n" +
				"(3) Show Average Rating for All Trucks\n" + 
				"(4) Show Highest Rated Truck(s)\n"+
				"(5) Quit App\n\n");
	}

	private void menu2() {
		System.out.print("\n"
				+ "(1) Add another truck\n"
				+ "(2) Return to main menu\n\n");
	}
	
	boolean quit(String Quit) {
		boolean result = false;
		switch (Quit) {
		case "q":
			result = true;
			break;
		case "Q":
			result = true;
			break;
		case "quit":
			result = true;
			break;
		case "Quit":
			result = true;
			break;
		case "QUIT":
			result = true;
			break;
		}

		return result;
	}

	private void newTruck(Scanner sc) {
		int selection2;
		String name;
		String Type;
		int rating;
		do {
			System.out.println("Enter name of food truck, or enter Quit for Main Menu: ");
			name = sc.nextLine();
			if (quit(name)) { 
				break;
			}

			System.out.println("What type of food does " + name + " serve?: ");
			Type = sc.nextLine();

			System.out.print("On a scale of 1-10, What would you rate " + name + "?: ");
			rating = sc.nextInt();
			sc.nextLine();

			FoodTruck newTruck = new FoodTruck(name, Type, rating);
			addTruck(newTruck);

			if (count < Fleet.length) {
				menu2();
				selection2 = sc.nextInt();
				sc.nextLine();
				switch (selection2) {
				case 1:
					continue;
				case 2:
					break;

				}
			} else {
				System.out.print("UH OH!!!\\nMaximum number of food trucks listed. Press any key for Main Menu: ");
				sc.nextLine();
				break;
			}
		} while (selection2 == 1); 
	} 

	private void addTruck(FoodTruck truck) {
		Fleet[count] = truck;
		count++;
	}

	private void displayTrucks() {
		System.out.println("");
		for (FoodTruck truck : Fleet) {
			if (truck != null) {
				System.out.println(truck.toString());
			}

		}
	}

	private void displayAverage() {
		double totalRatings = 0.0;
		double averageRating = 0.0;
		for (FoodTruck truck : Fleet) {
			if (truck != null) {
				totalRatings += truck.getRating();
			}
		}
		averageRating = (totalRatings) / (count);
		System.out.println("Average rating for all food trucks is " + averageRating);

	}

	private void displayHighestRated() {
		int highest = 0;
		for (FoodTruck truck : Fleet) {
			if (truck != null) {
				if (truck.getRating() > highest) {
					highest = truck.getRating();
				}
			}
		}
		for (FoodTruck truck : Fleet) {
			if (truck != null) {
				if (truck.getRating() == highest) {
					System.out.println(truck.toString());
				}
			}
		}
	}

	
}