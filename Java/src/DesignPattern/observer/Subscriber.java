package observer;

public class Subscriber implements Observer {
    private String name;
    private Channel channel=new Channel();
    @Override
    public void update(){
        System.out.println("hey "+name+" video uploaded "+channel.title);
    }
    @Override
    public void subscribeChannel(Channel ch){
        channel=ch;
    }

    public Subscriber(String name) {
        this.name = name;
    }
}
