package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.Iterator;
import frompythontojava.onlineshop.part1.Product;

import java.util.ArrayList;

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

    public void displayOptions() {

        System.out.println("What do you want to do?\n" +
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
}
