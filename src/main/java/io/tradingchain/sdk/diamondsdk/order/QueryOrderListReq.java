package io.tradingchain.sdk.diamondsdk.order;

public class QueryOrderListReq {
  public int page;
  public int pageSize;
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

  public QueryOrderListReq(int page, int pageSize, String userId, String operSysType) {
    this.page = page;
    this.pageSize = pageSize;
    this.userId = userId;
    this.operSysType = operSysType;
  }

  public QueryOrderListReq setPage(int page) {
    this.page = page;
    return this;
  }

  public QueryOrderListReq setPageSize(int pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  public QueryOrderListReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public QueryOrderListReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
