package io.tradingchain.sdk.diamondsdk.merchantOffer;


import java.math.BigDecimal;

public class OtcPostersReq {

  public String tradeType;
  public BigDecimal amount;
  public String payMode;
  public String assetCode;
  public int page;
  public int pageSize;
  public String operSysType;    //操作系统: 1：安卓2：IOS
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";


  public OtcPostersReq(String tradeType, BigDecimal amount, String payMode,
      String assetCode, int page, int pageSize, String operSysType) {
    this.tradeType = tradeType;
    this.amount = amount;
    this.payMode = payMode;
    this.assetCode = assetCode;
    this.page = page;
    this.pageSize = pageSize;
    this.operSysType = operSysType;
  }

  public OtcPostersReq setTradeType(String tradeType) {
    this.tradeType = tradeType;
    return this;
  }

  public OtcPostersReq setAmount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  public OtcPostersReq setPayMode(String payMode) {
    this.payMode = payMode;
    return this;
  }

  public OtcPostersReq setAssetCode(String assetCode) {
    this.assetCode = assetCode;
    return this;
  }

  public OtcPostersReq setPage(int page) {
    this.page = page;
    return this;
  }

  public OtcPostersReq setPageSize(int pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  public OtcPostersReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }

  public OtcPostersReq setVersion(String version) {
    this.version = version;
    return this;
  }

  public OtcPostersReq setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }
}
