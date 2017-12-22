package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Basket basket = new Basket();
	    Product product1 = new Product("Pizza", 12.34f, new ProductCategory("Food"));
	    Product product2 = new Product("Hammer", 18.34f, new ProductCategory("Tools"));
	    Product product3 = new Product();
	    basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
	    basket.removeProduct(product1);

        for (Iterator iterator = basket.getIterator(); iterator.hasNext();) {
	        System.out.println(iterator.next());
        }

        ArrayList<Product> products = product1.getAllProducts();


    }
}
