package Creational_Patterns.Singleton.Counter;

public class Counter {
    int counter;
    private volatile static Counter instance;

    private Counter(){}

    public static Counter getInstance(){
        if(instance == null){
            synchronized (Counter.class){
                if (instance == null){
                    instance = new Counter();
                }
            }
        }
        return instance;
    }

    public synchronized void addCount(){counter++;}
}
