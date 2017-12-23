package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.Basket;

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
            shouldExit = true;
        }
    }
}
