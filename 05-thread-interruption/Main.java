public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int numberOfPlayers = 4;
        PlayerThread[] threads = new PlayerThread[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            threads[i] = new PlayerThread(i + 1);
            threads[i].start();
        }

        // Competition time limit
        Thread.sleep(2000);

        // TODO: Task One - Interrupt all players after the time limit

        // TODO: Task Two - Wait for all player threads to finish

        // Determine the player with the highest score
        int winningScore = 0;
        int winner = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (threads[i].getScore() > winningScore) {
                winningScore = threads[i].getScore();
                winner = i + 1;
            }
        }

        System.out.println("Player " + winner + " wins with a score of " + winningScore);
    }
}
