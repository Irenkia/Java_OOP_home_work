package com.gmail.tiutiuniryna;

public class Product {
	private String description;
	private int price;
	private int id;
	public Product(String description, int price, int id) {
		super();
		if(price <0) {
			throw new IllegalArgumentException("Invalid price value");
		}
		this.description = description;
		this.price = price;
		this.id = id;
	}
	public Product() {
		super();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price <0) {
			throw new IllegalArgumentException("Invalid price value");
		}
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Product [description=" + description + ", price=" + price + ", id=" + id + "]";
	}
	

}
