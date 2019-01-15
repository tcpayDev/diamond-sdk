package io.tradingchain.sdk.diamondsdk.user;

public class UserInfoResp {
  public String userName;          //用户名
  public String userAddress;       //用户的公钥
  public String password;          //登陆密码
  public String tradePassword;     //交易密码
  public String privateKey;        //用户私钥1
  public String assetCode;         //钻石币币种名称
  public String assetIssuer;       //钻石币币种发行人
  public String apiKey;            //签名公钥
  public String timeStamp;         //时间戳
  public String sign;              //签名
}
