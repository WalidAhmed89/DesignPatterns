package Behavioral.State.MediaPlayer;

public class StoppedState implements MediaPlayerState{
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Starting media");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Cannot pause. Media is stopped.");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Media is already stopped.");
    }
}
