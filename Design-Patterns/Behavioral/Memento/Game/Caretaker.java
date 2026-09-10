package Behavioral.Memento.Game;

import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> history = new Stack<>();

    public void save(Memento memento){
        history.add(memento);
    }
    public Memento undo(){
        if(history.isEmpty()){
            return null;
        }
        return history.pop();
    }
}
