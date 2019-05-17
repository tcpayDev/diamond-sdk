package io.tradingchain.sdk.diamondsdk.order;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class CancelOrderReq {
  @ReqParam(isSgin = true,nullable = false, comment = "订单号")
  public String orderNo;
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public CancelOrderReq setVersion(String version) {
    this.version = version;
    return this;
  }

  public CancelOrderReq setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
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
