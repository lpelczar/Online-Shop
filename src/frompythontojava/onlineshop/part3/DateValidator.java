package frompythontojava.onlineshop.part3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {

    DateValidator() {}

    public Date parseDate(String dateToValidate, String dateFormat) throws ParseException{

        Date date;

        if (dateToValidate == null) {
            throw new ParseException("Wrong date", 0);
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            date = sdf.parse(dateToValidate);

        } catch (ParseException e) {

            throw new ParseException("Wrong date", 0);
        }
        return date;
    }
}