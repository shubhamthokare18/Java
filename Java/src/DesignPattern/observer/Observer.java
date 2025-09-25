package observer;

public interface Observer {
    void update();

    void subscribeChannel(Channel ch);
}
