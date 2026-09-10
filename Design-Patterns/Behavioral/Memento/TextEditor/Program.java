package Behavioral.Memento.TextEditor;

public class Program {
    public static void main(String[] args) {
        TextEditor editor =new TextEditor("",14);
        Caretaker caretaker = new Caretaker();

        editor.write("Hello");
        editor.showState();
        caretaker.save(editor.createMemento());

        System.out.println("--------------");
        editor.changeFontSize(20);
        editor.write(" Walid");
        editor.showState();
        caretaker.save(editor.createMemento());

        System.out.println("--------------");
        editor.write(" Ahmed");
        editor.showState();
        EditorMemento undo = caretaker.undo();
        editor.restore(undo);
        editor.showState();
    }
}
