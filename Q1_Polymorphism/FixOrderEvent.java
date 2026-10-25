public class FixOrderEvent extends TradeEvent {
    private String clOrdId;
    private int quantity;   // extra field so the fee calculation makes sense

    public FixOrderEvent(String senderId, long timestamp, double basePrice,
                         String clOrdId, int quantity) {
        super(senderId, timestamp, basePrice);   // parent constructor
        this.clOrdId = clOrdId;
        this.quantity = quantity;
    }
}

