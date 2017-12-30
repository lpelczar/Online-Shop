package frompythontojava.onlineshop.part1;

import java.io.Serializable;

public class ProductCategory implements Serializable {

    private String name;
    private final int ID;
    private static int nextId = 1;

    public ProductCategory() {
        this("None");
    }

    public ProductCategory(String name) {
        this.ID = nextId;
        nextId++;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("CategoryID:%d,CategoryName:%s", this.ID, this.name);
    }

}
