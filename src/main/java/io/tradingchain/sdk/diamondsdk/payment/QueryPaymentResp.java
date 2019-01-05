package io.tradingchain.sdk.diamondsdk.payment;

import java.util.List;

public class QueryPaymentResp {
  public String resCode;
  public String resMsg;
  public List<MerReceiveVo> merReceiveVos;

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

    public MerReceiveVo() {
    }

    @Override
    public String toString() {
      return "MerReceiveVo{" +
          "id='" + id + '\'' +
          ", userId='" + userId + '\'' +
          ", name='" + name + '\'' +
          ", stutas='" + stutas + '\'' +
          ", receiveType='" + receiveType + '\'' +
          ", accountNo='" + accountNo + '\'' +
          ", qrUrl='" + qrUrl + '\'' +
          ", bankNo='" + bankNo + '\'' +
          ", bankAddr='" + bankAddr + '\'' +
          '}';
    }
  }

  @Override
  public String toString() {
    return "QueryPaymentResp{" +
        "resCode='" + resCode + '\'' +
        ", resMsg='" + resMsg + '\'' +
        ", merReceiveVos=" + merReceiveVos +
        '}';
  }
}
