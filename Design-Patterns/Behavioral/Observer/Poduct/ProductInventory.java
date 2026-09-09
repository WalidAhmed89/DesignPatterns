package Behavioral.Observer.Poduct;

import java.util.ArrayList;
import java.util.List;

public class ProductInventory implements Observable{
    private final List<Observer> observers = new ArrayList<>();
    private String productName;
    private int stock;

    public ProductInventory(String productName, int stock) {
        this.productName = productName;
        this.stock = stock;
    }

    @Override
    public void addProduct(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeProduct(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update(productName,stock);
        }
    }

    public void setStock(int stock){
        this.stock = stock;
        notifyObserver();
    }
}
