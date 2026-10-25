import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        int size = 10000;
        double riskCap = 900.0;
        double[] assets = new double[size];
        Random rand = new Random(42);
        for (int i = 0; i < size; i++) {
            assets[i] = 100 + rand.nextDouble() * 900;   // 100 to 1000
        }
        // Serial
        long s1 = System.nanoTime();
        double serialSum = 0;
        for (int i = 0; i < size; i++) serialSum += assets[i];
        long serialTime = System.nanoTime() - s1;
         // Parallel
        ForkJoinPool pool = new ForkJoinPool();
        long p1 = System.nanoTime();
        double parallelSum = pool.invoke(new ParallelRiskCalculator(assets, 0, size));
        long parallelTime = System.nanoTime() - p1;

        System.out.println("Serial risk score   : " + serialSum);
        System.out.println("Parallel risk score : " + parallelSum);
        System.out.println("Serial time   : " + serialTime / 1000 + " microseconds");
        System.out.println("Parallel time : " + parallelTime / 1000 + " microseconds");

        // Stress test
        pool.invoke(new PortfolioThresholdTask(assets, 0, size, riskCap));
        double afterStress = pool.invoke(new ParallelRiskCalculator(assets, 0, size));
        System.out.println("Risk score after 5% penalty on values > " + riskCap
                + " : " + afterStress);

        pool.shutdown();
    }
}