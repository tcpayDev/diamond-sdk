package io.tradingchain.sdk.diamondsdk.regist;

public class QueryUserReq {
  public String mobile;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

  public QueryUserReq() {
  }

  public QueryUserReq(String mobile, String operSysType) {
    this.mobile = mobile;
    this.operSysType = operSysType;
  }

  public QueryUserReq setMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public QueryUserReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
