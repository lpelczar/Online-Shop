package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;

public class ShopController {

    private Basket basket;
    private ShopView view;
    private CategoryCreator categoryCreator;
    private ProductCreator productCreator;


    ShopController() {
        this.basket = new Basket();
        this.view = new ShopView();
        this.categoryCreator = new CategoryCreator();
        this.productCreator = new ProductCreator();
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
                    this.categoryCreator.createNewCategory();
                    break;
                case "7":
                    view.displayAllCategories(this.categoryCreator.getAllCategories());
                    break;
                case "0":
                    shouldExit = true;
                    break;
                default:
                    view.displayWrongInputMessage();
            }
        }
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
