/*
 * Name: Colt Andrews
 * Class: CPT167
 * Purpose: The purpose of this program is to record and log
 * the sales of grass. Including a discount rate along with a counter for 
 * each rate.
 * Date: Feb 12
 */
package andrewsModule5Participtation;

import java.util.Scanner;

public class sodNotZod 

{
	// INTIALIZE CONSTANTS 
	
	final static String ITEM_NAME_A = "Premium Grass";
	final static double ITEM_PRICE_A = 100;
	final static String ITEM_NAME_B = "Mid Grade Grass";
	final static double ITEM_PRICE_B = 50;
	final static String ITEM_NAME_C = "Basic Grass";
	final static double ITEM_PRICE_C = 10;

	final static double DISCOUNT_RATE_MEMBER = .15;
	final static double DISCOUNT_RATE_SENIOR = .25;
	final static double DISCOUNT_RATE_NONE = 0.0;
	final static double TAX_RATE = .075;

	
	// START OF MAIN CLASS
	public static void main(String[] args) 
	
	{
		Scanner input = new Scanner(System.in);
		
		
		// INTIALIZE MAIN VARIABLES
		String userName = "";
		String itemName = "";
		double itemPrice = 0.0;
		int howMany = 0;
		char rateSelection = ' ';
		char itemSelection = ' ';
		double discountAmt = 0.0;
		double discountRate = 0.0;
		double discountPrice = 0.0;
		double subTotal = 0.0;
		double tax = 0.0;
		double totalCost = 0.0;
		double grandTotal = 0.0;

		int memberCount = 0;
		int seniorCount = 0;
		int noDiscountCount = 0;

		// INVOKE STATEMENTS AND MAIN LOGIC
		displayWelcomeBanner();
		userName = getUserName(input);
		rateSelection = validateMainMenu(input, userName);
		
		// BEGGINING OF RUN WHILE
		while (rateSelection != 'Q') 
		{
			itemSelection = validateItemMenu(input, userName);
			howMany = validateHowMany(input);
			if (rateSelection == 'A') 
			{
				discountRate = DISCOUNT_RATE_MEMBER;
				memberCount++;
			} 
			else if (rateSelection == 'B') 
			{
				discountRate = DISCOUNT_RATE_SENIOR;
				seniorCount++;
			} 
			else 
			{
				discountRate = DISCOUNT_RATE_NONE;
				noDiscountCount++;
			}

			if (itemSelection == 'A') {
				itemName = ITEM_NAME_A;
				itemPrice = ITEM_PRICE_A;
			} 
			else if (itemSelection == 'B') 
			{
				itemName = ITEM_NAME_B;
				itemPrice = ITEM_PRICE_B;
			} 
			else 
			{
				itemName = ITEM_NAME_C;
				itemPrice = ITEM_PRICE_C;
			}

			discountAmt = itemPrice * discountRate;
			discountPrice = itemPrice - discountAmt;
			subTotal = howMany * discountPrice;
			tax = subTotal * TAX_RATE;
			totalCost = subTotal + tax;
			grandTotal = grandTotal + totalCost;

			displayItemReceipt(input, userName, itemName, itemPrice, howMany, discountPrice, subTotal, tax, totalCost);
			rateSelection = validateMainMenu(input, userName);

			//END OF RUN WHILE
		}
		if (grandTotal > 0) {

			displayFinalReport(memberCount, seniorCount, noDiscountCount, grandTotal);
			displayFarewellMessage();
		}

		input.close();
		
	} // END OF MAIN CLASS

	public static void displayWelcomeBanner() 
	
	{
		// WELCOME BANNER
		System.out.println();
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
		System.out.println("Welcome to the SodNotZod Receipt Machine.");
		System.out.println("Here you can calculate the total of a transaction");

		System.out.println("with the discount rate included.");
		System.out.println();
		System.out.println("-------- --------- --------- --------");
		System.out.println();
	}

	public static String getUserName(Scanner borrowedScanner) 
	{

		// USERNAME INPUT
		String borrowedUserName = "";
		System.out.println("First, what is your name?");
		borrowedUserName = borrowedScanner.nextLine();

		System.out.println();
		return borrowedUserName;
	}

	public static char validateMainMenu(Scanner borrowedScanner, String borrowedUserName) 
	
