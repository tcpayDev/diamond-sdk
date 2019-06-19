package io.tradingchain.sdk.diamondsdk.exchangeRate;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class ExchangeOTCRateReq {
  @ReqParam(isSgin = true,nullable = false, comment = "基础币种")
  public String assetCode;
  @ReqParam(isSgin = false,nullable = false, comment = "基础币种")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public ExchangeOTCRateReq setAssetCode(String assetCode) {
    this.assetCode = assetCode;
    return this;
  }

  public ExchangeOTCRateReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }

  public ExchangeOTCRateReq setVersion(String version) {
    this.version = version;
    return this;
  }

  public ExchangeOTCRateReq setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";
}
