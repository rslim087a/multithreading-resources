import java.util.Random;

public class PlayerThread extends Thread {

    private int score;
    private Random random = new Random();

    public PlayerThread(int playerNumber) {
        this.score = 0;
        this.setName(Integer.toString(playerNumber));
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Random getRandom() {
        return this.random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            // Increment score by up to 10 points
            this.setScore(this.getScore() + random.nextInt(5)); 
        }
        System.out.println("Player " + this.getName() + " final score: " + this.getScore());
    }
}
