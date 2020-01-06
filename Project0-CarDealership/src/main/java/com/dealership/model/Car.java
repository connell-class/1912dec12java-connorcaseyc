package com.dealership.model;

import java.io.Serializable;

public class Car implements Serializable {
	
	private static final long serialVersionUID = -8754687040417638284L;
	
	private String make;
	private String color;
	private Object owner;
	private int value;
	private int id;
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Object getOwner() {
		return owner;
	}
	public void setOwner(Object owner) {
		this.owner = owner;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", color=" + color + ", owner=" + owner + ", value=" + value + "]";
	}
	public Car(String make, String color, Object owner, int value, int id) {
		super();
		this.make = make;
		this.color = color;
		this.owner = owner;
		this.value = value;
		this.id = id;
	}
	public Car() {}

	public Car(Car c) {
		this.make = c.getMake();
		this.color = c.getColor();
		this.owner = c.getOwner();
		this.id = c.getId();
	}
	
}
