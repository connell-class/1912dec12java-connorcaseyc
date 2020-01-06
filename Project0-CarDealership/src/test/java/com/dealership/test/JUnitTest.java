package com.dealership.test;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import com.dealership.model.Car;
import com.dealership.model.Payment;
import com.dealership.service.CreateLogin;
import com.dealership.service.EnterLogin;
import com.dealership.service.ManageLot;
import com.dealership.service.ManagePayment;


public class JUnitTest {
	
	@Test
	public void testAddCarId() {
		Random r = new Random();
		Car c = new Car();
		c.setId(r.nextInt(100));
		assertTrue(c.getId()>0 && c.getId()<=100);
	}
	
	@Test
	public void testRemoveCar() {
		int x = ManageLot.carLot.size();
		ManageLot.carLot.remove(0);
		int y = ManageLot.carLot.size();
		assertTrue(x>y);
	}
	
	@Test
	public void testUserList() {
		int x = CreateLogin.loginSize();
		assertTrue(x>0);
	}

	@Test
	public void testMonthlyPayments() {
		Payment p = ManagePayment.paymentList.get(0);
		int x = p.getRemainingPayments();
		int y = p.getScheduledPayment();
		int monthly = x / y;
		assertTrue(monthly==12);
	}
	
}
