# Q6: synchronizedMap vs ConcurrentHashMap

## What it does
Benchmarks two thread-safe maps with 10 threads doing a mix of lookups and updates on a catalog of 1000 products. It reports total time and throughput for each.

## Files
- `InventoryCatalogManager.java`: contains both benchmarks and `main()`

## How to run
    cd Q6_ConcurrentMap
    javac InventoryCatalogManager.java
    java InventoryCatalogManager

## Notes
`synchronizedMap` uses one lock for the whole map, so threads wait for each other. `ConcurrentHashMap` locks much smaller parts, so threads block each other less. Operations per thread: ___ (assumption stated in the report).

## Concepts used
Thread pools (`ExecutorService`), thread-safe collections, throughput measurement.
