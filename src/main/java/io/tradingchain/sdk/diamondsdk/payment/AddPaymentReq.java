package io.tradingchain.sdk.diamondsdk.payment;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;

import java.io.File;

public class AddPaymentReq {
  @ReqParam(isSgin = true, nullable = false, comment = "收款方式")
  public String receiveType;
  @ReqParam(isSgin = true, nullable = false, comment = "姓名")
  public String name;
  @ReqParam(isSgin = true, nullable = false, comment = "账号")
  public String accountNo;
  @ReqParam(isSgin = false, nullable = true, comment = "银行名称")
  public String bankName;
  @ReqParam(isSgin = false, nullable = true, comment = "开户行地址")
  public String bankAddr;
  @ReqParam(isSgin = false, nullable = true, comment = "二维码图片文件")
  public File appealFile;
  @ReqParam(isSgin = true, nullable = false, comment = "用户id")
  public String userId;
  @ReqParam(isSgin = false, nullable = false, comment = "操作 1:安卓 2:IOS")
  public String operSysType;
  @ReqParam(isSgin = false, nullable = false, comment = "版本")
  public String version = "1.0.0";

  public AddPaymentReq setVersion(String version) {
    this.version = version;
    return this;
  }

  public AddPaymentReq setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  @ReqParam(isSgin = true, nullable = false, comment = "Token")
  public String accessToken = System.currentTimeMillis() + "1";

  public AddPaymentReq(String receiveType) {
    this.receiveType = receiveType;
  }

  public AddPaymentReq(String receiveType, String name, String accountNo,
      String userId, String operSysType) {
    this.receiveType = receiveType;
    this.name = name;
    this.accountNo = accountNo;
    this.userId = userId;
    this.operSysType = operSysType;
  }

  public AddPaymentReq(String receiveType, String name, String accountNo, String bankName,
                       String bankAddr, File appealFile, String userId, String operSysType) {
    this.receiveType = receiveType;
    this.name = name;
    this.accountNo = accountNo;
    this.bankName = bankName;
    this.bankAddr = bankAddr;
    this.appealFile = appealFile;
    this.userId = userId;
    this.operSysType = operSysType;
  }

  public AddPaymentReq setReceiveType(String receiveType) {
    this.receiveType = receiveType;
    return this;
  }

  public AddPaymentReq setName(String name) {
    this.name = name;
    return this;
  }

  public AddPaymentReq setAccountNo(String accountNo) {
    this.accountNo = accountNo;
    return this;
  }

  public AddPaymentReq setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public AddPaymentReq setBankAddr(String bankAddr) {
    this.bankAddr = bankAddr;
    return this;
  }

  public AddPaymentReq setAppealFile(File appealFile) {
    this.appealFile = appealFile;
    return this;
  }

  public AddPaymentReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public AddPaymentReq setOperSysType(String operSysType) {
    this.operSysType = operSysType;
    return this;
  }
}
