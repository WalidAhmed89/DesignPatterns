package Behavioral.Observer.YoutubeChannel;

public interface YoutubeChannelSubject {
    void subscribe(SubscribersObserver subscriber);
    void unSubscribe(SubscribersObserver subscriber);
    void uploadVideo(String videoTitle);
    void notifySubscriber();
}
