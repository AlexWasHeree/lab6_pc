import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TaskProducer implements Runnable {
    private final BlockingQueue<Task> taskQueue;
    private final long productionDelay;
    private final String producerName;

    public TaskProducer(BlockingQueue<Task> taskQueue, long productionDelay, String producerName) {
        this.taskQueue = taskQueue;
        this.productionDelay = productionDelay;
        this.producerName = producerName;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Task task = new Task(System.currentTimeMillis(), producerName, priority);
                taskQueue.put(task);
                System.out.println(producerName + " produced task " + task.getId());
                Thread.sleep(productionDelay); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
