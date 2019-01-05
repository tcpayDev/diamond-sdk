package io.tradingchain.sdk.diamondsdk.payment;

public class QueryFiatTradeReceiveReq {
  public String userId;
  public String payMode;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

  public QueryFiatTradeReceiveReq() {
  }

  public QueryFiatTradeReceiveReq(String userId, String payMode, String operSysType) {
    this.userId = userId;
    this.payMode = payMode;
    this.operSysType = operSysType;
  }

  public QueryFiatTradeReceiveReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public QueryFiatTradeReceiveReq setPayMode(String payMode) {
    this.payMode = payMode;
    return this;
  }

  public QueryFiatTradeReceiveReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
