public class FIXOrderEvent extends TradeEvent {
   private String clOrdId;
   private int quantity;

   public FIXOrderEvent(String var1, long var2, double var4, String var6, int var7) {
      super(var1, var2, var4);
      this.clOrdId = var6;
      this.quantity = var7;
   }
   @Override
    public void dispatch() {
        double orderValue = basePrice * quantity;
        double fee = orderValue * 0.0015;        // 0.15% fee
        double total = orderValue + fee;

        System.out.println("[FIX ORDER] Sender: " + senderId + " | ClOrdID: " + clOrdId);
        System.out.println("  BUY " + quantity + " shares @ " + basePrice);
        System.out.println("  Order Value : " + orderValue);
        System.out.println("  Exchange Fee (0.15%): " + fee);
        System.out.println("  Total Cost  : " + total);
    }
}
