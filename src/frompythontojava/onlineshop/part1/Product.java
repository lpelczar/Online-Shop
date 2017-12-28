package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class Product {

    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private static int nextId = 1;
    private final int ID;
    private static ArrayList<Product> productList = new ArrayList<>();

    public Product() {
        this("None", 0.0f, new ProductCategory());
    }

    public Product(String name, Float defaultPrice, ProductCategory productCategory) {
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

        ArrayList<Product> matchingProducts = new ArrayList<>();
        for (Product product: productList) {
            if (product.getProductCategory().equals(productCategory)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    public boolean containsProductWith(String name, Float defaultPrice, ProductCategory category) {

        for (Product product: productList) {
            if (product.getName().equals(name) && product.getDefaultPrice().equals(defaultPrice)
                    && product.getProductCategory().equals(category)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.productCategory + String.format(" ID:%d,name:%s,defaultPrice:%.2f",
                                                    this.ID, this.name, this.defaultPrice);
    }
    
}
