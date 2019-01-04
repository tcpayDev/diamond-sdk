package io.tradingchain.sdk.diamondsdk.order;

public class CreateOrderReq {
  public String offerOrderNo;
  public String quantity;
  public String price;
  public String amount;
  public String type;
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";
}
