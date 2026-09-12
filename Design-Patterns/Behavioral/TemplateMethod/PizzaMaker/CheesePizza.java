package Behavioral.TemplateMethod.PizzaMaker;

public class CheesePizza extends PizzaMaker{
    @Override
    protected void prepareDough() {
        System.out.println("Prepare thin dough");
    }

    @Override
    protected void addSauce() {
        System.out.println("Add cheese sauce");
    }

    @Override
    protected void addToppings() {
        System.out.println("Add mozzarella");
    }
}
