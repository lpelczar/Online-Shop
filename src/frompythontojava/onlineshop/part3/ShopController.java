package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;

import java.util.Arrays;

public class ShopController {

    private Basket basket;
    private ShopView view;
    private Product product;
    private CategoriesContainer categoriesContainer;


    ShopController() {
        this.basket = new Basket();
        this.view = new ShopView();
        this.categoriesContainer = new CategoriesContainer();
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
                createNewCategory();
            } else if (userInput.equals("7")) {
                showAllCategories();
            } else if (userInput.equals("0")) {
                shouldExit = true;
            } else {
                view.displayWrongInputMessage();
            }
        }
    }

    private void createNewCategory() {

        String name = getCategoryName();
        boolean isFeaturedCategory = getIsFeaturedCategory();
        if (!isFeaturedCategory) {
            if (!this.categoriesContainer.containsProductCategoryWithName(name)) {
                this.categoriesContainer.addCategory(new ProductCategory(name));
                view.displayCategoryAddedMessage();
            }

        }

    }

    private String getCategoryName() {

        int maxNameLength = 15;
        String name = "";
        boolean isNameCorrect = false;

        while(!isNameCorrect) {
            name = view.getCategoryNameInput();
            if (name.length() < maxNameLength && name.length() > 0) {
                isNameCorrect = true;
            }
        }
        return name;
    }

    private boolean getIsFeaturedCategory() {

        final String[] CORRECT_OPTIONS = {"y", "n"};
        String userInput = "";
        boolean userInputInCorrectOptions = false;

        while (!userInputInCorrectOptions) {
            userInput = view.getIsFeaturedCategoryInput();
            userInputInCorrectOptions = Arrays.asList(CORRECT_OPTIONS).contains(userInput.toLowerCase());
            if (!userInputInCorrectOptions) {
                view.displayWrongInputMessage();
            }
        }
        return (userInput.equals(CORRECT_OPTIONS[0]));
    }

    private void showAllCategories() {

        view.displayAllCategories(this.categoriesContainer.getCategories());
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
