package io.tradingchain.sdk.diamondsdk.regist;


public class RegistReq {
  public String phone;
  public String inviteCode;
  public String tradePassword;
  public String privateKey;
  public String backupKey;
  public String username;
  public String password;
  public String platform;
  public String apiKey;

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
