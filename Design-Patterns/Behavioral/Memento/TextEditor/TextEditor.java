package Behavioral.Memento.TextEditor;

public class TextEditor {
    private String content;
    private int fontSize;


    public TextEditor(String content, int fontSize) {
        this.content = content;
        this.fontSize = fontSize;
    }

    public void write(String text){
        content += text;
    }

    public void changeFontSize(int fontSize){
        if(fontSize <= 0){
            System.out.println("Can't set this fontSize");
        }
        this.fontSize = fontSize;
    }

    public void showState(){
        System.out.println("Font Size: "+this.fontSize+"\nContent: "+this.content.toString());
    }

    public EditorMemento createMemento(){
        return new EditorMemento(this.content,this.fontSize);
    }

    public void restore(EditorMemento memento){
        this.content = memento.getContent();
        this.fontSize = memento.getFontSize();
    }


}
