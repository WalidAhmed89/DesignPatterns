package Behavioral.State.MediaPlayer;

public class PausedState implements MediaPlayerState{
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Resuming media..");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Media is already paused.");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Media stopped.");
        player.setState(new StoppedState());
    }
}
