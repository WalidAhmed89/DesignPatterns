package Structural.FlyWeight.Discount;

import java.util.Hashtable;

public class DiscountCalculatorFactory {
    public IDiscountCalculator GetDiscount(String calculateType) {
        IDiscountCalculator calculator = null;
        Hashtable<String, IDiscountCalculator> calculatorList = new Hashtable<>();
        if (calculatorList.containsKey(calculateType)) {
            calculator = calculatorList.get(calculateType);
        } else {
            switch (calculateType) {
                case "day":
                    calculator = new DayDiscountCalculator();
                    calculatorList.put("day",calculator);
                    break;
                case "item":
                    calculator = new ItemPriceCalculator();
                    calculatorList.put("item",calculator);
                    break;
            }
        }
        return calculator;
    }
}
