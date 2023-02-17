package com.gmail.tiutiuniryna;

public class Main {

	public static void main(String[] args) {
		System.out.println("Let's create products");
		Product product1 = new Product("Bag male", 250, 1);
		Product product2 = new Product("Bag women's", 350, 2);
		Product product3 = new Product("Bag children's", 150, 3);

		System.out.println(product1);
		System.out.println(product2);
		System.out.println(product3);
		System.out.println();

		System.out.println("Add products to the order");
		Order allProducts = new Order();
		allProducts.addProduct(product1);
		allProducts.addProduct(product2);
		allProducts.addProduct(product3);
		System.out.println(allProducts);
		System.out.println();

		System.out.println("Find out if the product 5 is in the order");
		try {
			System.out.println(allProducts.searchProductById(5));
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("Remove product from order");
//		System.out.println(allProducts.removeProductById(product3.getId()));
		boolean result = allProducts.removeProductById(product2.getId());
		if (result) {
			System.out.println("Product was found and removed");
		} else {
			System.out.println("There is no such product in the order");
		}
		System.out.println();
		
		System.out.println("Now in order such products");
		System.out.println(allProducts);
		System.out.println();

		int sum = allProducts.calculateTotalSum();
		System.out.println("Sum all products = " + sum);
	}

}
