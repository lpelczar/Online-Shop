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

    
}
