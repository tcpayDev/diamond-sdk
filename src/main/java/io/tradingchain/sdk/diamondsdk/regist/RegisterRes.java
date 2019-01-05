package io.tradingchain.sdk.diamondsdk.regist;


import io.tradingchain.sdk.diamondsdk.response.BaseRes;

public class RegisterRes extends BaseRes {
  public Data data;

  public class Data{
    public String publicKey;
    public String privateKey;
    public String backupKey;
    public Long userId;
    public String inviteCode;
  }

}
