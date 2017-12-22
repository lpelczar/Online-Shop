package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Product {

    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private static int nextId = 1;
    private int ID;
    private static ArrayList<Product> productList = new ArrayList<>();

    Product() {
        this.name = "None";
        this.defaultPrice = 0.0f;
        this.productCategory = new ProductCategory();
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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public ArrayList<Product> getAllProducts() {
        return productList;
    }

    public ArrayList<Product> getAllProductsBy(ProductCategory productCategory) {

        ArrayList<Product> matchingProducts = new ArrayList<Product>();
        for (Product product: productList) {
            if (product.getProductCategory().equals(productCategory)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, name: %s, defaultPrice: %f, productCategory: %s",
                this.ID, this.name, this.defaultPrice, this.productCategory.getName());
    }
    
}
