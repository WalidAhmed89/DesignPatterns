package Behavioral.Iterator.PlayList;

public class PlayList {
    private final String[] songs;

    public PlayList(String[] songs) {
        this.songs = songs;
    }

    public Iterator createIterator(){
        return new PlayListIterator(songs);
    }
}
