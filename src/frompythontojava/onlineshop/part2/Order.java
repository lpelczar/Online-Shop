package frompythontojava.onlineshop.part2;

public class Order implements Orderable {

    private int id;
    private static int nextId = 1;
    private String status;
    private final String newStatus = "new";
    private final String checkedStatus = "checked";
    private final String payedStatus = "payed";

    Order() {
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

    }
}
