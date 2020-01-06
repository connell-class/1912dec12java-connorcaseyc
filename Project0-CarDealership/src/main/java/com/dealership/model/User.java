package com.dealership.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -978646777271063913L;
	
	private int userType;
	private String userName;
	private String userPass;
	
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	@Override
	public String toString() {
		return "User [userType=" + userType + ", userName=" + userName + ", userPass=" + userPass + "]";
	}
	public User(int userType, String userName, String userPass) {
		super();
		this.userType = userType;
		this.userName = userName;
		this.userPass = userPass;
	}
	public User() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPass == null) ? 0 : userPass.hashCode());
		result = prime * result + userType;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPass == null) {
			if (other.userPass != null)
				return false;
		} else if (!userPass.equals(other.userPass))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}
	
	public User(User u) {
		this.userType = u.getUserType();
		this.userName = u.getUserName();
		this.userPass = u.getUserPass();
	}

}
