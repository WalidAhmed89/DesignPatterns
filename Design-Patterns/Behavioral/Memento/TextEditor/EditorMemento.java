package Behavioral.Memento.TextEditor;

public class EditorMemento {
    private final String content;
    private final int fontSize;

    public EditorMemento(String content, int fontSize) {
        this.content = content;
        this.fontSize = fontSize;
    }

    public String getContent() {
        return content;
    }

    public int getFontSize() {
        return fontSize;
    }
}
