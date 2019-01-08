package io.tradingchain.sdk.diamondsdk.commit;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;
import java.math.BigDecimal;

public class CommitOrderReq {
  @ReqParam(isSgin = false,nullable = true, comment = "用户id")
  public String userAddress;     //用户的公钥
  @ReqParam(isSgin = false,nullable = true, comment = "用户id")
  public String username;        //用户名
  @ReqParam(isSgin = false,nullable = true, comment = "用户id")
  public String password;        //登陆密码
  @ReqParam(isSgin = false,nullable = true, comment = "用户id")
  public String tradePassword;   //交易密码
  @ReqParam(isSgin = false,nullable = true, comment = "用户id")
  public String privateKey;      //用户私钥1
  @ReqParam(isSgin = false,nullable = true, comment = "用户id")
  public BigDecimal rate;        //基础币和USDT的汇率
  @ReqParam(isSgin = false,nullable = true, comment = "用户id")
  public String assetCode;        //钻石币币种名称
  @ReqParam(isSgin = false,nullable = true, comment = "用户id")
  public String assetIssuer;      //钻石币币种发行人

}
