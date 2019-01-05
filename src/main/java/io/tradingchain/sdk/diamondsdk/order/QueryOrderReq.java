package io.tradingchain.sdk.diamondsdk.order;

import java.math.BigDecimal;

public class QueryOrderReq {
  public String userId;
  public String orderNo;
  public String operSysType;    //操作系统: 1：安卓2：IOS
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

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
