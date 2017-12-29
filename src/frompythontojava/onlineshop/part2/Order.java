package frompythontojava.onlineshop.part2;

import frompythontojava.onlineshop.part1.Basket;

public class Order implements Orderable {

    private int id;
    private static int nextId = 1;
    private String status;
    private final String newStatus = "new";
    private final String checkedStatus = "checked";
    private final String payedStatus = "payed";
    private Basket basket;

    public Order() {
        this.id = nextId;
        nextId++;
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
}
