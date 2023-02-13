package com.gmail.tiutiuniryna;

public class Network {
	// private boolean registration;
	private Phone[] numbers;

	public Network() {
		super();
		this.numbers = new Phone[0];
	}

	public void registrationNumber(Phone phoneNumber) {
		this.addNumber();
		this.numbers[this.numbers.length -1]= phoneNumber;
	}

	public void addNumber() {
		int lengthNumbers = this.numbers.length;
		Phone[] temp = new Phone[lengthNumbers + 1];
		System.arraycopy(numbers, 0, temp, 0, lengthNumbers + 1);
		this.numbers = temp;
	}



}
