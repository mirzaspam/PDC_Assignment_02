public class ReutersQuoteEvent extends TradeEvent {
    private double bidPrice;
    private double askPrice;

    public ReutersQuoteEvent(String senderId, long timestamp, double basePrice,
                             double bidPrice, double askPrice) {
        super(senderId, timestamp, basePrice);
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }
     @Override
    public void dispatch() {
        double spread = askPrice - bidPrice;
        double spreadPercent = (spread / askPrice) * 100;

        System.out.println("[REUTERS QUOTE] Sender: " + senderId);
        System.out.println("  Bid: " + bidPrice + " | Ask: " + askPrice);
        System.out.println("  Spread: " + spread + " (" + spreadPercent + "%)");
    }
}