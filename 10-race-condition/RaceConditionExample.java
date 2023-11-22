public class RaceConditionExample {
    private int count = 0;

    public void increment() {
        count++; // Non-atomic increment can cause race condition
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        RaceConditionExample example = new RaceConditionExample();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count (might be incorrect): " + example.getCount());
    }
}