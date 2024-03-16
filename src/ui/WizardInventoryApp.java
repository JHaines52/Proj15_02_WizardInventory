package ui;

import java.util.ArrayList;
import java.util.List;
import model.WizardsLogic;

import util.Console;

public class WizardInventoryApp {

	private static final String SHOW = "show";
	private static final String GRAB = "grab";
	private static final String EDIT = "edit";
	private static final String DROP = "drop";
	private static final String EXIT = "exit";

	public static void main(String[] args) {
		System.out.println("Welcome to Wizard!");
		String choice = "";

		List<String> itemsList = new ArrayList<>();
		itemsList.add("wooden staff");
		itemsList.add("wizard hat");
		itemsList.add("cloth shoes");

		while (!choice.equalsIgnoreCase(EXIT)) {
			choice = commandItems();

			switch (choice) {
			case SHOW:
				setSHOW(itemsList);
				break;

			case GRAB:
				setGRAB(itemsList);

				break;
			case EDIT:
				System.out.println(choice + "- Edit an item");
				break;
			case DROP:
				System.out.println(choice + "- Drop an item");
				break;
			case EXIT:
				System.out.println(choice + "- Exit program");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");

			}

		}
		System.out.println("Goodbye!");
	}

	public static String commandItems() {
		System.out.println("\nCOMMAND MENU:");
		System.out.println("------------------------");
		System.out.println("show - Show all items");
		System.out.println("grab - Grab an item");
		System.out.println("edit - Edit an item");
		System.out.println("drop - Drop an item");
		System.out.println("exit - Exit program");
		return Console.getString("Command: ");

	}

	private static void setSHOW(List<String> items) {
		System.out.println("Show all items:");
		System.out.println("---------------");
		for (int i = 1; i <= items.size(); i++) {
			System.out.println(i+". "+items.get(i - 1));}

	}

	private static void setGRAB(List<String>items) {
		System.out.println("Grab (Add) an item:");
		System.out.println("---------------");
		
		if (items.size() >= 4) {
			System.out.println("You can't carry any more items. Drop something first.");
		}
		else {
			String itemName = Console.getString("Item name: ");
			items.add(itemName);
			System.out.println(itemName + " was added.");}

	}
	private static void setEdit(List<String>items) {
		System.out.println("Edit an item:");
		System.out.println("---------------");
		String itemName = Console.getString("Item name: ");
		items.add(itemName);
		System.out.println(itemName + " was added.");}

		
	}


