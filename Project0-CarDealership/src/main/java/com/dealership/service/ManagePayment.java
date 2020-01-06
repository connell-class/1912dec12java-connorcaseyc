package com.dealership.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.dealership.model.Car;
import com.dealership.model.Payment;

public class ManagePayment {
	
	public static String filename4 = "./src/main/java/com/dealership/data/paymentlist.txt";
	
		//to create a new payment list use this line
	//public static List<Payment> paymentList = new ArrayList<>();
		//to maintain a paymentlist use this line
	public static List<Payment> paymentList = readPaymentList(filename4);

	
	
	public static void viewOwnedCars() {
		for(int i=0; i<ManageLot.carLot.size(); i++) {
			if(EnterLogin.getUser().equals(ManageLot.carLot.get(i).getOwner())) {
				System.out.println(ManageLot.carLot.get(i));
			}
		}
	}
	public static void viewMonthlyPayments() {
		for(int i=0; i<ManageLot.carLot.size(); i++) {
			if(EnterLogin.getUser().equals(ManageLot.carLot.get(i).getOwner())) {
				Car thisInfo = ManageLot.carLot.get(i);
				System.out.println(thisInfo);
				System.out.println("for this car your remaining balance is "+thisInfo.getValue());
				//System outputting the monthly payment
				System.out.println("your monthly payment is "+thisInfo.getValue()/12);
			}
		}
	}
	public static void viewPaymentList() {
		for(int i=0; i<paymentList.size(); i++) {
			System.out.println(paymentList.get(i));
		}
	}
	
	public static void constructPaymentList(Payment p) {
		writePaymentList(filename4, paymentList);
		paymentList.add(new Payment(p.getRemainingPayments(), p.getOwner(), p.getCar(), p.getScheduledPayment()));
		writePaymentList(filename4, paymentList);
	}
	public static void writePaymentList(String file, List<Payment> p) {
		try(ObjectOutputStream oos4 = new ObjectOutputStream(new FileOutputStream(file))) {
			oos4.writeObject(p);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static List<Payment> readPaymentList(String file) {
		try(ObjectInputStream ois4 = new ObjectInputStream(new FileInputStream(file))) {
			return (List<Payment>)ois4.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
