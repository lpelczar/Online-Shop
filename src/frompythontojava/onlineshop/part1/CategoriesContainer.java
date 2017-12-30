package frompythontojava.onlineshop.part1;

import frompythontojava.onlineshop.data.Serializator;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class CategoriesContainer {

    private ArrayList<ProductCategory> categories = new ArrayList<>();

    public CategoriesContainer() {}

    public void addCategory(ProductCategory category) {
        this.categories.add(category);
        serializeCategories();
    }

    public ArrayList<ProductCategory> getCategories() {
        deserializeCategories();
        return categories;
    }

    private void serializeCategories() {

        String filePath = "src/frompythontojava/onlineshop/data/categories.ser";
        Serializator.serializeObject(filePath, this.categories);
    }

    @SuppressWarnings("unchecked")
    private void deserializeCategories() {

        String filePath = "src/frompythontojava/onlineshop/data/categories.ser";
        if (new File(filePath).exists()) {
            this.categories = (ArrayList<ProductCategory>) Serializator.deserializeObject(filePath);
        }
    }

    public boolean containsProductCategory(String name) {
        for (ProductCategory category: getCategories()) {
            if (category.getClass().getSimpleName().equals("ProductCategory")
                    && category.getName().toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsFeaturedProductCategory(String name, Date date) {

        ArrayList<FeaturedProductCategory> featuredCategories = getFeaturedCategories();
        for (FeaturedProductCategory fpc: featuredCategories) {
            if (fpc.getName().toLowerCase().equals(name.toLowerCase())
                    && fpc.getExpirationDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<FeaturedProductCategory> getFeaturedCategories() {

        ArrayList<FeaturedProductCategory> featuredCategories = new ArrayList<>();
        for(ProductCategory pc : getCategories()) {
            if(pc instanceof FeaturedProductCategory)
                featuredCategories.add((FeaturedProductCategory) pc);
        }
        return featuredCategories;
    }

    public boolean containsCategoryWithId(int id) {

        for (ProductCategory category : getCategories()) {
            if (category.getID() == id) {
                return true;
            }
        }
        return  false;
    }

    public ProductCategory getCategoryById(int id) {

        ProductCategory category = null;
        for (ProductCategory cat : getCategories()) {
            if (cat.getID() == id) {
                category = cat;
            }
        }
        return category;
    }

    public ProductCategory getLastCreatedCategory() {

        return getCategories().get(categories.size() - 1);
    }
}
