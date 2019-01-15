package io.tradingchain.sdk.diamondsdk.user;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class UserInfoReqVO {
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String apiKey;
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String timeStamp;

}
