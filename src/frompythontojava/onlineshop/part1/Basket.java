package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Product> productList;
    private Iterator iterator = new ProductIterator();

    private class ProductIterator implements Iterator {

        private int index;

        public boolean hasNext() {

            if (index < productList.size()) {
                return true;
            }
            return false;
        }

        public Object next() {

            if (this.hasNext()) {
                return productList.get(index++);
            }
            return null;
        }
    }

    public Iterator getIterator() {
        return iterator;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public boolean removeProduct(Product product) {
        for (Iterator iterator = this.getIterator(); iterator.hasNext();) {
            Product prod = (Product)iterator.next();
            if (product == prod) {
                productList.remove(prod);
            }
        }
    }
}