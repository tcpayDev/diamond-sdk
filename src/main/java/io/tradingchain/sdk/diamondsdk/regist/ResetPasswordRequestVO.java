package io.tradingchain.sdk.diamondsdk.regist;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class ResetPasswordRequestVO {
  @ReqParam(isSgin = false,nullable = false, comment = "用户名")
  public String username;
  @ReqParam(isSgin = false,nullable = false, comment = "平台标识")
  public String platform;
  @ReqParam(isSgin = false,nullable = false, comment = "签名公钥")
  public String apiKey;
  @ReqParam(isSgin = false,nullable = false, comment = "修改密码类型")
  public String type;
  @ReqParam(isSgin = false,nullable = false, comment = "修改密码类型")
  public String password;
  @ReqParam(isSgin = false,nullable = false, comment = "新的密码")
  public String newPassword;

  public ResetPasswordRequestVO(String username, String platform, String apiKey,
      String type, String password,String newPassword) {
    this.username = username;
    this.platform = platform;
    this.apiKey = apiKey;
    this.type = type;
    this.password=password;
    this.newPassword = newPassword;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
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

  public String getNewPassword() {
    return newPassword;
  }
}
