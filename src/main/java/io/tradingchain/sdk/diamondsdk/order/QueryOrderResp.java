package io.tradingchain.sdk.diamondsdk.order;

import java.math.BigDecimal;
import java.util.Date;

public class QueryOrderResp {
  public String resCode;
  public String resMsg;

  public FiatTradeOrder fiatTradeOrder;


  public static class FiatTradeOrder{
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
    public Long overtime;
    public Long cancelTime;
    public Long createTime;
    public String fee;
    public String payMode;
    public String amount;


    @Override
    public String toString() {
      return "FiatTradeOrder{" +
          "orderNo='" + orderNo + '\'' +
          ", assetCode='" + assetCode + '\'' +
          ", sellerId='" + sellerId + '\'' +
          ", sellerNickName='" + sellerNickName + '\'' +
          ", sellerUserCategory='" + sellerUserCategory + '\'' +
          ", buyerId='" + buyerId + '\'' +
          ", buyerNickName='" + buyerNickName + '\'' +
          ", buyerUserCategory='" + buyerUserCategory + '\'' +
          ", quantity=" + quantity +
          ", price=" + price +
          ", offerOrderNo='" + offerOrderNo + '\'' +
          ", status=" + status +
          ", overtime=" + overtime +
          ", cancelTime=" + cancelTime +
          ", createTime=" + createTime +
          ", rate=" + fee +
          ", payMode='" + payMode + '\'' +
          ", amount='" + amount + '\'' +
          '}';
    }
  }

  @Override
  public String toString() {
    return "QueryOrderResp{" +
        "resCode='" + resCode + '\'' +
        ", resMsg='" + resMsg + '\'' +
        ", fiatTradeOrder=" + fiatTradeOrder +
        '}';
  }
}
