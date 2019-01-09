package io.tradingchain.sdk.diamondsdk.exchangeRate;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class ExchangeRateReq {
  @ReqParam(isSgin = false,nullable = false, comment = "基础币种")
  public String baseAsset;
  @ReqParam(isSgin = false,nullable = false, comment = "币种发行人")
  public String baseAssetIssuer;
  @ReqParam(isSgin = false,nullable = false, comment = "计价币种")
  public String counterAsset;
  @ReqParam(isSgin = false,nullable = false, comment = "币种发行人")
  public String counterAssetIssuer;
  @ReqParam(isSgin = false,nullable = false, comment = "签名 不需要传值",userset = false)
  public String  sign;
  @ReqParam(isSgin = false,nullable = false, comment = "size")
  public int size;
  @ReqParam(isSgin = false,nullable = false, comment = "签名key")
  public String  apiKey;
  @ReqParam(isSgin = false,nullable = false, comment = "标识")
  public String platform;

  public ExchangeRateReq() {
  }

  public ExchangeRateReq(String baseAsset, String baseAssetIssuer, String counterAsset,
      String counterAssetIssuer, int size, String apiKey) {
    this.baseAsset = baseAsset;
    this.baseAssetIssuer = baseAssetIssuer;
    this.counterAsset = counterAsset;
    this.counterAssetIssuer = counterAssetIssuer;
    this.size = size;
    this.apiKey = apiKey;
  }

  public ExchangeRateReq setBaseAsset(String baseAsset) {
    this.baseAsset = baseAsset;
    return this;
  }

  public ExchangeRateReq setBaseAssetIssuer(String baseAssetIssuer) {
    this.baseAssetIssuer = baseAssetIssuer;
    return this;
  }

  public ExchangeRateReq setCounterAsset(String counterAsset) {
    this.counterAsset = counterAsset;
    return this;
  }

  public ExchangeRateReq setCounterAssetIssuer(String counterAssetIssuer) {
    this.counterAssetIssuer = counterAssetIssuer;
    return this;
  }

  public ExchangeRateReq setSize(int size) {
    this.size = size;
    return this;
  }

  public ExchangeRateReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
