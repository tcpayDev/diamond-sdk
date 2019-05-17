package io.tradingchain.sdk.diamondsdk.regist;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class UserReq {
  @ReqParam(isSgin = true,nullable = false, comment = "手机号码")
  public String mobile;
  @ReqParam(isSgin = true,nullable = false, comment = "登录密码")
  public String loginPass;
  @ReqParam(isSgin = true,nullable = false, comment = "支付密码")
  public String tradePassword;
  @ReqParam(isSgin = true,nullable = false, comment = "设备授权码")
  public String privateKey;
  @ReqParam(isSgin = true,nullable = false, comment = "交易所userid")
  public String exUserId;
  @ReqParam(isSgin = true,nullable = false, comment = "公钥")
  public String publicKey;
  @ReqParam(isSgin = true,nullable = false, comment = "交易所用户邀请码")
  public String inviteCode;
  @ReqParam(isSgin = true,nullable = false, comment = "身份证号码")
  public String idCard;
  @ReqParam(isSgin = true,nullable = false, comment = "用户姓名")
  public String userName;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = true,nullable = false, comment = "OTC交易昵称")
  public String nickName;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public UserReq setMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public UserReq setLoginPass(String loginPass) {
    this.loginPass = loginPass;
    return this;
  }

  public UserReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public UserReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public UserReq setExUserId(String exUserId) {
    this.exUserId = exUserId;
    return this;
  }

  public UserReq setPublicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

  public UserReq setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
    return this;
  }

  public UserReq setIdCard(String idCard) {
    this.idCard = idCard;
    return this;
  }

  public UserReq setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public UserReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }

  public UserReq setNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public UserReq setVersion(String version) {
    this.version = version;
    return this;
  }

  public UserReq setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  public UserReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "Token")
  public String accessToken = System.currentTimeMillis()+"";
  @ReqParam(isSgin = false,nullable = false, comment = "平台标识")
  public String platform;

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
        ", nickName='" + nickName + '\'' +
        ", version='" + version + '\'' +
        ", accessToken='" + accessToken + '\'' +
        ", platform='" + platform + '\'' +
        '}';
  }
}
