package Structural.FlyWeight.Discount;

import java.time.format.DateTimeFormatter;

public interface IDiscountCalculator {
    double GetDiscountValue(DateTimeFormatter currentDate,String itemID);
}
