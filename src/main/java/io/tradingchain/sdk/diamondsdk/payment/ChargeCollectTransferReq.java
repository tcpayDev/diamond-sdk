package io.tradingchain.sdk.diamondsdk.payment;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class ChargeCollectTransferReq {
  @ReqParam(isSgin = false,nullable = false, comment = "用户名")
  public String username;
  @ReqParam(isSgin = false,nullable = false, comment = "用户交易密码")
  public String tradePassword;
  @ReqParam(isSgin = false,nullable = true, comment = "用户私钥,与privateKey二选一")
  public String privateKey;
  @ReqParam(isSgin = false,nullable = true, comment = "用户私钥,与backupKey二选一")
  public String backupKey;
  @ReqParam(isSgin = false,nullable = false, comment = "资产数量")
  public String amount;
  @ReqParam(isSgin = false,nullable = false, comment = "资产名称")
  public String assetName;
  @ReqParam(isSgin = false,nullable = false, comment = "资产发行者")
  public String assetIssuer;
  @ReqParam(isSgin = false,nullable = false, comment = "对方帐户")
  public String destination;
  @ReqParam(isSgin = false,nullable = false, comment = "标识")
  public String platform;
  @ReqParam(isSgin = false,nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(isSgin = false,nullable = false, comment = "公钥")
  public String apiKey;

  private ChargeCollectTransferReq(String platform,String apiKey,String username, String tradePassword, String privateKey, String backupKey, String amount, String assetName, String assetIssuer, String destination) {
    this.username = username;
    this.tradePassword = tradePassword;
    this.privateKey = privateKey;
    this.backupKey = backupKey;
    this.amount = amount;
    this.assetName = assetName;
    this.assetIssuer = assetIssuer;
    this.destination = destination;
    this.apiKey=apiKey;
    this.platform=platform;
  }

  public static final ChargeCollectTransferReq getInstanceByPrivateKey(String platform,String apiKey,String username, String tradePassword, String privateKey, String amount, String assetName, String assetIssuer, String destination) {
    return new ChargeCollectTransferReq(platform,apiKey,username, tradePassword, privateKey, null, amount, assetName, assetIssuer, destination);
  }

  public static final ChargeCollectTransferReq getInstanceByBackupKey(String platform,String apiKey,String username, String tradePassword, String backupKey, String amount, String assetName, String assetIssuer, String destination) {
    return new ChargeCollectTransferReq(platform,apiKey,username, tradePassword, null, backupKey, amount, assetName, assetIssuer, destination);
  }

  public ChargeCollectTransferReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public ChargeCollectTransferReq setTradePassword(String tradePassword) {
    this.tradePassword = tradePassword;
    return this;
  }

  public ChargeCollectTransferReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public ChargeCollectTransferReq setBackupKey(String backupKey) {
    this.backupKey = backupKey;
    return this;
  }

  public ChargeCollectTransferReq setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public ChargeCollectTransferReq setAssetName(String assetName) {
    this.assetName = assetName;
    return this;
  }

  public ChargeCollectTransferReq setAssetIssuer(String assetIssuer) {
    this.assetIssuer = assetIssuer;
    return this;
  }

  public ChargeCollectTransferReq setDestination(String destination) {
    this.destination = destination;
    return this;
  }

  public ChargeCollectTransferReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public ChargeCollectTransferReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public ChargeCollectTransferReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
