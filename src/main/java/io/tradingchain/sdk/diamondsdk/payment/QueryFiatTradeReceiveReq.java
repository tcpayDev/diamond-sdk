package io.tradingchain.sdk.diamondsdk.payment;

public class QueryFiatTradeReceiveReq {
  public String userId;
  public String payMode;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";
}
