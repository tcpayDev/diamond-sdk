package io.tradingchain.sdk.diamondsdk.regist;


import io.tradingchain.sdk.diamondsdk.response.BaseVO;

public class SdkRegisterResOTC extends BaseVO {

    public String publicKey;
    public String privateKey;
    public String backupKey;
    public String userId;
    public String inviteCode;

  public SdkRegisterResOTC(RegisterResOTC resOTC) {
    this.resCode="C502570000000";
    this.resMsg="ok";
    this.publicKey=resOTC.publicKey;
    this.privateKey=resOTC.privateKey;
    this.backupKey=resOTC.backupKey;
    this.userId=resOTC.userId;
    this.inviteCode=resOTC.inviteCode;

  }
}
