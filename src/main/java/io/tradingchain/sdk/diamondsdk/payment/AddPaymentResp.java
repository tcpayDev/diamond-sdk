package io.tradingchain.sdk.diamondsdk.payment;

public class AddPaymentResp {
  public String resCode;
  public String resMsg;

  @Override
  public String toString() {
    return "AddPaymentResp{" +
        "resCode='" + resCode + '\'' +
        ", resMsg='" + resMsg + '\'' +
        '}';
  }
}
