package frompythontojava.onlineshop.part2;

import frompythontojava.onlineshop.data.Serializator;
import frompythontojava.onlineshop.part1.Basket;

import java.io.File;
import java.io.Serializable;

public class Order implements Orderable, Serializable {

    private int id;
    private static int nextId = 1;
    private String status;
    private final String newStatus = "new";
    private final String checkedStatus = "checked";
    private final String payedStatus = "payed";
    private Basket basket;

    public Order() {
        deserializeNextId();
        this.id = nextId;
        nextId++;
        serializeNextId();
        this.status = newStatus;
    }

    public String getStatus() {
        return status;
    }

    public boolean checkout() {
        if (this.status.equals(newStatus)) {
            this.status = checkedStatus;
            return true;
        } else {
            return false;
        }
    }

    public boolean pay() {
        if (this.status.equals(checkedStatus)) {
            this.status = payedStatus;
            return true;
        } else {
            return false;
        }
    }

    public void addBasket(Basket basket) {

        this.basket = basket;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " Status: " + this.status + " Items in order: " + this.basket.getItemsQuantity();
    }

    private void serializeNextId() {

        String filePath = "src/frompythontojava/onlineshop/data/orderNextId.ser";
        Serializator.serializeObject(filePath, nextId);
    }

    @SuppressWarnings("unchecked")
    private void deserializeNextId() {

        String filePath = "src/frompythontojava/onlineshop/data/orderNextId.ser";
        if (new File(filePath).exists()) {
            nextId = (int) Serializator.deserializeObject(filePath);
        }
    }
}
