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
  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";
  @ReqParam(isSgin = false,nullable = false, comment = "操作系统")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public void setUnitPrice(String unitPrice) {
    this.unitPrice = unitPrice;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
  }

  public void setMinPrice(String minPrice) {
    this.minPrice = minPrice;
  }

  public void setMaxPrice(String maxPrice) {
    this.maxPrice = maxPrice;
  }

  public void setPostType(String postType) {
    this.postType = postType;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public void setOperSysType(String operSysType) {
    this.operSysType = operSysType;
  }

  public void setVersion(String version) {
    this.version = version;
  }
}
