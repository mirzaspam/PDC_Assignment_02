# Q1: Polymorphism in a Trading Engine

## What it does
A base class `TradeEvent` is extended by `FIXOrderEvent` and `ReutersQuoteEvent`. Each subclass overrides `dispatch()` with its own behavior. The main class stores all events in a `TradeEvent` array and calls `dispatch()` on each one.

## Files
- `TradeEvent.java`: base class (sender ID, timestamp, base price)
- `FIXOrderEvent.java`: calculates order value, 0.15% fee and total cost
- `ReutersQuoteEvent.java`: calculates bid/ask spread
- `TradingEngineApp.java`: main class

## How to run
    cd Q1_Polymorphism
    javac *.java
    java TradingEngineApp

## Concepts used
Inheritance, `super(...)`, method overriding, runtime polymorphism.
