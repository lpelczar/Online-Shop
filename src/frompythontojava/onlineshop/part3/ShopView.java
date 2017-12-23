package frompythontojava.onlineshop.part3;

public class ShopView {

    public void displayOptions(){
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
