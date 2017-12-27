package frompythontojava.onlineshop.part1;

import java.util.ArrayList;
import java.util.Date;

public class CategoriesContainer {

    private static final CategoriesContainer instance = new CategoriesContainer();
    private ArrayList<ProductCategory> categories = new ArrayList<>();

    private CategoriesContainer() {}

    public static CategoriesContainer getInstance(){
        return instance;
    }

    public ArrayList<ProductCategory> getCategories() {
        return categories;
    }

    public void addCategory(ProductCategory category) {
        this.categories.add(category);
    }

    public boolean containsProductCategory(String name) {
        for (ProductCategory category: this.categories) {
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
        for(ProductCategory pc : this.categories) {
            if(pc instanceof FeaturedProductCategory)
                featuredCategories.add((FeaturedProductCategory) pc);
        }
        return featuredCategories;
    }

    public boolean containsCategoryWithId(int id) {

        for (ProductCategory category : this.categories) {
            if (category.getID() == id) {
                return true;
            }
        }
        return  false;
    }

    public ProductCategory getCategoryById(int id) {

        ProductCategory category = null;
        for (ProductCategory cat : this.categories) {
            if (cat.getID() == id) {
                category = cat;
            }
        }
        return category;
    }
}
