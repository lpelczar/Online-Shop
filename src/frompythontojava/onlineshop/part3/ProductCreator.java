package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.Product;

public class ProductCreator {

    private Product product;
    private CategoryCreator categoryCreator;
    private ShopView view;

    ProductCreator() {
        this.categoryCreator = new CategoryCreator();
        this.view = new ShopView();
    }

    public void createNewProduct() {

        String name = getProductName();
        Float defaultPrice = getPrice();

        if (this.product == null) {

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
}
