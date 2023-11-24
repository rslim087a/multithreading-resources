import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ApiThroughputTester {

    private static CompletableFuture<Void> makeRequest(HttpClient client, String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    System.out.println("Response status code: " + response.statusCode());
                });
    }

    public static void testThroughput(String url, int numberOfRequests) throws InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        long startTime = System.nanoTime();

        for (int i = 0; i < numberOfRequests; i++) {
            futures.add(makeRequest(client, url));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println("Total requests: " + numberOfRequests);
        System.out.println("Total time: " + duration + " milliseconds");
        System.out.println("Throughput: " + (numberOfRequests / (duration / 1000.0)) + " requests/second");
    }

    public static void main(String[] args) throws InterruptedException {
        String url = "http://localhost:8080/factorial"; // Your API endpoint
        int numberOfRequests = 100; // Number of concurrent requests

        testThroughput(url, numberOfRequests);
    }
}
