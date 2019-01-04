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
}
