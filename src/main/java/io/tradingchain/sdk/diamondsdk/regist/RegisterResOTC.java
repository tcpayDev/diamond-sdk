package io.tradingchain.sdk.diamondsdk.regist;


import io.tradingchain.sdk.diamondsdk.response.BaseRes;

public class RegisterResOTC extends BaseRes {

    public String publicKey;
    public String privateKey;
    public String backupKey;
    public String userId;
    public String inviteCode;

  @Override
  public String toString() {
    return "RegisterResOTC{" +
        "publicKey='" + publicKey + '\'' +
        ", privateKey='" + privateKey + '\'' +
        ", backupKey='" + backupKey + '\'' +
        ", userId='" + userId + '\'' +
        ", inviteCode='" + inviteCode + '\'' +
        '}';
  }

  public RegisterResOTC(RegisterRes res,UserResp user ) {
    this.code=res.code;
    this.msg=res.msg;
    this.backupKey=res.data.backupKey;
    this.inviteCode=res.data.inviteCode;
    this.privateKey=res.data.privateKey;
    this.publicKey=res.data.publicKey;
    this.userId=user.userId;
  }

  public RegisterResOTC(String msg) {
    this.code=2002;
    this.msg=msg;
  }
}
