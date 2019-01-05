package io.tradingchain.sdk.diamondsdk.payment;

public class DelPaymentReq {
  public Integer id;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

  public DelPaymentReq(Integer id, String operSysType) {
    this.id = id;
    this.operSysType = operSysType;
  }

  public DelPaymentReq setId(Integer id) {
    this.id = id;
    return this;
  }

  public DelPaymentReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
