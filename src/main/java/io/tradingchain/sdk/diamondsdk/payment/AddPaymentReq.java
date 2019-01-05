package io.tradingchain.sdk.diamondsdk.payment;

public class AddPaymentReq {
  public String receiveType;
  public String name;
  public String accountNo;
  public String bankName;
  public String bankAddr;
  public String appealFile;
  public String userId;
  public String operSysType;
  public String version = "1.0.0";
  public String accessToken = System.currentTimeMillis()+"1";

  public AddPaymentReq(String receiveType) {
    this.receiveType = receiveType;
  }

  public AddPaymentReq(String receiveType, String name, String accountNo, String bankName,
      String bankAddr, String appealFile, String userId, String operSysType) {
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

  public AddPaymentReq setAppealFile(String appealFile) {
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
