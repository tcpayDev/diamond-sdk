package io.tradingchain.sdk.diamondsdk.account;

import io.tradingchain.sdk.diamondsdk.account.AccountDetailsResp.Data;
import io.tradingchain.sdk.diamondsdk.response.BaseVO;
import java.util.List;

public class SdkAccountDetailsResp extends BaseVO{
  public String total;
  public List<Data> data;

  public SdkAccountDetailsResp(AccountDetailsResp detailsResp) {
    this.resCode="C502570000000";
    this.resMsg="ok";
    this.total=detailsResp.total;
   this.data=detailsResp.data;
  }
}
