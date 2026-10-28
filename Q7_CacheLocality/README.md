# Q7: Cache Locality (Row-Major vs Column-Major)

## What it does
Traverses a 2000 x 2000 matrix in row-major and column-major order, repeats each 10 times, and compares the average times.

## Files
- `CacheLocalityBenchmark.java`: main class and benchmark

## How to run
    cd Q7_CacheLocality
    javac CacheLocalityBenchmark.java
    java CacheLocalityBenchmark

## Why
Row-major reads neighboring memory addresses one after another, so each cache line that is loaded gets fully used. Column-major jumps between rows, so most accesses miss the cache. This is spatial locality.
