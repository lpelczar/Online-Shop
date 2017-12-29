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
            view.displayAllProducts(this.productController.getAllProducts(), false);
            Product product = this.productController.getProductById();
            this.basket.addProduct(product);
            view.displayProductAddedToBasket();
        }
    }

    protected void removeProductFromBasket() {

        if (this.basket.getProductList().isEmpty()) {
            view.displayCannotDeleteFromEmptyBasket();
        } else {
            int id = getProductIdInput();
            if (this.basket.removeAllProductsWithId(id)) {
                view.displayAllProductsWithGivenIdRemoved();
            } else {
                view.displayNoProductsInTheBasketMessage();
            }
        }
    }

    private int getProductIdInput() {

        int id = 0;
        boolean isCorrectInput = false;

        while(!isCorrectInput) {
            try {
                id = Integer.parseInt(view.getIdInput());
                isCorrectInput = true;
            } catch (NumberFormatException e) {
                view.displayWrongInputMessage();
            }
        }
        return id;
    }
}
