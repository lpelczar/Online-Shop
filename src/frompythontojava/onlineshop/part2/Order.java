package frompythontojava.onlineshop.part2;

public class Order implements Orderable {

    private int id;
    private static int nextId = 1;
    private String status;

    Order() {
        this.id = nextId;
        nextId++;
        this.status = "new";
    }

    public String getStatus() {
        return status;
    }

    public boolean checkout() {

    }

    public boolean pay() {

    }
}
