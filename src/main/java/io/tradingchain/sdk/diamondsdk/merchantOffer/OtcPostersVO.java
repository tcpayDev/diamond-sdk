package io.tradingchain.sdk.diamondsdk.merchantOffer;


import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersRes.OtcPosters;
import io.tradingchain.sdk.diamondsdk.payment.QueryPaymentResp.MerReceiveVo;
import java.util.List;

public class OtcPostersVO {

  public OtcVO otcVOS;

  public OtcPostersVO(OtcPosters o, List<MerReceiveVo> list) {
    this.otcVOS = new OtcVO(o, list);
  }

  @Override
  public String toString() {
    return "OtcPostersVO{" +
        "otcVOS=" + otcVOS +
        '}';
  }

  public class OtcVO {

    public String orderNo; //	订单号
    public String userId; //	用户id
    public String extend1;     //昵称
    public String price;    //价格
    public List<MerReceiveVo> accountNo;  //收款信息

    public OtcVO(OtcPosters o, List<MerReceiveVo> list) {
      this.orderNo=o.orderNo;
      this.price=o.unitPrice;
      this.extend1 = o.extend1;
      this.accountNo = list;
    }


    @Override
    public String toString() {
      return "OtcVO{" +
          "orderNo='" + orderNo + '\'' +
          ", userId='" + userId + '\'' +
          ", extend1='" + extend1 + '\'' +
          ", price='" + price + '\'' +
          ", accountNo=" + accountNo +
          '}';
    }
  }
}
