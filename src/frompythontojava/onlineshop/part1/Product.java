package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Product {

    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private static int nextId = 1;
    private int ID;
    private static ArrayList<Product> productList;

    Product() {
        this.ID = nextId;
        nextId++;
        productList.add(this);
    }

    Product(String name, Float defaultPrice, ProductCategory productCategory) {
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        this.ID = nextId;
        nextId++;
        productList.add(this);
    }
}
