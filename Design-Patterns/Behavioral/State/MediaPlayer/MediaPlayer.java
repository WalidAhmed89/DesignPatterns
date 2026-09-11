package Behavioral.State.MediaPlayer;

public class MediaPlayer {
    private MediaPlayerState playerState;

    public MediaPlayer(){
        playerState = new StoppedState();
    }

    public void play(){
        this.playerState.play(this);
    }

    public void pause(){
        this.playerState.pause(this);
    }

    public void stop(){
        this.playerState.stop(this);
    }

    public void setState(MediaPlayerState state){
        this.playerState = state;
    }
}
