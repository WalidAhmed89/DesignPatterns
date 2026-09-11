package Behavioral.State.MediaPlayer;

public class PlayingState implements MediaPlayerState{
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Media is already playing.");
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Media Paused!");
        player.setState(new PausedState());
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Media stopped.");
        player.setState(new StoppedState());
    }
}
