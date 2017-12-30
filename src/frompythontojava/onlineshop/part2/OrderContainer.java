package frompythontojava.onlineshop.part2;

import frompythontojava.onlineshop.data.Serializator;

import java.io.File;
import java.util.ArrayList;

public class OrderContainer {

    private ArrayList<Orderable> orders;

    public OrderContainer() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Orderable order) {
        this.orders.add(order);
        serializeOrders();
    }

    public ArrayList<Orderable> getOrders() {
        deserializeOrders();
        return orders;
    }

    private void serializeOrders() {

        String filePath = "src/frompythontojava/onlineshop/data/orders.ser";
        Serializator.serializeObject(filePath, this.orders);
    }

    @SuppressWarnings("unchecked")
    private void deserializeOrders() {

        String filePath = "src/frompythontojava/onlineshop/data/orders.ser";
        if (new File(filePath).exists())
        {
            this.orders = (ArrayList<Orderable>) Serializator.deserializeObject(filePath);
        }
    }
}
