package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;

import java.util.ArrayList;

public class ShopController {

    private Basket basket;
    private ShopView view;
    private CategoryCreator categoryCreator;
    private ProductCreator productCreator;
    private CategoriesContainer categoriesContainer;


    ShopController() {
        this.basket = new Basket();
        this.view = new ShopView();
        this.categoryCreator = new CategoryCreator();
        this.productCreator = new ProductCreator();
        this.categoriesContainer = CategoriesContainer.getInstance();
    }

    public void run(){
        boolean shouldExit = false;

        while (!shouldExit) {
            clearConsole();
            view.displayMenu(this.basket.getIterator());
            String userInput = view.getUserInput();
            switch (userInput) {
                case "1":
                    this.productCreator.createNewProduct();
                    break;
                case "2":
                    this.categoryCreator.createNewCategory(true);
                    break;
                case "5":
                    showAllAvailableProducts();
                    break;
                case "6":
                    showProductsFromSpecificCategory();
                case "7":
                    view.displayAllCategories(this.categoryCreator.getAllCategories(), true);
                    break;
                case "8":
                    checkAvailabilityOfSpecificProduct();
                    break;
                case "0":
                    shouldExit = true;
                    break;
                default:
                    view.displayWrongInputMessage();
            }
        }
    }

    private void showAllAvailableProducts() {

        view.displayAllProducts(this.productCreator.getAllProducts(), true);
    }

    private void showProductsFromSpecificCategory() {

        if (!this.categoryCreator.getAllCategories().isEmpty()) {
            view.displayAllCategories(this.categoryCreator.getAllCategories(), false);
            ArrayList<Product> productsFromCategory = this.productCreator.getProductsFromCategory();
            view.displayAllProducts(productsFromCategory, true);
        } else {
            view.displayAllCategories(this.categoryCreator.getAllCategories(), true);
        }
    }

    private void checkAvailabilityOfSpecificProduct() {

        String name = this.productCreator.getProductName();
        boolean isAvailable = this.productCreator.checkAvailabilityOfProductWithName(name);
        if (isAvailable) {
            view.displayProductAvailableMessage(name);
        } else {
            view.displayProductNotAvailableMessage(name);
        }
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
