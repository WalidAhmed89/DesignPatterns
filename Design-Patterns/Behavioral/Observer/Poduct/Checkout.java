package Behavioral.Observer.Poduct;

public class Checkout implements Observer{
    @Override
    public void update(String productName, int stock) {
        System.out.println("Checkout updated : "+productName+" -> "+stock);
    }
}
