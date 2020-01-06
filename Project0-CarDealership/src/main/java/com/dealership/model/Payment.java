package com.dealership.model;

import java.io.Serializable;

public class Payment implements Serializable {

	private static final long serialVersionUID = -4436410541106263022L;
	
	private int remainingPayments;
	private Object owner;
	private Object car;
	private int scheduledPayment;
	
	public int getRemainingPayments() {
		return remainingPayments;
	}
	public void setRemainingPayments(int remainingPayments) {
		this.remainingPayments = remainingPayments;
	}
	public Object getOwner() {
		return owner;
	}
	public void setOwner(Object owner) {
		this.owner = owner;
	}
	public Object getCar() {
		return car;
	}
	public void setCar(Object car) {
		this.car = car;
	}
	public int getScheduledPayment() {
		return scheduledPayment;
	}
	public void setScheduledPayment(int scheduledPayment) {
		this.scheduledPayment = scheduledPayment;
	}
	@Override
	public String toString() {
		return "Payment [remainingPayments=" + remainingPayments + ", owner=" + owner + ", car=" + car
				+ ", scheduledPayment=" + scheduledPayment + "]";
	}
	public Payment(int remainingPayments, Object owner, Object car, int scheduledPayment) {
		super();
		this.remainingPayments = remainingPayments;
		this.owner = owner;
		this.car = car;
		this.scheduledPayment = scheduledPayment;
	}
	public Payment() {}
	
	public Payment(Payment p) {
		this.remainingPayments = p.getRemainingPayments();
		this.owner = p.getOwner();
		this.car = p.getCar();
		this.scheduledPayment = p.getScheduledPayment();
	}
	
}
