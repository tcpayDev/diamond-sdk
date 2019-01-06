package io.tradingchain.sdk.diamondsdk.response;

public class BaseVO{
  public String resCode;
  public String resMsg;

  public BaseVO() {
    this.resCode="C502570000000";
    this.resMsg ="ok";
  }

  public BaseVO(String code,String msg) {
    this.resCode=code;
    this.resMsg =msg;
  }
}
