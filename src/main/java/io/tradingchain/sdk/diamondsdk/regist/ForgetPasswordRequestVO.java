package io.tradingchain.sdk.diamondsdk.regist;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class ForgetPasswordRequestVO {
  @ReqParam(isSgin = false,nullable = false, comment = "用户名")
  public String username;
  @ReqParam(isSgin = false,nullable = false, comment = "密码")
  public String password;
  @ReqParam(isSgin = false,nullable = false, comment = "平台标识")
  public String platform;
  @ReqParam(isSgin = false,nullable = false, comment = "签名公钥")
  public String apiKey;
  @ReqParam(isSgin = false,nullable = false, comment = "修改密码类型")
  public String type;


  public ForgetPasswordRequestVO(String username, String password, String platform,
      String apiKey, String type) {
    this.username = username;
    this.password = password;
    this.platform = platform;
    this.apiKey = apiKey;
    this.type = type;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getPlatform() {
    return platform;
  }

  public String getApiKey() {
    return apiKey;
  }

  public String getType() {
    return type;
  }
}
