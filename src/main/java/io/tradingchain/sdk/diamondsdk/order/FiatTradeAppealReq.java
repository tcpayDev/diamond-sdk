package io.tradingchain.sdk.diamondsdk.order;

public class FiatTradeAppealReq {
  public String orderNo;
  public String appealRemark;
  public String appealFile;
  public String appealReason;
  public String contact;
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";
}
