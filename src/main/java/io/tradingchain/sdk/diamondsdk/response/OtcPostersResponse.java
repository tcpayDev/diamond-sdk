package io.tradingchain.sdk.diamondsdk.response;


import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersVO;
import java.util.List;

public class OtcPostersResponse extends BaseVO {

  public List<OtcPostersVO> otcPostersVOS;

  public OtcPostersResponse(List<OtcPostersVO> list) {
    this.code="0";
    this.msg="ok";
    this.otcPostersVOS=list;
  }
}
