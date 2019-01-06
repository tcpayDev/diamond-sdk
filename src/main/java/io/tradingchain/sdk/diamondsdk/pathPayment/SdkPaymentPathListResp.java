package io.tradingchain.sdk.diamondsdk.pathPayment;

import io.tradingchain.sdk.diamondsdk.pathPayment.PaymentPathListResp.Data;
import io.tradingchain.sdk.diamondsdk.response.BaseVO;
import java.util.List;

public class SdkPaymentPathListResp extends BaseVO{

  public List<Data> data;

  public SdkPaymentPathListResp(PaymentPathListResp pathListResp) {
    this.resMsg="ok";
    this.resCode="C502570000000";
    this.data = pathListResp.data;
  }
}
