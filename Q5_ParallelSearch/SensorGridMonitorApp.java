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

        // start min and max searches together
        for (int w = 0; w < workers; w++) {
            minThreads[w].start();
            maxThreads[w].start();
        }
        for (int w = 0; w < workers; w++) {
            minThreads[w].join();
            maxThreads[w].join();
        }

        // combine partial results into global values
        double globalMin = mins[0].getMin();
        double globalMax = maxs[0].getMax();
        for (int w = 0; w < workers; w++) {
            System.out.println("Segment " + w + " -> min: " + mins[w].getMin()
                    + ", max: " + maxs[w].getMax());
            if (mins[w].getMin() < globalMin) globalMin = mins[w].getMin();
            if (maxs[w].getMax() > globalMax) globalMax = maxs[w].getMax();
        }

        long elapsed = System.nanoTime() - startTime;
        System.out.println("Global minimum temperature : " + globalMin);
        System.out.println("Global peak vibration      : " + globalMax);
        System.out.println("Execution time: " + elapsed / 1000 + " microseconds");
    }
}
