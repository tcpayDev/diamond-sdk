package io.tradingchain.sdk.diamondsdk.order;

import java.math.BigDecimal;

public class QueryOrderReq {
  public String userId;
  public String orderNo;
  public String operSysType;    //操作系统: 1：安卓2：IOS
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";
}
