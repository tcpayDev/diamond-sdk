package io.tradingchain.sdk.diamondsdk.order;

public class FiatTradeAppealReq {
  public String orderNo;
  public String appealRemark;
  public String appealFile;
  public String appealReason;
  public String contact;
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"";

  public FiatTradeAppealReq(String orderNo, String appealRemark, String appealFile,
      String appealReason, String contact, String userId, String operSysType) {
    this.orderNo = orderNo;
    this.appealRemark = appealRemark;
    this.appealFile = appealFile;
    this.appealReason = appealReason;
    this.contact = contact;
    this.userId = userId;
    this.operSysType = operSysType;
  }

  public FiatTradeAppealReq setOrderNo(String orderNo) {
    this.orderNo = orderNo;
    return this;
  }

  public FiatTradeAppealReq setAppealRemark(String appealRemark) {
    this.appealRemark = appealRemark;
    return this;
  }

  public FiatTradeAppealReq setAppealFile(String appealFile) {
    this.appealFile = appealFile;
    return this;
  }

  public FiatTradeAppealReq setAppealReason(String appealReason) {
    this.appealReason = appealReason;
    return this;
  }

  public FiatTradeAppealReq setContact(String contact) {
    this.contact = contact;
    return this;
  }

  public FiatTradeAppealReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public FiatTradeAppealReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
