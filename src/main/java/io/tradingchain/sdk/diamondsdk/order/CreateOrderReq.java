package io.tradingchain.sdk.diamondsdk.order;

public class CreateOrderReq {
  public String offerOrderNo;
  public String quantity;
  public String price;
  public String amount;
  public String type;
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

  public CreateOrderReq(String offerOrderNo, String quantity, String price, String amount,
      String type, String userId, String operSysType) {
    this.offerOrderNo = offerOrderNo;
    this.quantity = quantity;
    this.price = price;
    this.amount = amount;
    this.type = type;
    this.userId = userId;
    this.operSysType = operSysType;
  }

  public CreateOrderReq setOfferOrderNo(String offerOrderNo) {
    this.offerOrderNo = offerOrderNo;
    return this;
  }

  public CreateOrderReq setQuantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

  public CreateOrderReq setPrice(String price) {
    this.price = price;
    return this;
  }

  public CreateOrderReq setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public CreateOrderReq setType(String type) {
    this.type = type;
    return this;
  }

  public CreateOrderReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public CreateOrderReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
