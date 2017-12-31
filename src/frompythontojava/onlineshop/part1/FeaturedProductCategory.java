package frompythontojava.onlineshop.part1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FeaturedProductCategory extends ProductCategory implements Serializable {

    private Date expirationDate;

    public FeaturedProductCategory(String name, Date expirationDate) {
        super(name);
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return getClass().getSimpleName() + super.toString() + ",expirationDate:" + sdf.format(expirationDate);
    }
}
