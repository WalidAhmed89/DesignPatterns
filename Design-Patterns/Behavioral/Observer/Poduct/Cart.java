package Behavioral.Observer.Poduct;

public class Cart implements Observer{
    @Override
    public void update(String productName, int stock) {
        System.out.println("Cart update: "+productName+" stock is now: "+stock);
    }
}
