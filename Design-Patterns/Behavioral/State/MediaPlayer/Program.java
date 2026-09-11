package Behavioral.State.MediaPlayer;

public class Program {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();

        player.pause();

        player.play();

        player.play();

        player.pause();

        player.pause();

        player.play();

        player.stop();

        player.stop();
    }
}
