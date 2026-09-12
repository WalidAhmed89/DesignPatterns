package Behavioral.TemplateMethod.PizzaMaker;

public class ChickenPizza extends PizzaMaker{
    @Override
    protected void prepareDough() {
        System.out.println("Prepare normal dough");
    }

    @Override
    protected void addSauce() {
        System.out.println("Add tomato sauce");
    }

    @Override
    protected void addToppings() {
        System.out.println("Add chicken and mushrooms");
    }
}
