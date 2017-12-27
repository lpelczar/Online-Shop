package frompythontojava.onlineshop.part1;

import java.util.ArrayList;

public class CategoriesContainer {

    private ArrayList<ProductCategory> categories;

    public CategoriesContainer() {
        this.categories = new ArrayList<>();
    }

    public ArrayList<ProductCategory> getCategories() {
        return categories;
    }
}
