import java.util.Random;

public class SensorGridMonitorApp {
    public static void main(String[] args) throws InterruptedException {
        int size = 50000;
        int workers = 4;
        double[] data = new double[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextDouble() * 100;   // readings 0 to 100
        }

        int chunk = size / workers;
        ParallelMinSearch[] mins = new ParallelMinSearch[workers];
        ParallelMaxSearch[] maxs = new ParallelMaxSearch[workers];
        Thread[] minThreads = new Thread[workers];
        Thread[] maxThreads = new Thread[workers];

        long startTime = System.nanoTime();

        for (int w = 0; w < workers; w++) {
            int s = w * chunk;
            int e = (w == workers - 1) ? size : s + chunk;
            mins[w] = new ParallelMinSearch(data, s, e);
            maxs[w] = new ParallelMaxSearch(data, s, e);
            minThreads[w] = new Thread(mins[w], "MinWorker-" + w);
            maxThreads[w] = new Thread(maxs[w], "MaxWorker-" + w);
        }
    }
}
