package io.tradingchain.sdk.diamondsdk.response;


import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersVO;
import java.util.List;

public class OtcPostersResponse extends BaseVO {

  public List<OtcPostersVO> otcPostersVOS;

  public OtcPostersResponse(List<OtcPostersVO> list) {
    this.resCode="C502570000000";
    this.resCode="ok";
    this.otcPostersVOS=list;
  }
}
