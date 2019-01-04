package io.tradingchain.sdk.diamondsdk.regist;

public class UserResp {
  public String resCode;
  public String resMsg;
  public String userId;

  @Override
  public String toString() {
    return "UserResp{" +
        "resCode='" + resCode + '\'' +
        ", resMsg='" + resMsg + '\'' +
        ", userId='" + userId + '\'' +
        '}';
  }
}
