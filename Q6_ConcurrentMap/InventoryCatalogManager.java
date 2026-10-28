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
}
