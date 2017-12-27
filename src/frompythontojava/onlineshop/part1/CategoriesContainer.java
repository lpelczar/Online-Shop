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

    public void addCategory(ProductCategory category) {
        this.categories.add(category);
    }

    public boolean containsProductCategoryWithName(String name) {
        for (ProductCategory category: this.categories) {
            if (category.getClass().getSimpleName().equals("ProductCategory")
                    && category.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
