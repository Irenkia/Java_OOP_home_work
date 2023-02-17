package com.gmail.tiutiuniryna;

import java.util.Arrays;

public class Order {
	private Product[] products = new Product[100];

	public Order(Product[] products) {
		super();
		this.products = products;
	}

	public Order() {
		super();
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	@Override
	public String toString() {
		String result = "Order" + System.lineSeparator();
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				result += products[i] + System.lineSeparator();
			}
		}
		return result + " total sum = " + calculateTotalSum();
	}

	public void addProduct(Product product) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] == null) {
				products[i] = product;
				return;
			}

		}

	}

	public Product searchProductById(int id) throws ProductNotFoundException {
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				if (products[i].getId() == id) {
					return products[i];
				}
			}
		}
		throw new ProductNotFoundException("This product not finded");
	}

	public boolean removeProductById(int id) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				if (products[i].getId() == id) {
					products[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	public int calculateTotalSum() {
		int sum = 0;
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				sum += products[i].getPrice();
			}
		}
		return sum;
	}

}
