package io.tradingchain.sdk.diamondsdk.payment;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class QueryPaymentReq {
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public void setVersion(String version) {
    this.version = version;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
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
