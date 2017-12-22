package frompythontojava.onlineshop.part1;

public class Main {

    public static void main(String[] args) {
	    Basket basket = new Basket();
	    Product product1 = new Product("Pizza", 12.34f, new ProductCategory("Food"));
	    Product product2 = new Product("Hammer", 18.34f, new ProductCategory("Tools"));
	    basket.addProduct(product1);
        basket.addProduct(product2);
	    basket.removeProduct(product1);
        for (Iterator iter = basket.getIterator(); iter.hasNext();) {
	        System.out.println(iter.next());
        }

    }
}
