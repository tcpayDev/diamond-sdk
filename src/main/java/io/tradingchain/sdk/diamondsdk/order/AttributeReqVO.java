package io.tradingchain.sdk.diamondsdk.order;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

public class AttributeReqVO {

//  @ReqParam(isSgin = true,nullable = false, comment = "备注")
//  public String attribute1;
//  @ReqParam(isSgin = true,nullable = false, comment = "订单号")
//  public String orderNo;
//  @ReqParam(isSgin = false,nullable = false, comment = "操作系统")
//  public String operSysType;
//  @ReqParam(isSgin = false,nullable = false, comment = "版本")
//  public String version = "1.0.0";
//  @ReqParam(isSgin = true,nullable = false, comment = "token")
//  public String accessToken = System.currentTimeMillis()+"";



  @ReqParam(isSgin = true,nullable = false, comment = "备注")
  public String unitPrice;
  @ReqParam(isSgin = true,nullable = false, comment = "订单号")
  public String amount;
  @ReqParam(isSgin = true,nullable = false, comment = "操作系统")
  public String totalPrice;
  @ReqParam(isSgin = true,nullable = false, comment = "版本")
  public String minPrice = "1.0.0";
  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String maxPrice = System.currentTimeMillis()+"";
  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String postType = System.currentTimeMillis()+"";
  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String currency = System.currentTimeMillis()+"";
  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String userId = System.currentTimeMillis()+"";

  public AttributeReqVO setUnitPrice(String unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

  public AttributeReqVO setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public AttributeReqVO setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

  public AttributeReqVO setMinPrice(String minPrice) {
    this.minPrice = minPrice;
    return this;
  }

  public AttributeReqVO setMaxPrice(String maxPrice) {
    this.maxPrice = maxPrice;
    return this;
  }

  public AttributeReqVO setPostType(String postType) {
    this.postType = postType;
    return this;
  }

  public AttributeReqVO setCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public AttributeReqVO setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public AttributeReqVO setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  public AttributeReqVO setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }

  public AttributeReqVO setVersion(String version) {
    this.version = version;
    return this;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";
  @ReqParam(isSgin = false,nullable = false, comment = "操作系统")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";
}
