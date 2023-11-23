public class DataRaceExample {
    private boolean flag = false;

    public void setFlag(boolean value) {
        flag = value; // Without volatile, changes might not be visible to other threads
    }

    public boolean checkFlag() {
        return flag; // Might read a stale value
    }

    public static void main(String[] args) throws InterruptedException {
        DataRaceExample example = new DataRaceExample();

        Thread writerThread = new Thread(() -> {
            example.setFlag(true);
            System.out.println("Flag set to true");
        });

        Thread readerThread = new Thread(() -> {
            while (!example.checkFlag()) {
                // Waiting for flag to become true - might never see the change
            }
            System.out.println("Flag is true");
        });

        readerThread.start();
        Thread.sleep(100); // Simulating some delay
        writerThread.start();

    }
}
