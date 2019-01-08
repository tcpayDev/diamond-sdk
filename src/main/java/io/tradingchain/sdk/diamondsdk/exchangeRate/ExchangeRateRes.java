package io.tradingchain.sdk.diamondsdk.exchangeRate;

import io.tradingchain.sdk.diamondsdk.response.BaseVO;

public class ExchangeRateRes extends BaseVO {

  public String rateBuy;          //钻石币-USDT 的汇率 买
  public String rateSell;         //钻石币-USDT 的汇率 卖
  public String exchangeRateBuy;  //钻石币-RMB  的汇率 买
  public String exchangeRateSell; //钻石币-RMB  的汇率 卖


  public ExchangeRateRes(String rateBuy, String rateSell, String exchangeRateBuy,
      String exchangeRateSell) {
    this.resCode = "C502570000000";
    this.resMsg = "ok";
    this.rateBuy = rateBuy;
    this.rateSell = rateSell;
    this.exchangeRateBuy = exchangeRateBuy;
    this.exchangeRateSell = exchangeRateSell;
  }

  public ExchangeRateRes(String code, String msg) {
    this.resCode = code;
    this.resMsg = msg;
  }

  @Override
  public String toString() {
    return "ExchangeRateRes{" +
        "exchangeRateBuy='" + exchangeRateBuy + '\'' +
        ", exchangeRateSell='" + exchangeRateSell + '\'' +
        '}';
  }
}
