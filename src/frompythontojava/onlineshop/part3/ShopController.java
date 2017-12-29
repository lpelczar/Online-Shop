package frompythontojava.onlineshop.part3;

public class ShopController {

    private ShopView view;
    private BasketController basketController;
    private CategoryController categoryController;
    private ProductController productController;
    private OrderController orderController;


    ShopController() {
        this.view = new ShopView();
        this.basketController = new BasketController();
        this.categoryController = new CategoryController();
        this.productController = ProductController.getInstance();
        this.orderController = new OrderController();
    }

    public void run(){
        boolean shouldExit = false;

        while (!shouldExit) {
            view.displayMenu(this.basketController.getBasketIterator());
            String userInput = view.getUserInput();
            switch (userInput) {
                case "1":
                    this.productController.createNewProduct();
                    break;
                case "2":
                    this.categoryController.createNewCategory(true);
                    break;
                case "3":
                    this.basketController.addProductToBasket();
                    break;
                case "4":
                    this.basketController.removeProductFromBasket();
                    break;
                case "5":
                    this.productController.showAllAvailableProducts();
                    break;
                case "6":
                    this.productController.showProductsFromSpecificCategory();
                    break;
                case "7":
                    this.categoryController.displayAllCategories();
                    break;
                case "8":
                    this.productController.checkAvailabilityOfSpecificProduct();
                    break;
                case "9":
                    this.orderController.payForOrder(this.basketController.getBasket());
                    break;
                case "10":
                    this.orderController.displayAllOrders();
                    break;
                case "11":
                    shouldExit = true;
                    break;
                default:
                    view.displayWrongInputMessage();
            }
        }
    }
}
