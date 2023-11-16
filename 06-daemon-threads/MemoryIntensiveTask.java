import java.util.ArrayList;
import java.util.Random;

public class MemoryIntensiveTask implements Runnable {

    @Override
    public void run() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        try {
            for (int i = 0; i < 100000; i++) { // Reduced number of iterations
                numbers.add(random.nextInt());
                if (i % 1000 == 0) {
                    Thread.sleep(150); // Adds a slight delay every 1000 iterations
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Memory intensive task was interrupted");
        }

        System.out.println("Finished generating random numbers");
    }
}
