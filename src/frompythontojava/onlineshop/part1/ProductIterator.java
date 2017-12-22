package frompythontojava.onlineshop.part1;

public class ProductIterator {

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
