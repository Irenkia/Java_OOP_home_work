package com.gmail.tiutiuniryna;

public class Cat extends Animal {
	private String name;

	public Cat(String ration, String color, int weight, String name) {
		super(ration, color, weight);
		this.name = name;
	}

	public Cat(String ration, String color, int weight) {
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
		return "Cat [name=" + name + "]" + super.toString();
	}

	@Override
	public String getVoice() {
		super.getVoice();
		return super.getVoice() + " - cat meows";
	}

	@Override
	public void eat() {
		super.eat();
		System.out.println(" - Cat mice");
	}

	@Override
	public void sleep() {
		super.sleep();
		System.out.println(" - Cats 12 – 16 hours");
	}

}
