package Behavioral.State.MediaPlayer;

public interface MediaPlayerState {
    void play(MediaPlayer player);
    void pause(MediaPlayer player);
    void stop(MediaPlayer player);
}
