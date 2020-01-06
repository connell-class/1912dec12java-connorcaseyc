package com.dealership.ui;

import java.util.Scanner;

import com.dealership.model.User;
import com.dealership.service.EnterLogin;
import com.dealership.service.CreateLogin;

public class TopMenus {

	static void topMenu(Scanner scan) {
		String topMenu = "Welcome to the Tampa Dealership, "
				+ "are you a new or existing user?\n"
				+ "Enter 'N' for New User\n"
				+ "Enter 'E' for Existing User\n"
				+ "To end the program enter 'done' ";
		String input3 = "";
		System.out.println(topMenu);
		while(!input3.equals("DONE")) {
			input3 = scan.next().toUpperCase();
			switch(input3) {
			case "N":
				System.out.println("We are glad to have you!");
				buildUser(scan);
				System.out.println(topMenu);
				break;
			case "E":
				System.out.println("Welcome back!");
				login(scan);
				input3="DONE";
				break;
			case "DONE":
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Try again");
				break;
			}
		}
	}

	static void login(Scanner scan) {
		String loginMenu = "Are you a customer or employee?\n"
				+ "Enter 'C' for Customer\n"
				+ "Enter 'E' for Employee\n"
				+ "To end the program enter 'done' ";
		String input2 = "";
		System.out.println(loginMenu);
		while(!input2.equals("DONE")) {
			input2 = scan.next().toUpperCase();
			switch(input2) {
			case "C":
				EnterLogin.confirmUser(scan);
				System.out.println("\nUsername and password confirmed!\n");
				CustomerMenu.custMenu(scan);
				System.out.println(loginMenu);
				break;
			case "E":
				EnterLogin.confirmUser(scan);
				System.out.println("\nUsername and password confirmed!\n");
				EmployeeMenu.empMenu(scan);
				System.out.println(loginMenu);
				break;
			case "DONE":
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Try again");
				break;
			}
		}
	}
	
	public static void buildUser(Scanner scan) {
		String buildMenu = "Are you a customer or employee?\n"
				+ "Enter 'C' for Customer\n"
				+ "Enter 'E' for employee\n"
				+ "To end the program enter 'done' ";
		String input1 = "";
		System.out.println(buildMenu);
		while(!input1.equals("DONE")) {
			input1 = scan.next().toUpperCase();
			switch(input1) {
			case "C":
				User cust = new User();
				cust.setUserType(2);
				System.out.println("Hello new customer\n"
						+ "To create your account, "
						+ "please enter your desired username:");
				cust.setUserName(scan.next());
				System.out.println("Your username is: "+cust.getUserName()+"\n");
				System.out.println("Please enter your desired password:");
				cust.setUserPass(scan.next());
				System.out.println("Your password is: "+cust.getUserPass()+"\n");
				System.out.println(cust);
				System.out.println("Make sure to write down your username "
						+ "and password in a safe place!\n");
				
				CreateLogin.makeLogin(cust);
				
				System.out.println("Returning to the main menu...");
				input1="DONE";
				break;
			case "E":
				User emp = new User();
				emp.setUserType(1);
				System.out.println("Hello Employee\n"
						+ "To create your account, "
						+ "please enter your desired username:");
				emp.setUserName(scan.next());
				System.out.println("Your username is: "+emp.getUserName()+"\n");
				System.out.println("Please enter your desired Password:");
				emp.setUserPass(scan.next());
				System.out.println("Your password is: "+emp.getUserPass()+"\n");
				System.out.println(emp);
				System.out.println("Make sure to write down your username "
						+ "and password in a safe place!\n");
				
				CreateLogin.makeLogin(emp);
				
				System.out.println("Returning to the main menu...");
				input1="DONE";
				break;
			case "DONE":
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Try again");
				break;
			}
		}	
	}
	
}
