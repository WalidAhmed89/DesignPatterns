package Behavioral.Interpreter.Iterator.PlayList;

public class PlayListIterator implements Iterator{
    private final String[] playList;
    private int position =0;

    public PlayListIterator(String[] playList) {
        this.playList = playList;
    }

    @Override
    public boolean hasNext() {
        return position < playList.length;
    }

    @Override
    public String next() {
        return playList[position++];
    }
}
