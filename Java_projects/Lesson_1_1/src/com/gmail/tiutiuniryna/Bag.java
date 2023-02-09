package com.gmail.tiutiuniryna;

import java.text.DecimalFormat;

public class Bag {
	private String category;
	private double coust;
	private double weight;
	public Bag(String category, double coust, double weight) {
		super();
		this.category = category;
		this.coust = coust;
		this.weight = weight;
	}
	public Bag() {
		super();
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getCoust() {
		return coust;
	}
	public void setCoust(double coust) {
		this.coust = coust;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	DecimalFormat df2 = new DecimalFormat("#0.00");
	DecimalFormat df3 = new DecimalFormat("#0.000");
	@Override
	public String toString() {
		return "Bag [category=" + category + ", coust=" + df2.format(coust) + ", weight=" + df3.format(weight) + "]";
	}
}
