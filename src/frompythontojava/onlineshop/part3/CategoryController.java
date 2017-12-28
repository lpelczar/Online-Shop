package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CategoryController {

    private ShopView view;
    private DateValidator dateValidator;
    private CategoriesContainer categoriesContainer;

    CategoryController() {
        this.view = new ShopView();
        this.dateValidator = new DateValidator();
        this.categoriesContainer = CategoriesContainer.getInstance();
    }

    public ArrayList<ProductCategory> getAllCategories() {

        return this.categoriesContainer.getCategories();
    }

    public void createNewCategory(boolean getInput) {

        String name = getCategoryName();
        boolean isFeaturedCategory = getIsFeaturedCategory();
        if (!isFeaturedCategory) {
            if (!this.categoriesContainer.containsProductCategory(name)) {
                this.categoriesContainer.addCategory(new ProductCategory(name));
                view.displayCategoryAddedMessage(getInput);
            } else {
                view.displayCategoryAlreadyExistsMessage(getInput);
            }
        } else {
            Date expirationDate = getExpirationDate();
            if (!this.categoriesContainer.containsFeaturedProductCategory(name, expirationDate)) {
                this.categoriesContainer.addCategory(new FeaturedProductCategory(name, expirationDate));
                view.displayCategoryAddedMessage(getInput);
            } else {
                view.displayCategoryAlreadyExistsMessage(getInput);
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

    private Date getExpirationDate() {

        boolean isDateCorrect = false;
        Date expirationDate = null;

        while(!isDateCorrect) {
            String dateString = view.getDateInput();
            try {
                expirationDate = this.dateValidator.parseDate(dateString, "dd-MM-yyyy");
                isDateCorrect = true;
            } catch (ParseException e) {
                view.displayWrongInputMessage();
            }
        }
        return expirationDate;
    }

    protected void displayAllCategories() {

        view.displayAllCategories(getAllCategories(), true);
    }
}
