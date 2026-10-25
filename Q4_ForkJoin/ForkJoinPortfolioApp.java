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
    }
}