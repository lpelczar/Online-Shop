package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;

import java.util.ArrayList;

public class ShopController {

    private ShopView view;
    private BasketController basketController;
    private CategoryController categoryController;
    private ProductController productController;


    ShopController() {
        this.view = new ShopView();
        this.basketController = new BasketController();
        this.categoryController = new CategoryController();
        this.productController = new ProductController();
    }

    public void run(){
        boolean shouldExit = false;

        while (!shouldExit) {
            view.displayMenu(this.basketController.getBasketIterator());
            String userInput = view.getUserInput();
            switch (userInput) {
                case "1":
                    this.productController.createNewProduct();
                    break;
                case "2":
                    this.categoryController.createNewCategory(true);
                    break;
                case "5":
                    this.productController.showAllAvailableProducts();
                    break;
                case "6":
                    this.productController.showProductsFromSpecificCategory();
                    break;
                case "7":
                    view.displayAllCategories(this.categoryController.getAllCategories(), true);
                    break;
                case "8":
                    this.productController.checkAvailabilityOfSpecificProduct();
                    break;
                case "0":
                    shouldExit = true;
                    break;
                default:
                    view.displayWrongInputMessage();
            }
        }
    }
}
