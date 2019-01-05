package io.tradingchain.sdk.diamondsdk.regist;


import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class RegistReq {
  @ReqParam(isSgin = false,nullable = false, comment = "手机号码")
  public String phone;
  @ReqParam(isSgin = false,nullable = false, comment = "邀请码",userset = false)
  public String inviteCode;
  @ReqParam(isSgin = false,nullable = false, comment = "交易密码")
  public String tradePassword;
  @ReqParam(isSgin = false,nullable = false, comment = "私钥1")
  public String privateKey;
  @ReqParam(isSgin = false,nullable = false, comment = "私钥2")
  public String backupKey;
  @ReqParam(isSgin = false,nullable = false, comment = "用户名")
  public String username;
  @ReqParam(isSgin = false,nullable = false, comment = "登陆密码")
  public String password;
  @ReqParam(isSgin = false,nullable = false, comment = "平台标识")
  public String platform;
  @ReqParam(isSgin = false,nullable = false, comment = "签名key")
  public String apiKey;

  public RegistReq() {
  }

  public RegistReq(String phone, String inviteCode, String tradePassword, String privateKey,
      String backupKey, String username, String password, String platform, String apiKey) {
    this.phone = phone;
    this.inviteCode = inviteCode;
    this.tradePassword = tradePassword;
    this.privateKey = privateKey;
    this.backupKey = backupKey;
    this.username = username;
    this.password = password;
    this.platform = platform;
    this.apiKey = apiKey;
  }

  public RegistReq setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public RegistReq setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
    return this;
  }

  public RegistReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public RegistReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public RegistReq setBackupKey(String backupKey) {
    this.backupKey = backupKey;
    return this;
  }

  public RegistReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public RegistReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public RegistReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public RegistReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
