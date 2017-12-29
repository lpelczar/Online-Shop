package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Product> productList = new ArrayList<>();
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
        return productList.remove(product);
    }

    public boolean removeAllProductsWithId(int id) {

        return productList.removeIf(p -> p.getID() == id);
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }
}