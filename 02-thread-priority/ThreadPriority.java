public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> count(), "Thread-1");
        Thread t2 = new Thread(() -> count(), "Thread-2");
        Thread t3 = new Thread(() -> count(), "Thread-3");        
        
        t1.start();
        t2.start();
        t3.start();
    }

    public static void count() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " count: " + i);
        }
    }
}