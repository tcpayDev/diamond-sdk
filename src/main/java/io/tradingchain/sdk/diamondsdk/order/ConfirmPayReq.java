package io.tradingchain.sdk.diamondsdk.order;

public class ConfirmPayReq {
  public String orderNo;
  public String payMode;
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";
}
