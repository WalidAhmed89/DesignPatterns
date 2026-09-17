package Behavioral.Observer.YoutubeChannel;

public class Subscriber implements SubscribersObserver {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle,String channelName) {
        System.out.println(name+" received notification:\nNew video uploaded: "+videoTitle+" from channel: "+channelName);
    }
}
