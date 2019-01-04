package io.tradingchain.sdk.diamondsdk.payment;

public class DelPaymentReq {
  public Integer id;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";
}
