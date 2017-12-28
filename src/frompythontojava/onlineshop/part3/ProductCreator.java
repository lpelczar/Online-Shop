package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;


public class ProductCreator {

    private Product product;
    private CategoryCreator categoryCreator;
    private CategoriesContainer categoriesContainer;
    private ShopView view;

    ProductCreator() {
        this.categoryCreator = new CategoryCreator();
        this.categoriesContainer = CategoriesContainer.getInstance();
        this.view = new ShopView();
    }

    public void createNewProduct() {

        String name = getProductName();
        Float defaultPrice = getPrice();
        ProductCategory category = getProductCategory();

        if (this.product == null) {
            this.product = new Product(name, defaultPrice, category);
            view.displayProductAddedMessage();
        } else {
            if (this.product.containsProductWith(name, defaultPrice, category)) {
                view.displayProductAlreadyExistsMessage();
            } else {
                new Product(name, defaultPrice, category);
                view.displayProductAddedMessage();
            }
        }
    }

    private String getProductName() {

        int maxNameLength = 15;
        String name = "";
        boolean isNameCorrect = false;

        while(!isNameCorrect) {
            name = view.getProductNameInput();
            if (name.length() < maxNameLength && name.length() > 0) {
                isNameCorrect = true;
            }
        }
        return name;
    }

    private Float getPrice() {

        Float price = null;
        boolean isPriceCorrect = false;

        while(!isPriceCorrect) {
            try {
                price = Float.parseFloat(view.getPriceInput());
                isPriceCorrect = true;
            } catch (NumberFormatException e) {
                view.displayWrongInputMessage();
            }
        }
        return price;
    }

    private ProductCategory getProductCategory() {

        ProductCategory category = null;

        if (this.categoryCreator.getAllCategories().isEmpty()) {
            view.displayEmptyCategoriesListMessage();
            this.categoryCreator.createNewCategory();
        } else {
            category = handleChoosingCategoryOrCreatingNewOne();
        }
        return category;
    }

    private ProductCategory handleChoosingCategoryOrCreatingNewOne() {

        String addNewCategoryInput = "a";
        boolean isCorrectInput = false;
        ProductCategory category = null;
        int id;

        view.displayAllCategories(this.categoryCreator.getAllCategories(), false);
        while (!isCorrectInput) {
            String userInput = view.getCreatingCategoryInput();
            if (userInput.equals(addNewCategoryInput)) {
                this.categoryCreator.createNewCategory();
                isCorrectInput = true;
            } else {
                try {
                    id = Integer.parseInt(userInput);
                } catch (NumberFormatException e) {
                    view.displayWrongInputMessage();
                    continue;
                }
                if (this.categoriesContainer.containsCategoryWithId(id)) {
                    category = this.categoriesContainer.getCategoryById(id);
                    isCorrectInput = true;
                } else {
                    view.displayWrongInputMessage();
                }
            }
        }
        return category;
    }
}
