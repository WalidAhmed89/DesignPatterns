package Behavioral.Interpreter.Iterator.PlayList;

public class Program {
    public static void main(String[] args) {
        String[] songs = {"Song A", "Song B", "Song C"};

        PlayList playList = new PlayList(songs);

        Iterator iterator = playList.createIterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
