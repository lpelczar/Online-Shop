package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;

public class BasketController {

    private Basket basket;

    BasketController(){
        this.basket = new Basket();
    }

    public Iterator getBasketIterator() {
        return this.basket.getIterator();
    }
}
