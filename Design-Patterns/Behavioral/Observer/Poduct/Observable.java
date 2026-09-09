package Behavioral.Observer.Poduct;

public interface Observable {
    void addProduct(Observer observer);
    void removeProduct(Observer observer);
    void notifyObserver();
}
