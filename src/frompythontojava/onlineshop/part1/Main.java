package frompythontojava.onlineshop.part1;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

	    Basket basket = new Basket();
	    ProductCategory food = new ProductCategory("Food");
	    ProductCategory tools = new ProductCategory("Tools");
	    Date milkExpirationDate = new Date();
	    ProductCategory milk = new FeaturedProductCategory("Milk", milkExpirationDate);
	    Product product1 = new Product("Pizza", 12.34f, food);
	    Product product2 = new Product("Hammer", 18.34f, tools);
	    Product product3 = new Product();
        Product product4 = new Product("GoodMilk", 12.34f, milk);
	    basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
	    basket.removeProduct(product1);

        for (Iterator iterator = basket.getIterator(); iterator.hasNext();) {
	        System.out.println(iterator.next());
        }

        System.out.println("");

        ArrayList<Product> allProducts = product1.getAllProducts();
        for (Product p : allProducts) {
            System.out.println(p);
        }

        System.out.println("");

        ArrayList<Product> toolsProducts = product1.getAllProductsBy(food);
        for (Product p : toolsProducts) {
            System.out.println(p);
        }


    }
}
