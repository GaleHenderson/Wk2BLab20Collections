package Wk2BLab20Collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Wk2BLab20Collect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		String userPick = null;
		String userCont = "y";

		ArrayList<String> itemName = new ArrayList<String>(Arrays.asList("Shampoo", "Conditioner", "Deoderant",
				"Toothpaste", "Soap", "Toothpaste", "Towel", "Wash Cloth"));
		// double[] prices = {4.50, 4.95, 3.49, 2.45, 5.95, 4.75, 2.59, 7.89};
		ArrayList<Double> prices = new ArrayList<Double>(Arrays.asList(4.50, 4.95, 3.49, 2.45, 5.95, 4.75, 2.59, 7.89));
		ArrayList<String> userCart = new ArrayList<String>();
		ArrayList<Double> userCost = new ArrayList<Double>();

		// prompt user with greeting and list of items
		System.out.println("Welcome to our Gale's Galleria!");

		while (userCont.equalsIgnoreCase("y")) {
			System.out.println("Here is a list of items you can purchase: ");
			
			// Loop to display list of items
			System.out.println();
			for (int i = 0; i < itemName.size(); i++) {
				System.out.println((i + 1) + ". " + itemName.get(i) + " $" + prices.get(i));
			}

			// prompt user to select an item
			userPick = Validator.getString(scan, "Please enter an item you are interested in purchasing: ");
			for (int i = 0; i < itemName.size(); i++) {
				if (userPick.equalsIgnoreCase(itemName.get(i))) {
					System.out.println(itemName.get(i) + " $" + prices.get(i) + " has been added to your shopping cart.");
					userCart.add(itemName.get(i));
					userCost.add(prices.get(i));
					break;
				}
//				else {
//					System.out.println("We do not currently sell this item. Please choose from the list of items we sell");
//					break;
//				}

			}

			// Prompt the user to continue shopping
			userCont = Validator.getString(scan,"Would you like to continue shopping? Press Y for yes and any key for no.");

			//advise user of what is in cart
			if (!userCart.isEmpty()) {
				System.out.println("Your shopping cart currently includes: ");
			
			//create table of items
//				String heading1 = "Item Purchased";
//				String heading2 = "Item Price";
//				String heading3 = "Order Total";
//
//				String rowDivider = "==================================================";
//				System.out.printf( "%-7s %15s %15s %n", heading1, heading2, heading3);
//				System.out.println(rowDivider);
//				
//				for (int i = 0; i < userCart.size(); i++) {
//				System.out.printf( "%6s %15f %15f %n", userCart, userCost, cartSum(userCost));
//				}
				
				int stride = userCart.size() / 3;
				for (int row = 0; row < userCart.size() / 3; row++) {
				    System.out.println(String.format("%20s %20s %12s", userCart.get(row),
				    		userCart.get(row + stride), userCart.get(row + stride * 2)));
				}
				
//				System.out.println(userCart +  " " + userCost);
//				System.out.println("The average price of the items in your cart is: " + avePrice(userCost) +  ".");
//				System.out.println("Your current subtotal is: " + cartSum(userCost) +  ".");
//				System.out.println("The most expensive item in your cart is: " + costHigh(userCost));
//				System.out.println("The cheapest item in your cart is: " + costLow(userCost));
		}
		
		}
	}
	//METHODS I CREATE
	
	public static double cartSum(ArrayList<Double> n){
	double sum = 0;
	for (int i = 0; i < n.size(); i++) {
		sum += n.get(i); 
	}
	return sum;
	}
	
	public static double avePrice(ArrayList<Double> n){
		double sum = 0;
		double avePrice = 0;
		for (int i = 0; i < n.size(); i++) {
			sum += n.get(i); 
			avePrice = sum / n.size();
		}
		return avePrice;
		}
	
	public static double costHigh(ArrayList<Double> n){
	
		Collections.sort(n);
		double priceHigh = n.get(n.size() - 1);
		
		return priceHigh;
		}
	
	public static double costLow(ArrayList<Double> n){
		
		Collections.sort(n);
		double priceLow = n.get(0);
		
		return priceLow;
		}
	
}
