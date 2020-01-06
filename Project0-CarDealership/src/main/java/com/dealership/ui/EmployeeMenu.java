package com.dealership.ui;

import java.util.Scanner;

import com.dealership.service.ManageLot;
import com.dealership.service.ManageOffers;
import com.dealership.service.ManagePayment;

public class EmployeeMenu {
	
	static void empMenu (Scanner scan) {
		
		String empOptions = "Please choose an option below: \n"
				+"1. Add a car to the lot\n"
				+"2. Evaluate an offer\n"
				+"3. Remove a car from the lot\n"
				+"4. View the cars on the lot\n"
				+"5. View all the cars in the system\n"
				+"6. View all open payment plans\n"
				+"7. Return to the previous menu";
		int input4=0;
		System.out.println(empOptions);
		while(input4 != 7) {
			input4 = scan.nextInt();
			switch(input4) {
			case 1:
				ManageLot.addCar(scan);
				System.out.println("\nReturning to the previous menu...");
				System.out.println(empOptions);
				break;
			case 2:
				ManageOffers.viewOfferList();
				ManageOffers.evaluateOffer(scan);
				System.out.println("\nReturning to the previous menu...");
				System.out.println(empOptions);
				break;
			case 3:
				ManageLot.removeCar(scan);
				System.out.println("\nReturning to the previous menu...");
				System.out.println(empOptions);
				break;
			case 4:
				ManageLot.viewLot();
				System.out.println("\nReturning to the previous menu...");
				System.out.println(empOptions);
				break;
			case 5:
				ManageLot.viewAllCars();
				System.out.println("\nReturning to the previous menu...");
				System.out.println(empOptions);
				break;
			case 6:
				ManagePayment.viewPaymentList();
				System.out.println("\nReturning to the previous menu...");
				System.out.println(empOptions);
				break;
			case 7:
				System.out.println("\nReturning to the previous menu...");
				break;
			default:
				System.out.println("Try again");
				break;
			}
		}
	}
	
}
