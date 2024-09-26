import java.util.concurrent.*;

public class Scenario1 {
    public static void main(String[] args) {
        BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(8);

        for (int i = 1; i <= 5; i++) {
            TaskProducer producer = new TaskProducer(taskQueue, 5000, "Producer-" + i);
            executor.scheduleAtFixedRate(producer, 0, 5, TimeUnit.SECONDS);
        }

        for (int i = 1; i <= 3; i++) {
            Node node = new Node(taskQueue);
            executor.execute(node);
        }

        executor.scheduleAtFixedRate(() -> {
            System.out.println("Statistics:");
        }, 0, 5, TimeUnit.SECONDS);
    }
}
