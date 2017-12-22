package frompythontojava.onlineshop.part1;

import java.util.Objects;

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
        return this.name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        ProductCategory other = (ProductCategory) otherObject;
        return Objects.equals(this.name, other.name) && Objects.equals(this.ID, other.ID);
    }
}
