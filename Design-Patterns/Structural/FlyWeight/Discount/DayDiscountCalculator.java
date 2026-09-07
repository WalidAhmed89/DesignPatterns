package Structural.FlyWeight.Discount;

import java.time.format.DateTimeFormatter;

public class DayDiscountCalculator implements IDiscountCalculator {

    @Override
    public double GetDiscountValue(DateTimeFormatter currentDate, String itemID) {
        //call database to calculate today discount
        return 0.15;
    }
}
