package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;

public class BasketController {

    private Basket basket;
    private ProductController productController;
    private ShopView view;

    BasketController(){
        this.basket = new Basket();
        this.productController = ProductController.getInstance();
        this.view = new ShopView();
    }

    public Iterator getBasketIterator() {
        return this.basket.getIterator();
    }

    protected void addProductToBasket() {
        if (this.productController.getAllProducts().isEmpty()) {
            view.displayNoProductsMessage();
        } else {
            Product product = this.productController.getProductById();
            this.basket.addProduct(product);
        }
    }
}