	{
		// MAIN RATE MENU
		char rateSelection = ' ';

		System.out.println("Hello " + borrowedUserName + ", please select a discount rate...");
		System.out.println();
		System.out.println("-------- RATE SELECTION ---- -------");
		System.out.println();
		System.out.println("[A] for Member Discount");
		System.out.println("[B] for Senior Discount");
		System.out.println("[C] for No Discount");
		System.out.println("[Q] to Quit");
		System.out.println();
		System.out.println("-------- --------- --------- --------");
		System.out.println();
		System.out.print("Please make your selection here: ");
		rateSelection = borrowedScanner.next().toUpperCase().charAt(0);
		while (rateSelection != 'A' 
				&& rateSelection != 'B' 
				&& rateSelection != 'C' 
				&& rateSelection != 'Q') {
			System.out.println("Error: Please Select A Valid Item");
			System.out.println();
			System.out.print("Please make your selection here: ");
			rateSelection = borrowedScanner.next().toUpperCase().charAt(0);
		}
		return rateSelection;
	}

	public static char validateItemMenu(Scanner borrowedScanner, String borrowedUserName) {

		// ITEM SELECTION MENU
		System.out.println();
		System.out.println("OK " + borrowedUserName + ", now select your grass quality...");
		System.out.println();
		System.out.println("-------- ITEM SELECTION --- --------");
		System.out.println();
		System.out.printf("[A] for %-15s\n", ITEM_NAME_A);
		System.out.printf("[B] for %-15s\n", ITEM_NAME_B);
		System.out.printf("[C] for %-15s\n", ITEM_NAME_C);
		System.out.println();
		System.out.println("-------- --------- --------- --------");
		System.out.println();
		System.out.print("Please make your selection here: ");
		System.out.println();
		char itemSelection = borrowedScanner.next().toUpperCase().charAt(0);

		while (itemSelection != 'A'
			&& itemSelection != 'B' 
			&& itemSelection != 'C' 
			&& itemSelection != 'Q') 
		{

			System.out.println("Error: Please Select A Valid Item");
			System.out.println();
			System.out.print("Please make your selection here: ");
			itemSelection = borrowedScanner.next().toUpperCase().charAt(0);

		}
		return itemSelection;
	}

	public static int validateHowMany(Scanner borrowedScanner) 
	{
		
		// HOW MANY UNITS PROMPT
		System.out.println();
		System.out.println("Great, and how many units are being purchased?");
		int howMany = borrowedScanner.nextInt();
		System.out.println();
		return howMany;

	}

	public static void displayItemReceipt(Scanner borrowedInput, String borrowedUserName, String borrowedItemName,
			double borrowedItemPrice, double borrowedHowMany, double borrowedDiscountPrice, double borrowedSubTotal,
			double borrowedTax, double borrowedTotalCost) 
	{

		// DISPLAY ITEM RECEIPT
		System.out.println();
		System.out.println("Thank you " + borrowedUserName + "!");
		System.out.println();
		System.out.println("The following is your receipt:");
		System.out.println();
		System.out.println();
		System.out.println("-------- DISCOUNT REPORT --- --------");
		System.out.println();

		System.out.printf("%-20s%-25s\n", "Item Name: ", borrowedItemName);

		System.out.printf("%-20s%1s%8.2f\n", "Original Price: ", "$", borrowedItemPrice);

		System.out.printf("%-20s%1s%8.2f\n", "Quanity: ", 'x', borrowedHowMany);

		System.out.printf("%-20s%1s%8.2f\n", "Discounted Price: ", "$", borrowedDiscountPrice);
		System.out.println();

		System.out.printf("%-20s%1s%8.2f\n", "Subtotal: ", "$", borrowedSubTotal);

		System.out.printf("%-20s%1s%8.2f\n", "Tax: ", "$", borrowedTax);
		System.out.println();

		System.out.printf("%-20s%1s%8.2f\n", "Total:", '$', borrowedTotalCost);
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();

	}

	public static void displayFinalReport(int borrowedMemberCount, int borrowedSeniorCount, int borrowedNoDiscountCount,
			double borrowedGrandTotal) 
	{

		// DISPLAY FINAL REPORT
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.printf("%-20s%4d\n", "Member Count: ", borrowedMemberCount);
		System.out.printf("%-20s%4d\n", "Senior Count: ", borrowedSeniorCount);
		System.out.printf("%-20s%4d\n", "No Discount : ", borrowedNoDiscountCount);
		System.out.printf("%-20s%1s%8.2f\n", "Grand Total: ", "$", borrowedGrandTotal);
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();

	}

	public static void displayFarewellMessage()
	{
		
		// DISPLAY FAREWELL MESSAGE
		System.out.println("-------- --------- --------- --------");
		System.out.println("Thank you for shopping with SodNotZod!");
		System.out.println("Where all your grassy dreams come true.");

	}
	
	
}
