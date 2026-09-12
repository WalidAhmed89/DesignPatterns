package Behavioral.TemplateMethod.PizzaMaker;

abstract class PizzaMaker {

    public final void makePizza(){
        prepareDough();
        addSauce();
        addToppings();
        bake();
    }

    protected abstract void prepareDough();
    protected abstract void addSauce();
    protected abstract void addToppings();

    protected void bake(){
        System.out.println("Bake pizza for 15 minutes");
    }

}
