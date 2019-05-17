package io.tradingchain.sdk.diamondsdk.order;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class CreateOrderReq {
  @ReqParam(isSgin = true,nullable = false, comment = "挂单订单号")
  public String offerOrderNo;
  @ReqParam(isSgin = true,nullable = false, comment = "数量")
  public String quantity;
  @ReqParam(isSgin = true,nullable = false, comment = "价格")
  public String price;
  @ReqParam(isSgin = true,nullable = false, comment = "金额")
  public String amount;
  @ReqParam(isSgin = true,nullable = false, comment = "买卖方向")
  public String type;
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public CreateOrderReq setVersion(String version) {
    this.version = version;
    return this;
  }

  public CreateOrderReq setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  public CreateOrderReq setNotifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
    return this;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";
  @ReqParam(isSgin = false,nullable = true, comment = "notifyUrl")
  public String notifyUrl;



  public CreateOrderReq() {
  }

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

  public CreateOrderReq(String offerOrderNo, String quantity, String price, String amount,
      String type, String userId, String operSysType,String notifyUrl) {
    this.offerOrderNo = offerOrderNo;
    this.quantity = quantity;
    this.price = price;
    this.amount = amount;
    this.type = type;
    this.userId = userId;
    this.operSysType = operSysType;
    this.notifyUrl=notifyUrl;
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
