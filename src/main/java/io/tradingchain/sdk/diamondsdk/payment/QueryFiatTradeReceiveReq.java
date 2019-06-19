package io.tradingchain.sdk.diamondsdk.payment;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class QueryFiatTradeReceiveReq {
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = true,nullable = false, comment = "支付方式")
  public String payMode;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public QueryFiatTradeReceiveReq setVersion(String version) {
    this.version = version;
    return this;
  }

  public QueryFiatTradeReceiveReq setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";

  public QueryFiatTradeReceiveReq() {
  }

  public QueryFiatTradeReceiveReq(String userId, String payMode, String operSysType) {
    this.userId = userId;
    this.payMode = payMode;
    this.operSysType = operSysType;
  }

  public QueryFiatTradeReceiveReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public QueryFiatTradeReceiveReq setPayMode(String payMode) {
    this.payMode = payMode;
    return this;
  }

  public QueryFiatTradeReceiveReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
