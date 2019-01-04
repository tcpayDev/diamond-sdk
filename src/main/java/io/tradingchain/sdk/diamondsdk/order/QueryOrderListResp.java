package io.tradingchain.sdk.diamondsdk.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class QueryOrderListResp {
  public String resCode;
  public String resMsg;
  public int totalSize;
  public int pageSize;

  public List<FiatTradeOrder> tradeOrderList;

  public class FiatTradeOrder{
    public String orderNo;
    public String assetCode;
    public String sellerId;
    public String sellerNickName;
    public String sellerUserCategory;
    public String buyerId;
    public String buyerNickName;
    public String buyerUserCategory;
    public BigDecimal quantity;
    public BigDecimal price;
    public String offerOrderNo;
    public int status;
    public Date overtime;
    public Date cancelTime;
    public Date createTime;
    public BigDecimal fee;
    public String payMode;
    public String amount;
  }
}
