public class ParallelMaxSearch extends SensorSearchEngine {
    private double maxValue;

    public ParallelMaxSearch(double[] data, int start, int end) {
        super(data, start, end);
    }

    @Override
    public void processGrid() {
        maxValue = sensorData[startIdx];
        for (int i = startIdx + 1; i < endIdx; i++) {
            if (sensorData[i] > maxValue) maxValue = sensorData[i];
        }
    }
    public double getMax() { return maxValue; }
}
