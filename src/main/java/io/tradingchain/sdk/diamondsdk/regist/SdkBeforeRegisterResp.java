package io.tradingchain.sdk.diamondsdk.regist;

import io.tradingchain.sdk.diamondsdk.response.BaseVO;

public class SdkBeforeRegisterResp extends BaseVO {
  public Object data;

  public SdkBeforeRegisterResp(Object data) {
    this.resCode="C502570000000";
    this.resMsg="ok";
    this.data = data;
  }
}
