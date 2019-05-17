package io.tradingchain.sdk.diamondsdk.order;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;
import java.io.File;

public class FiatTradeAppealReq {
  @ReqParam(isSgin = true,nullable = false, comment = "订单号")
  public String orderNo;
  @ReqParam(isSgin = false,nullable = false, comment = "申诉详情")
  public String appealRemark;
  @ReqParam(isSgin = false,nullable = false, comment = "文件")
  public File appealFile;
  @ReqParam(isSgin = false,nullable = false, comment = "申诉理由")
  public String appealReason;
  @ReqParam(isSgin = false,nullable = false, comment = "联系方式")
  public String contact;
  @ReqParam(isSgin = true,nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = false,nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = false,nullable = false, comment = "版本")
  public String version = "1.0.0";

  public void setVersion(String version) {
    this.version = version;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  @ReqParam(isSgin = true,nullable = false, comment = "token")
  public String accessToken = System.currentTimeMillis()+"";

  public FiatTradeAppealReq(String orderNo, String appealRemark, File appealFile,
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

  public FiatTradeAppealReq setAppealFile(File appealFile) {
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
