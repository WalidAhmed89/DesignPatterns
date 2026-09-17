package Behavioral.Observer.YoutubeChannel;

import java.util.ArrayList;
import java.util.List;

public class ChannelSubject implements YoutubeChannelSubject{
    private List<SubscribersObserver> subscribers;
    private final String channelName;
    private String videoTitle;

    public ChannelSubject(String channelName, String videoTitle) {
        this.videoTitle = videoTitle;
        this.subscribers = new ArrayList<>();
        this.channelName = channelName;
    }


    @Override
    public void subscribe(SubscribersObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(SubscribersObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void uploadVideo(String videoTitle) {
        this.videoTitle = videoTitle;
        notifySubscriber();
    }

    @Override
    public void notifySubscriber() {
        for(SubscribersObserver subscriber : subscribers){
            subscriber.update(this.videoTitle,this.channelName);
        }
    }
}
