package io.tradingchain.sdk.diamondsdk.payment;

import java.util.List;

public class QueryPaymentResp {
  public String resCode;
  public String resMsg;
  public List<MerReceiveVo> receiveVoList;

  public class MerReceiveVo{
    public String id;
    public String userId;
    public String name;
    public String stutas;
    public String receiveType;
    public String accountNo;
    public String qrUrl;
    public String bankNo;
    public String bankAddr;
  }
}
