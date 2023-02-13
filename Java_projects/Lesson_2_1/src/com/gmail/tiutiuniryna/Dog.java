package com.gmail.tiutiuniryna;

public class Dog extends Animal {
	private String name;

	public Dog(String ration, String color, int weight, String name) {
		super(ration, color, weight);
		this.name = name;
	}

	public Dog(String ration, String color, int weight) {
		super(ration, color, weight);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]" + super.toString();
	}

	@Override
	public String getVoice() {
		super.getVoice();
		return " - Dog barking" + super.toString();
	}

	@Override
	public void eat() {

		System.out.println(" - Dog bones");
	}

	@Override
	public void sleep() {

		System.out.println(" - Dogs 12 – 14 hours");
	}

}
