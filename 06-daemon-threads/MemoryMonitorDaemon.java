public class MemoryMonitorDaemon implements Runnable {

    @Override
    public void run() {
        Runtime runtime = Runtime.getRuntime();

        while (true) {
            try {
                long usedMemory = runtime.totalMemory() - runtime.freeMemory();
                System.out.println("Memory Usage: " + usedMemory + " bytes");
                Thread.sleep(5000); // Check memory usage every 5 seconds
            } catch (InterruptedException e) {
                System.out.println("Memory monitor interrupted");
            }
        }
    }
}
