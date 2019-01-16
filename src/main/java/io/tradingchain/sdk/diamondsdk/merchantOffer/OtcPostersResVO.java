package io.tradingchain.sdk.diamondsdk.merchantOffer;


import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersRes.OtcPosters;
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveResp;
import java.util.List;

public class OtcPostersResVO{

  public OtcVO otcVOS;

  public OtcPostersResVO(OtcPosters o, List<QueryFiatTradeReceiveResp.MerReceiveVo> list) {
    this.otcVOS = new OtcVO(o, list);
  }

  public class OtcVO {

    public String orderNo; //	订单号
    public String userId; //	用户id
    public String extend1;     //昵称
    public String price;    //价格
    public List<QueryFiatTradeReceiveResp.MerReceiveVo> accountNo;  //收款信息

    public OtcVO(OtcPosters o, List<QueryFiatTradeReceiveResp.MerReceiveVo> list) {
      this.extend1 = o.extend1;
      this.accountNo = list;
      this.orderNo=o.orderNo;
      this.price=o.unitPrice;
    }
  }
}
