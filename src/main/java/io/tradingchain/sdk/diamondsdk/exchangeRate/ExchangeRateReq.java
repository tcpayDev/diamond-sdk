package io.tradingchain.sdk.diamondsdk.exchangeRate;

public class ExchangeRateReq {
  public String baseAsset;
  public String baseAssetIssuer;
  public String counterAsset;
  public String counterAssetIssuer;
  public String  sign;
  public int size;
  public String  apiKey;


  public ExchangeRateReq(String baseAsset, String baseAssetIssuer, String counterAsset,
      String counterAssetIssuer, String sign, int size, String apiKey) {
    this.baseAsset = baseAsset;
    this.baseAssetIssuer = baseAssetIssuer;
    this.counterAsset = counterAsset;
    this.counterAssetIssuer = counterAssetIssuer;
    this.sign = sign;
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

  public ExchangeRateReq setSign(String sign) {
    this.sign = sign;
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
