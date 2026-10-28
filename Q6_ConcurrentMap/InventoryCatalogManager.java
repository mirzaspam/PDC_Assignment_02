import java.util.*;
import java.util.concurrent.*;

public class InventoryCatalogManager {

    private static final int THREADS = 10;
    private static final int OPS_PER_THREAD = 50000;   // see assumption below
    private static final int PRODUCTS = 1000;

    private static void fillCatalog(Map<String, Integer> map) {
        for (int i = 0; i < PRODUCTS; i++) {
            map.put("P" + i, 100);
        }
    }
    private static void runBenchmark(String name, Map<String, Integer> map)
            throws InterruptedException {
        fillCatalog(map);
        ExecutorService pool = Executors.newFixedThreadPool(THREADS);

        Runnable worker = () -> {
            Random rand = new Random();
            for (int i = 0; i < OPS_PER_THREAD; i++) {
                String id = "P" + rand.nextInt(PRODUCTS);
                if (i % 2 == 0) {
                    map.get(id);                         // lookup
                } else {
                    map.merge(id, 1, Integer::sum);      // atomic update
                }
            }
        };
        long start = System.nanoTime();
        for (int t = 0; t < THREADS; t++) {
            pool.submit(worker);
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
        long elapsedNs = System.nanoTime() - start;

        double ms = elapsedNs / 1_000_000.0;
        long totalOps = (long) THREADS * OPS_PER_THREAD;
        double throughput = totalOps / (elapsedNs / 1_000_000_000.0);

        System.out.println("--- " + name + " ---");
        System.out.println("Total operations: " + totalOps);
        System.out.println("Execution time  : " + ms + " ms");
        System.out.println("Throughput      : " + (long) throughput + " ops/sec");
    }
    public static void benchmarkSynchronizedMap() throws InterruptedException {
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
        runBenchmark("Collections.synchronizedMap", map);
    }
}

