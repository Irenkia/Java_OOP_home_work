package com.gmail.tiutiuniryna;

public class Phone {
	private long phoneNumber;
	private Network network;

	public Phone(long phoneNumber,Network network) {
		super();
		this.phoneNumber = phoneNumber;
		this.network = network;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Phone [phoneNumber=" + phoneNumber + "]";
	}

	public void registration() {
		this.network.registrationNumber(this);
	}

	public void outgoingCall(long callingPhoneNumber) {


	}

	public void incomingCall(long callingPhoneNumber) {
		System.out.println("the number " + phoneNumber + " calls you");
	}
}
