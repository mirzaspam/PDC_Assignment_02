# Q5: Parallel Min/Max Search

## What it does
Splits a large array of sensor readings into segments. Worker threads find the minimum and maximum of each segment at the same time, and `main()` combines the partial results into global values.

## Files
- `SensorSearchEngine.java`: abstract base class (implements `Runnable`)
- `ParallelMinSearch.java`: finds the minimum of a segment
- `ParallelMaxSearch.java`: finds the maximum of a segment
- `SensorGridMonitorApp.java`: main class

## How to run
    cd Q5_ParallelSearch
    javac *.java
    java SensorGridMonitorApp

## Results (from my run)
- Global minimum: ___
- Global maximum: ___
- Execution time: ___ microseconds

## Concepts used
Abstract classes, `Runnable`, splitting work into chunks, `join()`, combining partial results.
