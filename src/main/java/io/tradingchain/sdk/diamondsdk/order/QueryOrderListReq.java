package io.tradingchain.sdk.diamondsdk.order;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class QueryOrderListReq {
  @ReqParam(isSgin = false,nullable = false, comment = "page")
  public int page;
  @ReqParam(isSgin = false,nullable = false, comment = "pageSize")
  public int pageSize;
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";
  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";

  public QueryOrderListReq() {
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

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
