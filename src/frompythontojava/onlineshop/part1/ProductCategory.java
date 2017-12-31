package frompythontojava.onlineshop.part1;

import frompythontojava.onlineshop.data.Serializator;

import java.io.File;
import java.io.Serializable;

public class ProductCategory implements Serializable {

    private String name;
    private final int ID;
    private static int nextId = 1;

    public ProductCategory() {
        this("None");
    }

    public ProductCategory(String name) {
        deserializeNextId();
        this.ID = nextId;
        nextId++;
        serializeNextId();
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

    private void serializeNextId() {

        String filePath = "src/frompythontojava/onlineshop/data/productCategoryNextId.ser";
        Serializator.serializeObject(filePath, nextId);
    }

    @SuppressWarnings("unchecked")
    private void deserializeNextId() {

        String filePath = "src/frompythontojava/onlineshop/data/productCategoryNextId.ser";
        if (new File(filePath).exists()) {
            nextId = (int) Serializator.deserializeObject(filePath);
        }
    }

}
