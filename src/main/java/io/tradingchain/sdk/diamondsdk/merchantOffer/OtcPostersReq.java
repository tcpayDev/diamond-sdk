package io.tradingchain.sdk.diamondsdk.merchantOffer;


import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;
import java.math.BigDecimal;

public class OtcPostersReq {
  @ReqParam(isSgin = false,nullable = false, comment = "买卖方向 buy(买)/sell(卖)")
  public String tradeType;
  @ReqParam(isSgin = false,nullable = false, comment = "金额")
  public BigDecimal amount;
  @ReqParam(isSgin = false,nullable = false, comment = "支付方式 用,分割")
  public String payMode;
  @ReqParam(isSgin = false,nullable = false, comment = "币种名称 如:btc")
  public String assetCode;
  @ReqParam(isSgin = false,nullable = false, comment = "page")
  public int page;
  @ReqParam(isSgin = false,nullable = false, comment = "pageSize")
  public int pageSize;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;    //操作系统: 1：安卓2：IOS
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";
  @ReqParam(isSgin = true,nullable = false, comment = "Token")
  public String accessToken = System.currentTimeMillis()+"";

  public OtcPostersReq() {
  }

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
