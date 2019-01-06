package io.tradingchain.sdk.diamondsdk.response;


import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersResVO;
import java.util.List;

public class OtcPostersResponseOtc extends BaseVO {

  public List<OtcPostersResVO> otcPostersVOS;

  public OtcPostersResponseOtc(List<OtcPostersResVO> list) {
    this.resCode = "C502570000000";
    this.resMsg = "ok";
    this.otcPostersVOS = list;
  }
}
