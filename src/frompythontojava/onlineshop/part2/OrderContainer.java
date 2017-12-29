package frompythontojava.onlineshop.part2;

import java.util.ArrayList;

public class OrderContainer {

    private ArrayList<Orderable> orders;

    public OrderContainer() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Orderable order) {
        this.orders.add(order);
    }

    public ArrayList<Orderable> getOrders() {
        return orders;
    }
}
