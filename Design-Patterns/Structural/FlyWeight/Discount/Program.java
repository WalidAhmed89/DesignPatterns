package Structural.FlyWeight.Discount;

public class Program {
    static void main(String[] args) {
        DiscountCalculatorFactory discountCalculator = new DiscountCalculatorFactory();
        //first time will create it and put it into the hashtable
        IDiscountCalculator firstDiscountCalculatorByDay = discountCalculator.GetDiscount("day");
        IDiscountCalculator firstDiscountCalculatorByItem =discountCalculator.GetDiscount("item");
        //seconde time will return the value of the hashtable without creating it
        IDiscountCalculator SecondDiscountCalculatorByDay =discountCalculator.GetDiscount("day");
        IDiscountCalculator SecondeDiscountCalculatorByItem =discountCalculator.GetDiscount("item");
    }
}
