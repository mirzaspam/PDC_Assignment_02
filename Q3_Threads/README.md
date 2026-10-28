# Q3: Multithreading

## What it does
Runs two tasks at the same time: a log processor (using `Runnable`) and a telemetry thread (extending `Thread`). Each thread has a custom name, prints 5 updates with `sleep()`, and `main()` waits for both using `join()`.

## Files
- `LogProcessorTask.java`: implements `Runnable`
- `TelemetryThread.java`: extends `Thread`, prints CPU cores and memory used
- `AsyncWebEngineApp.java`: main class

## How to run
    cd Q3_Threads
    javac *.java
    java AsyncWebEngineApp

## Concepts used
Two ways to create threads, `start()` vs `run()`, `sleep()`, `join()`, thread names and states.
