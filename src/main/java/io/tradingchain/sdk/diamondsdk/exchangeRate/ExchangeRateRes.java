package io.tradingchain.sdk.diamondsdk.exchangeRate;

import io.tradingchain.sdk.diamondsdk.response.BaseRes;
import java.math.BigDecimal;

public class ExchangeRateRes extends BaseRes{
  public String exchangeRateBuy;
  public String exchangeRateSell;


  public ExchangeRateRes(String exchangeRateBuy, String exchangeRateSell) {
    this.exchangeRateBuy = exchangeRateBuy;
    this.exchangeRateSell = exchangeRateSell;
  }
}
