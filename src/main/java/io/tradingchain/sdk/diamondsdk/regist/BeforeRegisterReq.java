package io.tradingchain.sdk.diamondsdk.regist;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class BeforeRegisterReq {

  @ReqParam(isSgin = false,nullable = false, comment = "签名key")
  public String apiKey;

  public BeforeRegisterReq(String apiKey) {
    this.apiKey = apiKey;
  }

  public BeforeRegisterReq() {
  }

  public BeforeRegisterReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }
}
