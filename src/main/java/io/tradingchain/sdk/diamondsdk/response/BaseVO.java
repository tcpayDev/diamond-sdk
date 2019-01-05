package io.tradingchain.sdk.diamondsdk.response;

public class BaseVO extends BaseRes{
  public String code;
  public String msg;

  public BaseVO() {
    this.code="0";
    this.msg="ok";
  }

  public BaseVO(String code,String msg) {
    this.code=code;
    this.msg=msg;
  }
}
