package com.gmail.tiutiuniryna;

public class Main {

	public static void main(String[] args) {
		Cat animal1 = new Cat("mice", "white", 3, "Tom");
		Dog animal2 = new Dog("bones", "black", 5, "Bob");
		System.out.println(animal1.toString());
		System.out.println(animal2.toString());
		Veterinarian veterinarian1 = new Veterinarian("Sam");
		System.out.println(veterinarian1.toString());
		veterinarian1.treatment(animal1);
		veterinarian1.treatment(animal2);

	}

}
