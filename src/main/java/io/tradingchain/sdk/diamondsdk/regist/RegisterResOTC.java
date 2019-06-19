package io.tradingchain.sdk.diamondsdk.regist;


import io.tradingchain.sdk.diamondsdk.response.BaseRes;

public class RegisterResOTC extends BaseRes {

  public String publicKey;
  public String privateKey;
  public String backupKey;
  public String userId;
  public String inviteCode;
  public String username;
  public String platform;

  public RegisterResOTC() {
  }

  public RegisterResOTC(String publicKey, String privateKey, String backupKey,
      String userId, String inviteCode, String username, String platform) {
    this.publicKey = publicKey;
    this.privateKey = privateKey;
    this.backupKey = backupKey;
    this.userId = userId;
    this.inviteCode = inviteCode;
    this.username = username;
    this.platform = platform;
  }



  public RegisterResOTC(RegisterRes res, UserResp user) {
    this.code = res.code;
    this.msg = res.msg;
    this.backupKey = res.data.backupKey;
    this.inviteCode = res.data.inviteCode;
    this.privateKey = res.data.privateKey;
    this.publicKey = res.data.publicKey;
    this.userId = user.userId;
  }

  public RegisterResOTC(String msg) {
    this.code = 2002;
    this.msg = msg;
  }

  public RegisterResOTC(String msg, String username, String platform) {
    this.username=username;
    this.platform=platform;
    this.code = 2002;
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "RegisterResOTC{" +
        "publicKey='" + publicKey + '\'' +
        ", privateKey='" + privateKey + '\'' +
        ", backupKey='" + backupKey + '\'' +
        ", userId='" + userId + '\'' +
        ", inviteCode='" + inviteCode + '\'' +
        ", username='" + username + '\'' +
        ", platform='" + platform + '\'' +
        '}';
  }
}
