package frompythontojava.onlineshop.part1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FeaturedProductCategory extends ProductCategory {

    private Date expirationDate;

    FeaturedProductCategory(String name, Date expirationDate) {
        super(name);
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return "FeaturedProductCategory:" + super.toString() + ",expirationDate:" + sdf.format(expirationDate) + " ";
    }
}
