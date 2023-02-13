package com.gmail.tiutiuniryna;

public class Veterinarian {
	String name;

	public Veterinarian(String name) {
		super();
		this.name = name;
	}

	public Veterinarian() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Veterinarian [name=" + name + "]";
	}

	public void treatment(Animal animal) {
		System.out.println("I am a veterinarian and my name is " + name + " and I can treat " + animal.toString());
	}

}
