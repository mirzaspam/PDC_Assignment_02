public class ParallelMinSearch extends SensorSearchEngine {
    private double minValue;

    public ParallelMinSearch(double[] data, int start, int end) {
        super(data, start, end);
    }
    @Override
    public void processGrid() {
        minValue = sensorData[startIdx];
        for (int i = startIdx + 1; i < endIdx; i++) {
            if (sensorData[i] < minValue) minValue = sensorData[i];
        }
    }
}
