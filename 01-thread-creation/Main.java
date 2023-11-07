public class Main {

    // public static class ChildThreadTask implements Runnable {

    // }

    public static void main(String[] args) {
        count();
    }

    public static void count() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}