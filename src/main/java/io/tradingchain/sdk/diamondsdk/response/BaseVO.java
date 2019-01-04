package io.tradingchain.sdk.diamondsdk.response;

public class BaseVO extends BaseRes{
  public int code;
  public String msg;

  public BaseVO() {
    this.code=0;
    this.msg="ok";
  }
}
