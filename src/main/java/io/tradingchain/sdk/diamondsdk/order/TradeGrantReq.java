package io.tradingchain.sdk.diamondsdk.order;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class TradeGrantReq {
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = true,nullable = false, comment = "订单号")
  public String orderNo;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;    //操作系统: 1：安卓2：IOS
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public TradeGrantReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public TradeGrantReq setOrderNo(String orderNo) {
    this.orderNo = orderNo;
    return this;
  }

  public TradeGrantReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }

  public TradeGrantReq setVersion(String version) {
    this.version = version;
    return this;
  }

  public TradeGrantReq setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";
}
