package Behavioral.Observer.OrderNotficationSystem;

import java.util.ArrayList;
import java.util.List;

public class Order implements Observable{
    private final List<Observer> observers = new ArrayList<>();
    String orderID;
    String customerName;
    private String status;

    public Order(String orderID, String customerName, String status) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.status = status;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update(this.orderID,this.status,this.customerName);
        }
    }

    public void setStatus(String status){
        this.status = status;
        notifyObserver();
    }
}
