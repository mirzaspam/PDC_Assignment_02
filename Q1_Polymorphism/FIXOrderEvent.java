public class FIXOrderEvent extends TradeEvent {
   private String clOrdId;
   private int quantity;

   public FIXOrderEvent(String var1, long var2, double var4, String var6, int var7) {
      super(var1, var2, var4);
      this.clOrdId = var6;
      this.quantity = var7;
   }
}
