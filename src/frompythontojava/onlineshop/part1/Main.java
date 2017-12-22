package frompythontojava.onlineshop.part1;

public class Main {

    public static void main(String[] args) {
	    Basket basket = new Basket();
	    basket.addProduct(new Product("Pizza", 12.34f, new ProductCategory("Food")));

	    for (Iterator iter = basket.getIterator(); iter.hasNext();) {
	        System.out.println(iter.next());
        }
    }
}
