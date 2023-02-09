package com.gmail.tiutiuniryna;

public class Main {

	public static void main(String[] args) {
		Bag bag1 = new Bag("women", 139.99, 1.5);
		Bag bag2 = new Bag("male", 75.50, 2.1);
		Bag bag3 = new Bag("children", 55.00, 0.5);
		Bag bag4 = new Bag("travel", 240.55, 3.5);

		System.out.println(bag1);
		System.out.println(bag2);
		System.out.println(bag3);
		System.out.println(bag4);

		System.out.println(bag4.getCategory());
		System.out.println(bag3.getCategory());
		System.out.println(bag2.getCategory());
		System.out.println(bag1.getCategory());

		bag1.setCoust(150.55);
		bag2.setCoust(95.00);
		bag3.setCoust(75.25);
		bag4.setCoust(299.45);

		System.out.println(bag1);
		System.out.println(bag2);
		System.out.println(bag3);
		System.out.println(bag4);
	}

}
