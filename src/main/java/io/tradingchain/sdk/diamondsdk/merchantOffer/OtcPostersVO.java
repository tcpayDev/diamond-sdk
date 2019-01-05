package io.tradingchain.sdk.diamondsdk.merchantOffer;


import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersRes.OtcPosters;
import io.tradingchain.sdk.diamondsdk.payment.QueryPaymentResp.MerReceiveVo;
import java.util.List;

public class OtcPostersVO {

  public OtcVO otcVOS;

  public OtcPostersVO(OtcPosters o, List<MerReceiveVo> list) {
    this.otcVOS = new OtcVO(o, list);
  }

  public class OtcVO {

    public String orderNo; //	订单号
    public String userId; //	用户id
    public String extend1;     //昵称
    public List<MerReceiveVo> accountNo;  //收款信息

    public OtcVO(OtcPosters o, List<MerReceiveVo> list) {
      this.extend1 = o.extend1;
      this.accountNo = list;
    }
  }
}
