package io.tradingchain.sdk.diamondsdk.order;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class QueryOrderReq {
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = false,nullable = false, comment = "订单号")
  public String orderNo;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;    //操作系统: 1：安卓2：IOS
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";
  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";

  public QueryOrderReq() {
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public QueryOrderReq(String userId, String orderNo, String operSysType) {
    this.userId = userId;
    this.orderNo = orderNo;
    this.operSysType = operSysType;
  }

  public QueryOrderReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public QueryOrderReq setOrderNo(String orderNo) {
    this.orderNo = orderNo;
    return this;
  }

  public QueryOrderReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
