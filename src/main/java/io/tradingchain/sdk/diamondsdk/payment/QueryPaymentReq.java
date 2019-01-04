package io.tradingchain.sdk.diamondsdk.payment;

public class QueryPaymentReq {
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";
}
