public class TradingEngineApp {
    public static void main(String[] args) {
        // superclass reference variables, subclass objects
        TradeEvent e1 = new TradeEvent("SYSTEM", System.currentTimeMillis(), 100.0);
        TradeEvent e2 = new FIXOrderEvent("BROKER-01", System.currentTimeMillis(),
                                          150.50, "ORD-1001", 100);
        TradeEvent e3 = new ReutersQuoteEvent("REUTERS-GW", System.currentTimeMillis(),
                                              150.50, 150.45, 150.55);

        TradeEvent[] events = { e1, e2, e3 };

        // Same call, different behavior decided at run time
        for (TradeEvent e : events) {
            e.dispatch();
            System.out.println("-----------------------------");
        }
    }
}