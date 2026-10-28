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
    }
}
