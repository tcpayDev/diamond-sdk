package io.tradingchain.sdk.diamondsdk.exchangeRate;

import io.tradingchain.sdk.diamondsdk.response.BaseVO;
import java.math.BigDecimal;

public class ExchangeOTCRateRes extends BaseVO{
  public BigDecimal buyRate;
  public BigDecimal sellRate;

}
