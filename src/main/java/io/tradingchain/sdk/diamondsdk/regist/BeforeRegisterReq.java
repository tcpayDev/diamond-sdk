package io.tradingchain.sdk.diamondsdk.regist;

public class BeforeRegisterReq {
  public String apiKey;


  public BeforeRegisterReq(String apiKey) {
    this.apiKey = apiKey;
  }

  public BeforeRegisterReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
