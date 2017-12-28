package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopView {

    public void displayMenu(Iterator basketIterator) {

        System.out.println("Online shop v.1.3\n");
        System.out.println("Basket: ");
        if (!basketIterator.hasNext()) {
            System.out.println("Your basket is empty!");
        } else {
            while (basketIterator.hasNext()) {
                Product p = (Product) basketIterator.next();
                System.out.println(p);
            }
        }
        displayOptions();
    }

    private void displayOptions() {

        System.out.println("\nWhat do you want to do?\n" +
                           "1. Create new product\n" +
                           "2. Create new category\n" +
                           "3. Add product to basket\n" +
                           "4. Remove product from basket\n" +
                           "5. Show all available products\n" +
                           "6. Show products from specific category\n" +
                           "7. Show all categories\n" +
                           "8. Check availability of specific product\n" +
                           "9. Pay for the order\n" +
                           "0. Exit");
    }

    public String getUserInput() {
        System.out.print("Choose option: ");
        return getStringInput();
    }

    public void displayWrongInputMessage() {
        System.out.println("Wrong input!");
    }

    private String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getCategoryIdInput() {
        System.out.print("\nEnter category ID: ");
        return getStringInput();
    }

    public String getCategoryNameInput() {
        System.out.print("Enter category name: ");
        return getStringInput();
    }

    public String getProductNameInput() {
        System.out.print("Enter product name: ");
        return getStringInput();
    }

    public String getPriceInput() {
        System.out.print("Enter price of the product in format (X.XX): ");
        return getStringInput();
    }

    public String getIsFeaturedCategoryInput() {
        System.out.print("Do you want to add expiration date? (y or n) ");
        return getStringInput();
    }

    public void displayEmptyCategoriesListMessage() {
        System.out.println("List of categories is empty! You need to create new one!");
    }

    public void displayAllCategories(ArrayList<ProductCategory> categories, boolean getInput) {

        clearConsole();
        System.out.println("Categories: ");
        if (categories.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            for (ProductCategory category : categories) {
                System.out.println(category);
            }
        }
        if (getInput) {
            displayPressAnyKeyToContinueMessage();
        }
    }

    public void displayAllProducts(ArrayList<Product> products, boolean getInput) {

        clearConsole();
        System.out.println("Available Products: ");
        if (products.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
        if (getInput) {
            displayPressAnyKeyToContinueMessage();
        }
    }

    public void displayCategoryAddedMessage(boolean getInput) {

        if (getInput) {
            System.out.println("Category has been added to list!");
            displayPressAnyKeyToContinueMessage();
        } else {
            System.out.print("Category has been added to list and ");
        }
    }

    public void displayProductAddedMessage() {
        System.out.println("Product has been added to list!");
        displayPressAnyKeyToContinueMessage();
    }

    public void displayProductAvailableMessage(String name) {
        System.out.println(name + " is available!");
        displayPressAnyKeyToContinueMessage();
    }

    public void displayProductNotAvailableMessage(String name) {
        System.out.println(name + " is not available!");
        displayPressAnyKeyToContinueMessage();
    }

    public void displayCategoryAlreadyExistsMessage(boolean getInput) {

        if (getInput) {
            System.out.println("Category already exists in the list!");
            displayPressAnyKeyToContinueMessage();
        } else {
            System.out.print("Category already exists in the list and ");
        }
    }

    public void displayProductAlreadyExistsMessage() {
        System.out.println("Product already exists in the list!");
        displayPressAnyKeyToContinueMessage();
    }

    private void displayPressAnyKeyToContinueMessage() {
        System.out.print("\nPress any key to continue.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public String getDateInput() {
        System.out.print("Enter date in the following format -> day-month-year: ");
        return getStringInput();
    }

    public String getCreatingCategoryInput() {
        System.out.print("\nEnter ID to choose category or \"a\" to create new one: ");
        return getStringInput();
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
