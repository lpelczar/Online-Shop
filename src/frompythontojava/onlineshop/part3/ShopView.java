package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.Iterator;
import frompythontojava.onlineshop.part1.Product;
import frompythontojava.onlineshop.part1.ProductCategory;

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

    public String getCategoryNameInput() {
        System.out.print("Enter category name: ");
        return getStringInput();
    }

    public String getIsFeaturedCategoryInput() {
        System.out.print("Do you want to add expiration date? (y or n) ");
        return getStringInput();
    }

    public void displayAllCategories(ArrayList<ProductCategory> categories) {

        clearConsole();
        System.out.println("Categories: ");
        if (categories.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            for (ProductCategory category : categories) {
                System.out.println(category);
            }
        }
        displayPressAnyKeyToContinueMessage();
    }

    public void displayCategoryAddedMessage() {
        System.out.println("Category has been added to list!");
        displayPressAnyKeyToContinueMessage();
    }

    public void displayCategoryAlreadyExistsMessage() {
        System.out.println("Category already exists in the list!");
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

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
