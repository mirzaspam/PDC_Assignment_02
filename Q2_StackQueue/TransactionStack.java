public class TransactionStack {
    private char[] data;
    private int top;       // index of top element, -1 means empty
    private int capacity;

    public TransactionStack(int capacity) {
        this.capacity = capacity;
        data = new char[capacity];
        top = -1;
    }

    public void push(char c) {
        if (top == capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        data[++top] = c;
    }
}
