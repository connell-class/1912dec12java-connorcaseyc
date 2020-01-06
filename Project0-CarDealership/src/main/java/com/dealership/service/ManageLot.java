package com.dealership.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dealership.model.Car;

public class ManageLot {
	
	public static String filename = "./src/main/java/com/dealership/data/carlot.txt";
	
		//to create new car lot use this line
	//public static List<Car> carLot = new ArrayList<>();
		//to maintain a car lot use this line
	public static List<Car> carLot = readCarLot(filename);
	
		
	
	public static Car addCar(Scanner scan) {
		Random r = new Random();
		System.out.println("\nAdding a new car to the lot...");
		Car c = new Car();
		c.setOwner(EnterLogin.getUser());
		System.out.println("What is the make of the car?");
		c.setMake(scan.next());
		System.out.println("What color is the car?");
		c.setColor(scan.next());
		System.out.println("What is the value of the car?");
		c.setValue(scan.nextInt());
		c.setId(r.nextInt(100));
		makeLot(c);
		return c;
	}
	public static void removeCar(Scanner scan) {
		System.out.println("\nHere is the current lot: ");
		viewLot();
		System.out.println("Which car do you want to remove?");
		int inputR=scan.nextInt();
		System.out.println("\nYou chose: "+carLot.get(inputR));
		carLot.remove(inputR);
		writeCarLot(filename, carLot);
	}
	
	public static void assignOwner(int acceptId, Object newOwner) {
		Car toEdit = carLot.get(acceptId);
		toEdit.setOwner(newOwner);
		System.out.println(toEdit);
		writeCarLot(filename, carLot);
	}
	
	public static void viewLot() {
		System.out.println("Here are the current cars on the lot");
		carLot = readCarLot(filename);
		for(int i=0; i<carLot.size(); i++) {
			if(carLot.get(i).getOwner().equals("dealer")) {
				System.out.println(carLot.get(i));
			}
		}	
	}
	public static void viewAllCars() {
		System.out.println("Here are all the cars in the system");
		carLot = readCarLot(filename);
		for(int i=0; i<carLot.size(); i++) {
			System.out.println(carLot.get(i)+" number "+i);
		}
	}
	
	public static void makeLot(Car c) {
		writeCarLot(filename, carLot);
		carLot.add(new Car(c.getMake(), c.getColor(), c.getOwner(), c.getValue(), c.getId()));
		writeCarLot(filename, carLot);
		//System.out.println(carLot);
	}
	public static void writeCarLot(String file, List<Car> c) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(c);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static List<Car> readCarLot(String file) {
		try(ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(file))) {
			return (List<Car>)ois1.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
			
}
