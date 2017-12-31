package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.data.Serializator;
import frompythontojava.onlineshop.part1.*;

import java.io.File;
import java.util.ArrayList;


public class ProductController {

    private static final ProductController instance = new ProductController();
    private Product product;
    private CategoryController categoryController;
    private CategoriesContainer categoriesContainer;
    private ShopView view;

    private ProductController() {
        deserializeProduct();
        this.categoryController = new CategoryController();
        this.categoriesContainer = new CategoriesContainer();
        this.view = new ShopView();
    }

    public static ProductController getInstance(){
        return instance;
    }

    public void createNewProduct() {

        String name = getProductName();
        Float defaultPrice = getPrice();
        ProductCategory category = getProductCategory();

        if (this.product == null) {
            this.product = new Product(name, defaultPrice, category);
            view.displayProductAddedMessage();
            serializeProduct();
        } else {
            if (this.product.containsProductWith(name, defaultPrice, category)) {
                view.displayProductAlreadyExistsMessage();
            } else {
                new Product(name, defaultPrice, category);
                view.displayProductAddedMessage();
                serializeProduct();
            }
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

    public ArrayList<Product> getAllProducts() {

        ArrayList<Product> products = new ArrayList<>();
        if (this.product != null) {
            products = this.product.getAllProducts();
        }
        return products;
    }

    private ArrayList<Product> getProductsFromCategory() {

        ProductCategory category = getCategoryByGivenId();
        ArrayList<Product> products = new ArrayList<>();
        if (this.product != null) {
            products = this.product.getAllProductsBy(category);
        }
        return products;
    }

    private ProductCategory getCategoryByGivenId() {

        boolean isCorrectInput = false;
        ProductCategory category = null;
        int id;

        while(!isCorrectInput) {
            String userInput = view.getCategoryIdInput();
            try {
                id = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                view.displayWrongInputMessage();
                continue;
            }
            if (this.categoriesContainer.containsCategoryWithId(id)) {
                category = this.categoriesContainer.getCategoryById(id);
                isCorrectInput = true;
            } else {
                view.displayWrongInputMessage();
            }
        }
        return category;
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

    private ProductCategory getProductCategory() {

        ProductCategory category;

        if (this.categoryController.getAllCategories().isEmpty()) {
            view.displayEmptyCategoriesListMessage();
            this.categoryController.createNewCategory(false);
            category = this.categoriesContainer.getLastCreatedCategory();
        } else {
            category = handleChoosingCategoryOrCreatingNewOne();
        }
        return category;
    }

    private ProductCategory handleChoosingCategoryOrCreatingNewOne() {

        String addNewCategoryInput = "a";
        boolean isCorrectInput = false;
        ProductCategory category = null;
        int id;

        view.displayAllCategories(this.categoryController.getAllCategories(), false);
        while (!isCorrectInput) {
            String userInput = view.getCreatingCategoryInput();
            if (userInput.equals(addNewCategoryInput)) {
                this.categoryController.createNewCategory(false);
                category = this.categoriesContainer.getLastCreatedCategory();
                isCorrectInput = true;
            } else {
                try {
                    id = Integer.parseInt(userInput);
                } catch (NumberFormatException e) {
                    view.displayWrongInputMessage();
                    continue;
                }
                if (this.categoriesContainer.containsCategoryWithId(id)) {
                    category = this.categoriesContainer.getCategoryById(id);
                    isCorrectInput = true;
                } else {
                    view.displayWrongInputMessage();
                }
            }
        }
        return category;
    }

    private boolean checkAvailabilityOfProductWithName(String name) {

        boolean isAvailable;
        if (this.product == null) {
            isAvailable = false;
        } else {
            isAvailable = this.product.containsProductWithName(name);
        }
        return isAvailable;
    }

    public void showAllAvailableProducts() {

        view.displayAllProducts(getAllProducts(), true);
    }

    public void showProductsFromSpecificCategory() {

        if (!this.categoryController.getAllCategories().isEmpty()) {
            view.displayAllCategories(this.categoryController.getAllCategories(), false);
            ArrayList<Product> productsFromCategory = getProductsFromCategory();
            view.displayAllProducts(productsFromCategory, true);
        } else {
            view.displayNoProductsMessage();
        }
    }

    public void checkAvailabilityOfSpecificProduct() {

        String name = getProductName();
        boolean isAvailable = checkAvailabilityOfProductWithName(name);
        if (isAvailable) {
            view.displayAllProducts(this.product.getAllProductsBy(name), true);
        } else {
            view.displayProductNotAvailableMessage(name);
        }
    }

    public Product getProductById() {

        boolean isCorrectInput = false;
        Product product = null;
        int id;

        while(!isCorrectInput) {
            String userInput = view.getProductIdInput();
            try {
                id = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                view.displayWrongInputMessage();
                continue;
            }
            if (checkAvailabilityOfProductWithId(id)) {
                product = this.product.getProductById(id);
                isCorrectInput = true;
            } else {
                view.displayWrongInputMessage();
            }
        }
        return product;
    }

    private boolean checkAvailabilityOfProductWithId(int id) {

        boolean isAvailable;
        if (this.product == null) {
            isAvailable = false;
        } else {
            isAvailable = this.product.containsProductWithId(id);
        }
        return isAvailable;
    }

    private void serializeProduct() {

        String filePath = "src/frompythontojava/onlineshop/data/product.ser";
        Serializator.serializeObject(filePath, this.product);
    }

    @SuppressWarnings("unchecked")
    private void deserializeProduct() {

        String filePath = "src/frompythontojava/onlineshop/data/product.ser";
        if (new File(filePath).exists()) {
            this.product = (Product) Serializator.deserializeObject(filePath);
        }
    }
}
