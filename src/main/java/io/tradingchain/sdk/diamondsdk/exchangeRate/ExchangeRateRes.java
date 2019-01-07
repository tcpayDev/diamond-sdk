package io.tradingchain.sdk.diamondsdk.exchangeRate;

import io.tradingchain.sdk.diamondsdk.response.BaseVO;

public class ExchangeRateRes extends BaseVO{
  public String exchangeRateBuy;
  public String exchangeRateSell;


  public ExchangeRateRes(String exchangeRateBuy, String exchangeRateSell) {
    this.resCode="C502570000000";
    this.resMsg="ok";
    this.exchangeRateBuy = exchangeRateBuy;
    this.exchangeRateSell = exchangeRateSell;
  }

  public ExchangeRateRes(String exchangeRateBuy, String exchangeRateSell,String code, String msg) {
    this.resCode=code;
    this.resMsg=msg;
    this.exchangeRateBuy = exchangeRateBuy;
    this.exchangeRateSell = exchangeRateSell;
  }

  @Override
  public String toString() {
    return "ExchangeRateRes{" +
        "exchangeRateBuy='" + exchangeRateBuy + '\'' +
        ", exchangeRateSell='" + exchangeRateSell + '\'' +
        '}';
  }
}
