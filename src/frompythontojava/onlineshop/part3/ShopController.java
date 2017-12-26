package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.Basket;
import frompythontojava.onlineshop.part1.Product;

public class ShopController {

    private Basket basket;
    private ShopView view;


    ShopController() {
        this.basket = new Basket();
        this.view = new ShopView();
    }

    public void run(){
        boolean shouldExit = false;

        while (!shouldExit) {
            view.displayMenu(this.basket.getIterator());
            String userInput = view.getUserInput();
            if (userInput.equals("1")) {
                createNewProduct();
            } else if (userInput.equals("2")) {
                createNewCategory();
            } else if (userInput.equals("0")) {
                shouldExit = true;
            } else {
                view.displayWrongOptionMessage();
            }
        }
    }
}
