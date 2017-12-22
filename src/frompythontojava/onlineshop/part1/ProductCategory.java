package frompythontojava.onlineshop.part1;

public class ProductCategory {

    private String name;
    private int ID;
    private static int nextId = 1;

    ProductCategory() {
        this.name = "None";
        this.ID = nextId;
        nextId++;
    }

    ProductCategory(String name) {
        this.ID = nextId;
        nextId++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("ID:%d,name:%s", this.ID, this.name);
    }

}
