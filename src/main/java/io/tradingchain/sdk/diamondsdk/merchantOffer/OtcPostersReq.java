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

}
