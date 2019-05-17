package io.tradingchain.sdk.diamondsdk.payment;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class DelPaymentReq {
  @ReqParam(isSgin = true,nullable = false, comment = "id")
  public String id;
  @ReqParam(isSgin = true,nullable = false, comment = "userId")
  public String userId;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";

  public DelPaymentReq(String id, String operSysType,String userId) {
    this.userId=userId;
    this.id = id;
    this.operSysType = operSysType;
  }

  public DelPaymentReq setId(String id) {
    this.id = id;
    return this;
  }

  public DelPaymentReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
