package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;

public class ShopController {

    private Basket basket;
    private ShopView view;
    private CategoryCreator categoryCreator;


    ShopController() {
        this.basket = new Basket();
        this.view = new ShopView();
        this.categoryCreator = new CategoryCreator();
    }

    public void run(){
        boolean shouldExit = false;

        while (!shouldExit) {
            clearConsole();
            view.displayMenu(this.basket.getIterator());
            String userInput = view.getUserInput();
            if (userInput.equals("1")) {
                //createNewProduct();
            } else if (userInput.equals("2")) {
                this.categoryCreator.createNewCategory();
            } else if (userInput.equals("7")) {
                view.displayAllCategories(this.categoryCreator.getAllCategories());
            } else if (userInput.equals("0")) {
                shouldExit = true;
            } else {
                view.displayWrongInputMessage();
            }
        }
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
