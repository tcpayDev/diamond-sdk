package io.tradingchain.sdk.diamondsdk.order;

public class QueryOrderListReq {
  public int page;
  public int pageSize;
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";
}
