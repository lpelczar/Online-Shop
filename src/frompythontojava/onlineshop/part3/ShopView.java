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
        String userInput = scanner.nextLine();
        scanner.close();
        return userInput;
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

        System.out.println("Categories: ");
        for (ProductCategory category: categories) {
            System.out.println(category);
        }
    }
}
