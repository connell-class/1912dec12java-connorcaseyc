package com.dealership.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.dealership.model.User;
import com.dealership.ui.Operate;

public class CreateLogin {

	public static String filename = "./src/main/java/com/dealership/data/users.txt";

		//To create new user list use this line
	//static List<User> userList = new ArrayList<>();
		//To maintain the current use list use this line
	public static List userList = readObjectList(filename);
	
	
	
	public static void makeLogin(User u) { 
		//writeObjectList(filename,userList);
		userList = readObjectList(filename);
		userList.add(new User(u.getUserType(), u.getUserName(), u.getUserPass()));
		writeObjectList(filename, userList);	
		//System.out.println(userList);
	}
	public static void doubleCheck() {
		System.out.println(userList);
	}
	public static int loginSize() {
		int length = userList.size();
		return length;
	}
	public static String readLoginUser(int i) {
		Object uName1 = userList.get(i);
		String uName2 = ((User) uName1).getUserName();
		return uName2;
	}
	public static String readLoginPass(int i) {
		Object pName1 = userList.get(i);
		String pName2 = ((User) pName1).getUserPass();
		return pName2;
	}
	public static void writeObjectList(String file, List<User> u) {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
			os.writeObject(u);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static List<User> readObjectList(String file) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			return (List<User>)ois.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	//To view the list of users
//	public static void main(String[] args) {	
//		for(int i=0; i<userList.size(); i++) {
//			System.out.println(userList.get(i)+" this is number "+i);
//		}
//	}	
	
	//IF YOU NEED TO REMOVE USERS USE THIS MAIN METHOD
//	public static void main(String[] args) {
//		
//		for(int i=0; i<userList.size(); i++) {
//			System.out.println(userList.get(i)+" this is number "+i);
//		}
//			
//		doubleCheck();
//		//userList.remove(3);
//		System.out.println("\n NEW LIST: \n");
//		for(int i=0; i<userList.size(); i++) {
//			System.out.println(userList.get(i)+" this is number "+i);
//		}
//		
//		doubleCheck();
//		//writeObjectList(filename, userList);
//		
//	}
	
}
