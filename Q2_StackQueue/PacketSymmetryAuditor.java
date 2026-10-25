public class PacketSymmetryAuditor {

    static boolean audit(String payload) {
        int n = payload.length();
        TransactionStack stack = new TransactionStack(n);
        RequestQueue queue = new RequestQueue(n);

        // push and enqueue at the same time
        for (int i = 0; i < n; i++) {
            char c = payload.charAt(i);
            stack.push(c);
            queue.enqueue(c);
        }

        // pop (last char) vs dequeue (first char)
        boolean symmetric = true;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            char fromStack = stack.pop();
            char fromQueue = queue.dequeue();
            System.out.println("  LIFO: " + fromStack + "  FIFO: " + fromQueue);
            if (fromStack != fromQueue) {
                symmetric = false;
                break;
            }
        }
        return symmetric;
    }

    public static void main(String[] args) {
        String[] packets = { "RADAR", "LEVEL", "PACKET", "A1B2B1A" };

        for (String p : packets) {
            System.out.println("Auditing payload: " + p);
            boolean result = audit(p);
            System.out.println("Result: " + (result ? "SYMMETRIC (palindrome)" : "NOT symmetric"));
            System.out.println("=============================");
        }
    }
}