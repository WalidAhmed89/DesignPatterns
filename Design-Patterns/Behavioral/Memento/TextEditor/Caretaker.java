package Behavioral.Memento.TextEditor;

import java.util.Stack;

public class Caretaker {
    private final Stack<EditorMemento> editorHistory = new Stack<>();

    public void save(EditorMemento memento){
        editorHistory.add(memento);
    }

    public EditorMemento undo(){
        if(editorHistory.isEmpty()){
            return null;
        }
        return editorHistory.pop();
    }
}
