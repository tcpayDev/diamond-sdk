package io.tradingchain.sdk.diamondsdk.order;

public class CancelOrderReq {
  public String orderNo;
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

  public CancelOrderReq(String orderNo, String userId, String operSysType) {
    this.orderNo = orderNo;
    this.userId = userId;
    this.operSysType = operSysType;
  }

  public CancelOrderReq setOrderNo(String orderNo) {
    this.orderNo = orderNo;
    return this;
  }

  public CancelOrderReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public CancelOrderReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
