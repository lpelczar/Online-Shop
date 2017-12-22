package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Product {

    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private static int nextId = 1;
    private final int ID;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
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

    public String toString() {
        return this.productCategory + String.format(" ID:%d,name:%s,defaultPrice:%.2f",
                                                    this.ID, this.name, this.defaultPrice);
    }
    
}
