package io.tradingchain.sdk.diamondsdk.regist;

public class QueryUserResp {
  public String resCode;
  public String resMsg;
  public String userId;
  public String userStatus;

  @Override
  public String toString() {
    return "QueryUserResp{" +
        "resCode='" + resCode + '\'' +
        ", resMsg='" + resMsg + '\'' +
        ", userId='" + userId + '\'' +
        ", userStatus='" + userStatus + '\'' +
        '}';
  }
}
