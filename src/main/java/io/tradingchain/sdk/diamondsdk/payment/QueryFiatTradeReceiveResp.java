package io.tradingchain.sdk.diamondsdk.payment;

public class QueryFiatTradeReceiveResp {
  public String resCode;
  public String resMsg;

  public MerReceiveVo receiveVo;

  public class MerReceiveVo{
    public String userId;
    public String name;
    public String receiveType;
    public String accountNo;
    public String qrUrl;
    public String bankNo;
    public String bankAddr;

    @Override
    public String toString() {
      return "MerReceiveVo{" +
          "userId='" + userId + '\'' +
          ", name='" + name + '\'' +
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
    return "QueryFiatTradeReceiveResp{" +
        "resCode='" + resCode + '\'' +
        ", resMsg='" + resMsg + '\'' +
        ", receiveVo=" + receiveVo +
        '}';
  }
}
