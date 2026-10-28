# Q2: Custom Stack, Queue and Palindrome Check

## What it does
Builds a stack (LIFO) and a circular queue (FIFO) from arrays, without using Java's built-in collections. A payload string is pushed into the stack and enqueued into the queue at the same time. Popping and dequeuing are then compared character by character. If all pairs match, the string is a palindrome.

## Files
- `TransactionStack.java`: array-based stack
- `RequestQueue.java`: array-based circular queue
- `PacketSymmetryAuditor.java`: main class with the palindrome check

## How to run
    cd Q2_StackQueue
    javac *.java
    java PacketSymmetryAuditor

## Concepts used
Stack, queue, circular indexing with `%`, overflow/underflow checks.
