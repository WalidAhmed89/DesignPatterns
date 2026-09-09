package Behavioral.Observer.Poduct;

public class productList implements Observer{
    @Override
    public void update(String productName, int stock) {
        System.out.println("Product List update: "+productName+" ->  "+stock);
    }
}
