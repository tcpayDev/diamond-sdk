package io.tradingchain.sdk.diamondsdk.merchantOffer;

import java.util.List;

public class OtcPostersRes {

  public String resCode;
  public String resMsg;
  public List<OtcPosters> otcPosterseList;

  public static class OtcPosters {

    public String orderNo; //	订单号

    public String postType; //	挂单方向

    public String userId; //	用户id
    public String unitPrice; //	单价
    public String amount; //	数量
    public String totalPrice; //	总金额
    public String minPrice; //	最低限额
    public String maxPrice; //	最高限额

    public String dealPrice; //	已成交量

    public String surplusPrice; //	未成交量

    public String status; //	状态 PROCESSING-挂单中，COMPLETED-已完成UNKNOW-未知

    public String currency; //	交易币种	  如：USDT BTC ETH

    public String paymentType; //	支付方式

    public String extend1;
    public List<MerReceive> receiveLists;
  }

  public static class MerReceive {

    public String userId;
    public String name;
    public String receiveType;
    public String accountNo;
    public String qrUrl;
    public String bankNo;
    public String bankAddr;
    public String bankName;
  }
}
