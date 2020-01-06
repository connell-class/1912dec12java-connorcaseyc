package com.dealership.ui;

import java.util.Scanner;

import com.dealership.service.ManageLot;
import com.dealership.service.ManageOffers;
import com.dealership.service.ManagePayment;

public class CustomerMenu {
	
	static void custMenu(Scanner scan) {	
		
		String custOptions = "Please choose an option below: \n"
				+"1. View cars on the lot\n"
				+"2. Make an offer on a car\n"
				+"3. View owned cars\n"
				+"4. View remaining payments\n"
				+"5. Return to the previous menu";	
		int input5=0;
		System.out.println(custOptions);
		while(input5 != 5) {
			input5 = scan.nextInt();
			switch(input5) {
			case 1:
				ManageLot.viewLot();
				System.out.println("\nReturning to the previous menu...\n");
				System.out.println(custOptions);
				break;
			case 2:
				ManageOffers.addOffer(scan);
				System.out.println("\nReturning to the previous menu...\n");
				System.out.println(custOptions);
				break;
			case 3:
				ManagePayment.viewOwnedCars();				
				System.out.println("\nReturning to the previous menu...\n");
				System.out.println(custOptions);
				break;
			case 4:
				ManagePayment.viewMonthlyPayments();
				System.out.println("\nReturning to the previous menu...\n");
				System.out.println(custOptions);
				break;
			case 5:
				input5=5;
				System.out.println("\nReturning to the previous menu...\n");
				break;
			default:
				System.out.println("Try again");
				break;
			}
		}
	}

}
