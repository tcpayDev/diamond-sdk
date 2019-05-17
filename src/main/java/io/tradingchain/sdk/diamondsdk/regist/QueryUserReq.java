package io.tradingchain.sdk.diamondsdk.regist;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class QueryUserReq {
  @ReqParam(isSgin = true,nullable = false, comment = "手机号码")
  public String mobile;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓; 2: IOS")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本号 1.0.0")
  public String version = "1.0.0";

  public void setVersion(String version) {
    this.version = version;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public void setPlatfomr(String platfomr) {
    this.platfomr = platfomr;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";
  @ReqParam(isSgin = false,nullable = true, comment = "token")
  public String platfomr;

  public QueryUserReq() {
  }

  public QueryUserReq(String mobile, String operSysType) {
    this.mobile = mobile;
    this.operSysType = operSysType;
  }

  public QueryUserReq(String mobile, String operSysType,String platfomr) {
    this.mobile = mobile;
    this.operSysType = operSysType;
    this.platfomr=platfomr;
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
