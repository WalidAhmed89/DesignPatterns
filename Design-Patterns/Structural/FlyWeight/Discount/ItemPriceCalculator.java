package Structural.FlyWeight.Discount;

import java.time.format.DateTimeFormatter;

public class ItemPriceCalculator implements IDiscountCalculator {
    @Override
    public double GetDiscountValue(DateTimeFormatter currentDate, String itemID) {
        //call database to calculate item discount
        return 0.10;
    }
}
