package Behavioral.Observer.OrderNotficationSystem;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
