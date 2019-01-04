package io.tradingchain.sdk.diamondsdk.regist;

public class UserReq {
  public String mobile;
  public String loginPass;
  public String tradePassword;
  public String privateKey;
  public String exUserId;
  public String publicKey;
  public String inviteCode;
  public String idCard;
  public String userName;
  public String operSysType;
  public String nickName;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

  @Override
  public String toString() {
    return "UserReq{" +
        "mobile='" + mobile + '\'' +
        ", loginPass='" + loginPass + '\'' +
        ", tradePassword='" + tradePassword + '\'' +
        ", privateKey='" + privateKey + '\'' +
        ", exUserId='" + exUserId + '\'' +
        ", publicKey='" + publicKey + '\'' +
        ", inviteCode='" + inviteCode + '\'' +
        ", idCard='" + idCard + '\'' +
        ", userName='" + userName + '\'' +
        ", operSysType='" + operSysType + '\'' +
        ", version='" + version + '\'' +
        ", accessToken='" + accessToken + '\'' +
        '}';
  }
}
