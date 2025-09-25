import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            int tn = i;
            es.submit(()->{
                System.out.println("Task " + tn + " is executed by " + Thread.currentThread().getName());
            });
        }
        es.shutdown();
    }
}
