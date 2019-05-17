package io.tradingchain.sdk.diamondsdk.order;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class ConfirmPayReq {
  @ReqParam(isSgin = true,nullable = false, comment = "订单号")
  public String orderNo;
  @ReqParam(isSgin = true,nullable = false, comment = "支付方式")
  public String payMode;
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public ConfirmPayReq setVersion(String version) {
    this.version = version;
    return this;
  }

  public ConfirmPayReq setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
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
