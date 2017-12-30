package frompythontojava.onlineshop.part1;

import frompythontojava.onlineshop.data.Serializator;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {

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
        serializeProductsList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
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
        deserializeProductsList();
        return productList;
    }

    public ArrayList<Product> getAllProductsBy(ProductCategory productCategory) {

        ArrayList<Product> matchingProducts = new ArrayList<>();
        for (Product product: getAllProducts()) {
            if (product.getProductCategory().equals(productCategory)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    public ArrayList<Product> getAllProductsBy(String name) {

        ArrayList<Product> matchingProducts = new ArrayList<>();
        for (Product product: getAllProducts()) {
            if (product.getName().equals(name)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    public boolean containsProductWith(String name, Float defaultPrice, ProductCategory category) {

        for (Product product: getAllProducts()) {
            if (product.getName().equals(name) && product.getDefaultPrice().equals(defaultPrice)
                    && product.getProductCategory().equals(category)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsProductWithName(String name) {

        for (Product product: getAllProducts()) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsProductWithId(int id) {

        for (Product product: getAllProducts()) {
            if (product.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public Product getProductById(int id) {

        Product product = null;
        for (Product p : getAllProducts()) {
            if (p.getID() == id) {
                product = p;
            }
        }
        return product;
    }

    private void serializeProductsList() {

        String filePath = "src/frompythontojava/onlineshop/data/productslist.ser";
        Serializator.serializeObject(filePath, productList);
    }

    @SuppressWarnings("unchecked")
    private void deserializeProductsList() {

        String filePath = "src/frompythontojava/onlineshop/data/productslist.ser";
        if (new File(filePath).exists()) {
            productList = (ArrayList<Product>) Serializator.deserializeObject(filePath);
        }
    }

    public String toString() {
        return String.format("ID:%d,name:%s,defaultPrice:%.2f ", this.ID, this.name, this.defaultPrice)
                + this.productCategory;
    }
    
}
