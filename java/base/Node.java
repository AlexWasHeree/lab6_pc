import java.util.concurrent.BlockingQueue;

public class Node implements Runnable {
    private final BlockingQueue<Task> taskQueue;

    public Node(BlockingQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Task task = taskQueue.take();
                long waitTime = System.currentTimeMillis() - task.getCreationTime();
                System.out.println("Node processing task " + task.getId() + " after waiting " + waitTime + "ms.");
                task.execute();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
