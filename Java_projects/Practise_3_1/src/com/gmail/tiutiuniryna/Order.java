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
		return "Order [products=" + Arrays.toString(products) + "]";
	}
	public void addProduct(Product product) {
		for(int i =0;i<products.length;i++) {
			if(products[i]==null) {
				products[i] = product;
				break;
			}
			
		}
		
	}
	public Product searchProductById(int id) throws ProductNotFoundException{
		Product result = null;
		for(int i =0;i<products.length;i++) {
			if(products[i]==null) {
				break;
			}
			if(products[i].getId()==id) {
				result = products[i];
			}
		}
		return result;
	}
	public boolean removeProductById(int id) {
		boolean result =false;
		for(int i =0;i<products.length;i++) {
			if(products[i]==null) {
				break;
			}
			if(products[i].getId()==id) {
				products[i] = null;
				result = true;			
			}else {
				result = false;			
			}
		}
		return result;
	}
	public int calculateTotalSum() {
		int sum =0;
		for(int i =0;i<products.length;i++) {
			if(products[i]==null) {
				continue;
			}
			sum += products[i].getPrice();
		}
		return sum;
	}

}
