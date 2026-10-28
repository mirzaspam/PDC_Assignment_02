public class CacheLocalityBenchmark {
    static final int N = 2000;
    static double[][] matrix = new double[N][N];

    static double traverseRowMajor() {
        double sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    static double traverseColumnMajor() {
        double sum = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = i + j;
            }
        }

        int runs = 10;
        double rowTotal = 0, colTotal = 0;
        double checkSum = 0;
           // printed so the JIT can't skip the work
        for (int r = 1; r <= runs; r++) {
            long t1 = System.nanoTime();
            checkSum += traverseRowMajor();
            double rowMs = (System.nanoTime() - t1) / 1_000_000.0;

            long t2 = System.nanoTime();
            checkSum += traverseColumnMajor();
            double colMs = (System.nanoTime() - t2) / 1_000_000.0;

            System.out.println("Run " + r + " | Row-Major: " + rowMs
                    + " ms | Column-Major: " + colMs + " ms");
            rowTotal += rowMs;
            colTotal += colMs;
        }
        double rowAvg = rowTotal / runs;
        double colAvg = colTotal / runs;
        System.out.println("Average Row-Major    : " + rowAvg + " ms");
        System.out.println("Average Column-Major : " + colAvg + " ms");
        System.out.println("Speedup (Row over Column): " + (colAvg / rowAvg) + "x");
        System.out.println("Checksum: " + checkSum);
    }
}
