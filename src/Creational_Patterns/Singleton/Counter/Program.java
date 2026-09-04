package Creational_Patterns.Singleton.Counter;

public class Program {
    static void main(String[] args) {
        Counter counter1 = Counter.getInstance();
        Counter counter2 = Counter.getInstance();
        Thread thread1 = new Thread(counter1::addCount);
        Thread thread2 = new Thread(counter2::addCount);

        System.out.println("Counter1: "+counter1.counter+"\n"+"Counter2: "+ counter2.counter);
    }
}
