package io.tradingchain.sdk.diamondsdk.exchangeRate;

import io.tradingchain.sdk.diamondsdk.trustAsset.AssetPair;

import java.util.List;

public class ExchangeReq {
  public String baseAsset;
  public String baseAssetIssuer;
  public String counterAsset;
  public String counterAssetIssuer;
  public int size;
  public String apiKey;
  public String username;
  public String privateKey;
  public List<AssetPair> list;
  public String operSysType;
  public String platform;

  public ExchangeReq() {
  }

  public ExchangeReq(String baseAsset, String baseAssetIssuer, String counterAsset,
                     String counterAssetIssuer, int size, String apiKey, String username,
                     String privateKey, List<AssetPair> list, String operSysType) {
    this.baseAsset = baseAsset;
    this.baseAssetIssuer = baseAssetIssuer;
    this.counterAsset = counterAsset;
    this.counterAssetIssuer = counterAssetIssuer;
    this.size = size;
    this.apiKey = apiKey;
    this.username = username;
    this.privateKey = privateKey;
    this.list = list;
    this.operSysType = operSysType;
  }

  public ExchangeReq setBaseAsset(String baseAsset) {
    this.baseAsset = baseAsset;
    return this;
  }

  public ExchangeReq setBaseAssetIssuer(String baseAssetIssuer) {
    this.baseAssetIssuer = baseAssetIssuer;
    return this;
  }

  public ExchangeReq setCounterAsset(String counterAsset) {
    this.counterAsset = counterAsset;
    return this;
  }

  public ExchangeReq setCounterAssetIssuer(String counterAssetIssuer) {
    this.counterAssetIssuer = counterAssetIssuer;
    return this;
  }

  public ExchangeReq setSize(int size) {
    this.size = size;
    return this;
  }

  public ExchangeReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }

  public ExchangeReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public ExchangeReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public ExchangeReq setList(
          List<AssetPair> list) {
    this.list = list;
    return this;
  }

  public ExchangeReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
