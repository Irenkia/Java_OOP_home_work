package com.gmail.tiutiuniryna;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		myMethod();

	}

	public static void myMethod() {
		List<Integer> list = new ArrayList<>(10);
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(rand.nextInt(10));
		}
		System.out.println(Arrays.toString(list.toArray()));
		list.remove(0);
		list.remove(0);
		list.remove(list.size() - 1);
		System.out.println(Arrays.toString(list.toArray()));

	}
}
