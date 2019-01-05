package io.tradingchain.sdk.diamondsdk.payment;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class DelPaymentReq {
  @ReqParam(isSgin = true,nullable = false, comment = "id")
  public Integer id;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";
  @ReqParam(isSgin = true,nullable = false, comment = "token")
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
