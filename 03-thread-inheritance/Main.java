public class Main {

    public static void main(String[] args) {
        // Creating the first athlete thread
        Thread firstAthlete = new Thread(() -> {
            int bibNumber = 84921;
            runRace(bibNumber);
        });


        // Creating the second athlete thread
        Thread secondAthlete = new Thread(() -> {
            int bibNumber = 43114;
            runRace(bibNumber);
        });

        // Starting the threads
        firstAthlete.start();
        secondAthlete.start();
    }

    private static void runRace(int bibNumber) {
        double distanceKM = 10;
        double steps = 0.00000001;

        for (double i = 0; i <= distanceKM; i += steps) {
            if (Math.abs(i - distanceKM) < steps) {
                System.out.println("\nAthlete number " + bibNumber + " has finished the race.\n");
                break; 
            }
        }
    }
}