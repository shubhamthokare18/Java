import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class HelloTask {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable task = () -> System.out.println("Hello from thread");
        for (int i = 0; i < 5; i++) {
            executor.submit(task);
        }
        executor.shutdown();
    }
}
