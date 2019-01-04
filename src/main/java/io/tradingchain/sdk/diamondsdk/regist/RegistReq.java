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

  @Override
  public String toString() {
    return "RegistReq{" +
        "phone='" + phone + '\'' +
        ", inviteCode='" + inviteCode + '\'' +
        ", tradePassword='" + tradePassword + '\'' +
        ", privateKey='" + privateKey + '\'' +
        ", backupKey='" + backupKey + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", platform='" + platform + '\'' +
        ", apiKey='" + apiKey + '\'' +
        '}';
  }
}
