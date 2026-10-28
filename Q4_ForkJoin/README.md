# Q4: Fork/Join Portfolio Risk

## What it does
Sums a large array of asset values in parallel using the Fork/Join framework, then applies a 5% penalty in place to every value above a risk cap. A serial loop is also timed for comparison.

## Files
- `ParallelRiskCalculator.java`: `RecursiveTask<Double>`, returns the sum
- `PortfolioThresholdTask.java`: `RecursiveAction`, modifies the array in place
- `ForkJoinPortfolioApp.java`: main class, runs and times everything

## How to run
    cd Q4_ForkJoin
    javac *.java
    java ForkJoinPortfolioApp

## Results (from my run)
- Serial time: ___ microseconds
- Parallel time: ___ microseconds
- Risk score after penalty: ___

## Notes
With a small array, task-creation overhead can make the parallel version slower than the serial one. My results: ___

## Concepts used
Divide and conquer, threshold, `fork()`, `join()`, `RecursiveTask` vs `RecursiveAction`.
