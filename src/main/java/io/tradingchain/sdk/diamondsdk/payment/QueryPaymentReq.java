package io.tradingchain.sdk.diamondsdk.payment;

public class QueryPaymentReq {
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

  public QueryPaymentReq() {
  }

  public QueryPaymentReq(String userId) {
    this.userId = userId;
  }

  public QueryPaymentReq(String userId, String operSysType) {
    this.userId = userId;
    this.operSysType = operSysType;
  }

  public QueryPaymentReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public QueryPaymentReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
