package com.dealership.model;

import java.io.Serializable;

public class Offer implements Serializable {
	
	private static final long serialVersionUID = -390186887744485040L;
	
	private int offerId;
	private int offerAmount;
	private Object offerUser;
	private int carId;
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public int getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(int offerAmount) {
		this.offerAmount = offerAmount;
	}
	public Object getOfferUser() {
		return offerUser;
	}
	public void setOfferUser(Object offerUser) {
		this.offerUser = offerUser;
	}
	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", offerAmount=" + offerAmount + ", offerUser=" + offerUser + ", carId="
				+ carId + "]";
	}
	public Offer(int offerId, int offerAmount, Object offerUser, int carId) {
		super();
		this.offerId = offerId;
		this.offerAmount = offerAmount;
		this.offerUser = offerUser;
		this.carId = carId;
	}
	public Offer() {}
	
	public Offer(Offer o) {
		this.offerId = o.getOfferId();
		this.offerAmount = o.getOfferAmount();
		this.offerUser = o.getOfferUser();
		this.carId = o.getCarId();
	}
	
}
