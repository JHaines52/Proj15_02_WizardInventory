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

		System.out.println("\nCOMMAND MENU:");
		System.out.println("------------------------");
		System.out.println("show - Show all items");
		System.out.println("grab - Grab an item");
		System.out.println("edit - Edit an item");
		System.out.println("drop - Drop an item");
		System.out.println("exit - Exit program");

		List<String> itemsList = new ArrayList<>();
		itemsList.add("enchanted staff");
		itemsList.add("grimoire");
		itemsList.add("cloth satchel");

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
				setEDIT(itemsList);
				break;
			case DROP:
				setDROP(itemsList);
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

		return Console.getString("Command: ");

	}

	private static void setSHOW(List<String> items) {
		System.out.println("Show all items:");
		System.out.println("---------------");
		for (int i = 1; i <= items.size(); i++) {
			System.out.println(i + ". " + items.get(i - 1));
		}

	}

	private static void setGRAB(List<String> items) {
		System.out.println("Grab (Add) an item:");
		System.out.println("---------------");

		if (items.size() >= 4) {
			System.out.println("You can't carry any more items. Drop something first.");
		} else {
			String itemName = Console.getString("Item name: ");
			items.add(itemName);
			System.out.println(itemName + " was added.");
		}

	}

	private static void setEDIT(List<String> items) {
		boolean condition = true;
		while (condition) {
			System.out.println("Edit an item:");
			System.out.println("---------------");
			String itemName = Console.getString("Item name: ");
			int index = items.indexOf(itemName);
			if (index != -1) {
				String newItemName = Console.getString("Change to: ");
				items.set(index, newItemName);
				System.out.println(newItemName + " was updated.");
				condition = false;
			} else {
				System.out.println("Item not found in the list");
			}
		}
	}

	private static void setDROP(List<String> items) {
		boolean condition = true;
		while (condition) {
			System.out.println("Drop an item:");
			System.out.println("---------------");
			String itemName = Console.getString("Item name: ");
			int index = items.indexOf(itemName);
			if (index != -1) {
				items.remove(itemName);
				System.out.println(itemName + " was dropped.");
				condition = false;
			} else {
				System.out.println("Item not found in the list");
			}
		}
	}

}
