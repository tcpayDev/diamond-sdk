package io.tradingchain.sdk.diamondsdk.order;

public class ConfirmPayReq {
  public String orderNo;
  public String payMode;
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

  public ConfirmPayReq(String orderNo, String payMode, String userId, String operSysType) {
    this.orderNo = orderNo;
    this.payMode = payMode;
    this.userId = userId;
    this.operSysType = operSysType;
  }

  public ConfirmPayReq setOrderNo(String orderNo) {
    this.orderNo = orderNo;
    return this;
  }

  public ConfirmPayReq setPayMode(String payMode) {
    this.payMode = payMode;
    return this;
  }

  public ConfirmPayReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public ConfirmPayReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
