package observer;

public class Youtube {
    public static void main(String[] args) {
        Channel telusko=new Channel();
        Subscriber s1=new Subscriber("Akshay");
        Subscriber s2=new Subscriber("Sonam");
        Subscriber s3=new Subscriber("Harsh");
        Subscriber s4=new Subscriber("Kiran");
        Subscriber s5=new Subscriber("Pravin");
        telusko.subscribe(s1);
        telusko.subscribe(s2);
        telusko.subscribe(s3);
        telusko.subscribe(s4);
        telusko.subscribe(s5);

        telusko.unSubscribe(s3);

        s1.subscribeChannel(telusko);
        s2.subscribeChannel(telusko);
        s3.subscribeChannel(telusko);
        s4.subscribeChannel(telusko);
        s5.subscribeChannel(telusko);

        telusko.upload("how to learn programming");
    }
}
