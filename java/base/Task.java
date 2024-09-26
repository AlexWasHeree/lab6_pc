public class Task implements Comparable<Task> {
    private final long id;
    private final int priority;
    private final long creationTime;
    private final String producer;

    public Task(long creationTime, String producer, int priority) {
        this.id = System.currentTimeMillis();
        this.creationTime = creationTime;
        this.producer = producer;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    public void execute() {
        try {
            long execDuration = 1000 + (long) (new Random().nextFloat() * (15000 - 1000));
            Thread.sleep(execDuration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

