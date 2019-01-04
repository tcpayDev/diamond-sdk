package io.tradingchain.sdk.diamondsdk.exchangeRate;

import io.tradingchain.sdk.diamondsdk.response.BaseRes;
import java.math.BigDecimal;

public class OrderBookRes extends BaseRes{
  public Long time;
  public BigDecimal[][] asks;
  public BigDecimal[][] bids;

}
