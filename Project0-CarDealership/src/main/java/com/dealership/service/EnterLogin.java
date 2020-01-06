package com.dealership.service;

import java.util.Scanner;

import com.dealership.ui.Operate;

public class EnterLogin {

	public static Object loggedIn="";
	
	public static void confirmUser(Scanner scan) {
		String loginScreen = "Please enter your username: ";
		boolean confirm = false;
		String input6="";
		System.out.println(loginScreen);
		while(confirm==false) {
			input6 = scan.next();
			int lengthy = CreateLogin.loginSize();
			for (int i=0; i<lengthy; i++) {			
				Object testUser = CreateLogin.readLoginUser(i);	
				Object testPass = CreateLogin.readLoginPass(i);
				if(input6.equals(testUser)) {
					//confirm=true;
					loggedIn=testUser;
					String inputPass="";
					System.out.println("Username recognized, please enter the password for "+input6+":");
					inputPass=scan.next();
					if(inputPass.equals(testPass)) {
						confirm=true;
					} else {
						Operate.log.info("The password is incorrect");
					}
				}
			}
			if(confirm==false) {
				String inv = "Unrecognized, if you need to "
						+ "create an account restart the program and select"
						+ " new user";
				System.out.println(inv);
				Operate.log.error(inv);
			}
		}
	}
	
	public static Object getUser() {
		return loggedIn;
	}

}
