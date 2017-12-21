package frompythontojava.onlineshop.part1;

import java.util.Date;

public class FeaturedProductCategory extends ProductCategory {

    private Date expirationDate;

    FeaturedProductCategory(String name, Date expirationDate) {
        super(name);
        this.expirationDate = expirationDate;
    }
}
