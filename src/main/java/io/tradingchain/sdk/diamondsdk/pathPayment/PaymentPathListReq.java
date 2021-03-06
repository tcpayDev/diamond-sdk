package io.tradingchain.sdk.diamondsdk.pathPayment;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class PaymentPathListReq {
  @ReqParam(isSgin = false,nullable = false, comment = "用户名")
  public String username;
  @ReqParam(isSgin = false,nullable = false, comment = "用户密码")
  public String password;
  @ReqParam(isSgin = false,nullable = false, comment = "资产数量")
  public String amount;
  @ReqParam(isSgin = false,nullable = false, comment = "资产名称")
  public String assetName;
  @ReqParam(isSgin = false,nullable = false, comment = "资产发行者")
  public String assetIssuer;
  @ReqParam(isSgin = false,nullable = false, comment = "接收方帐户")
  public String destination;
  @ReqParam(isSgin = false,nullable = false, comment = "标识")
  public String platform;
  @ReqParam(isSgin = false,nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(isSgin = false,nullable = false, comment = "公钥")
  public String apiKey;

  public PaymentPathListReq(String apiKey,String platform,String username, String password, String amount, String assetName, String assetIssuer, String destination) {
    this.username = username;
    this.password = password;
    this.amount = amount;
    this.assetName = assetName;
    this.assetIssuer = assetIssuer;
    this.destination = destination;
    this.apiKey=apiKey;
    this.platform=platform;
  }

  public String getPlatform() {
    return platform;
  }

  public String getApiKey() {
    return apiKey;
  }

  public PaymentPathListReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public PaymentPathListReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public PaymentPathListReq setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public PaymentPathListReq setAssetName(String assetName) {
    this.assetName = assetName;
    return this;
  }

  public PaymentPathListReq setAssetIssuer(String assetIssuer) {
    this.assetIssuer = assetIssuer;
    return this;
  }

  public PaymentPathListReq setDestination(String destination) {
    this.destination = destination;
    return this;
  }

  public PaymentPathListReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public PaymentPathListReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public PaymentPathListReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
