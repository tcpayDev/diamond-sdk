package io.tradingchain.sdk.diamondsdk.user;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class UserInfoReqVO {
  @ReqParam(isSgin = false,nullable = false, comment = "用户id")
  public String userId;

}
