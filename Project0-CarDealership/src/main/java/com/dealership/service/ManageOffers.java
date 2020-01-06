package com.dealership.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import com.dealership.model.Car;
import com.dealership.model.Offer;
import com.dealership.service.ManageLot;

public class ManageOffers {
	
	public static String filename3 = "./src/main/java/com/dealership/data/offerlist.txt";
	
		//to create a new offerList use this line
	//public static List<Offer> offerList = new ArrayList<>();
		//to maintain an offerList use this line
	public static List<Offer> offerList = readOfferList(filename3);
	
	
	
	public static Offer addOffer(Scanner scan) {
		Random r = new Random();
		Offer o = new Offer();
		ManageLot.viewLot();
		System.out.println("Enter the car ID number you would like: ");
		o.setCarId(scan.nextInt());
		System.out.println("How much would you like to offer for this car: ");
		o.setOfferAmount(scan.nextInt());
		o.setOfferUser(EnterLogin.getUser());
		o.setOfferId(r.nextInt(100));
		System.out.println("great here is your offer: "+o);
		constructOfferList(o);
		return o;
	}
	public static void viewOfferList() {
		System.out.println("\nHere is a list of the current offers");
		offerList = readOfferList(filename3);
		for(int i=0; i<offerList.size(); i++) {
			System.out.println((offerList.get(i)+" this is offer: "+i));
		}
	}
	public static void constructOfferList(Offer o) {
		writeOfferList(filename3, offerList);
		offerList.add(new Offer(o.getOfferId(), o.getOfferAmount(), o.getOfferUser(), o.getCarId()));
		writeOfferList(filename3, offerList);
	}
	public static void writeOfferList(String file, List<Offer> o) {
		try(ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream(file))) {
			oos3.writeObject(o);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static List<Offer> readOfferList(String file) {
		try(ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream(file))) {
			return (List<Offer>)ois3.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void evaluateOffer(Scanner scan) {
		String evalMenu = "\nWould you like to Accept or Reject an offer?\n"
				+ "Enter 'A' to approve an offer\n"
				+ "Enter 'R' to reject an offer\n"
				+ "Enter 'done' to return to the previous menu";
		String inputE = "";
		System.out.println(evalMenu);
		while(!inputE.equals("DONE")) {
			inputE=scan.next().toUpperCase();
			switch(inputE) {
			case "A":
				System.out.println("Enter the offer number you want to approve");
				int acceptedChoice = scan.nextInt();
				Offer acceptedOffer = offerList.get(acceptedChoice);
				System.out.println("You chose "+acceptedOffer);
				
				//Assigning owner to their car
				Object newOwner = acceptedOffer.getOfferUser();
				int acceptId = acceptedOffer.getCarId();
				ManageLot.assignOwner(acceptId, newOwner);

				//System removing all offers for that car				
				offerList.remove(acceptedChoice);
				for(int i=0; i<offerList.size(); i++) {
					if(acceptId==offerList.get(i).getCarId()) {
						offerList.remove(i);
					}
				}
				writeOfferList(filename3, offerList);
				System.out.println(evalMenu);
				break;
			
			case "R":
				System.out.println("Enter the offer ID number you want to reject");
				int offRej = scan.nextInt();
				Offer offerToRej = offerList.get(offRej);
				System.out.println("You chose "+offerToRej
						+" it will now be removed");
				offerList.remove(offRej);
				writeOfferList(filename3, offerList);
				System.out.println(evalMenu);
				break;
			case "DONE":
				inputE="DONE";
				break;
			default:
				System.out.println("Try again");
				break;
			}
		}	
	}
	
}
