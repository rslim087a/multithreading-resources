public class ThreadSleepEffect {
    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(() -> countWithSleep(0), "High-Priority-Thread");
        Thread lowPriorityThread = new Thread(() -> countWithSleep(0), "Low-Priority-Thread");
        
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
        
        lowPriorityThread.start();
        highPriorityThread.start();
    }

    public static void countWithSleep(int sleepTime) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started counting.");
        
        for (int i = 0; i < 20; i++) {
            System.out.println(threadName + " count: " + i);
            // sleep logic here...
        }        
    }
}