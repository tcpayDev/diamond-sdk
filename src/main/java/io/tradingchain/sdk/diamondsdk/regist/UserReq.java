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

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public void setLoginPass(String loginPass) {
    this.loginPass = loginPass;
  }

  public void setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
  }

  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }

  public void setExUserId(String exUserId) {
    this.exUserId = exUserId;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public void setInviteCode(String inviteCode) {
    this.inviteCode = inviteCode;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setOperSysType(String operSysType) {
    this.operSysType = operSysType;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
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
