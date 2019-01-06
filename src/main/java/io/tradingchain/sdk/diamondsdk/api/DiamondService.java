package io.tradingchain.sdk.diamondsdk.api;

import static io.tradingchain.sdk.diamondsdk.config.Config.setCommonParams;
import static io.tradingchain.sdk.diamondsdk.config.Config.setOtcCommonParams;

import io.tradingchain.sdk.diamondsdk.account.AccountDetailsReq;
import io.tradingchain.sdk.diamondsdk.account.AccountDetailsResp;
import io.tradingchain.sdk.diamondsdk.account.SdkAccountDetailsResp;
import io.tradingchain.sdk.diamondsdk.config.Config;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateReq;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateRes;
import io.tradingchain.sdk.diamondsdk.exchangeRate.OrderBookRes;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersReq;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersRes;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersRes.OtcPosters;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersResVO;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersVO;
import io.tradingchain.sdk.diamondsdk.order.CancelOrderReq;
import io.tradingchain.sdk.diamondsdk.order.CancelOrderResp;
import io.tradingchain.sdk.diamondsdk.order.ConfirmPayReq;
import io.tradingchain.sdk.diamondsdk.order.ConfirmPayResp;
import io.tradingchain.sdk.diamondsdk.order.CreateOrderReq;
import io.tradingchain.sdk.diamondsdk.order.CreateOrderResp;
import io.tradingchain.sdk.diamondsdk.order.FiatTradeAppealReq;
import io.tradingchain.sdk.diamondsdk.order.FiatTradeAppealResp;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderListReq;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderListResp;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderReq;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderResp;
import io.tradingchain.sdk.diamondsdk.payment.AddPaymentReq;
import io.tradingchain.sdk.diamondsdk.payment.AddPaymentResp;
import io.tradingchain.sdk.diamondsdk.payment.ChargeCollectTransferReq;
import io.tradingchain.sdk.diamondsdk.payment.ChargeCollectTransferResp;
import io.tradingchain.sdk.diamondsdk.payment.DelPaymentReq;
import io.tradingchain.sdk.diamondsdk.payment.DelPaymentResp;
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveReq;
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveResp;
import io.tradingchain.sdk.diamondsdk.payment.QueryPaymentReq;
import io.tradingchain.sdk.diamondsdk.payment.QueryPaymentResp;
import io.tradingchain.sdk.diamondsdk.regist.BeforeRegisterReq;
import io.tradingchain.sdk.diamondsdk.regist.BeforeRegisterResp;
import io.tradingchain.sdk.diamondsdk.regist.QueryUserReq;
import io.tradingchain.sdk.diamondsdk.regist.QueryUserResp;
import io.tradingchain.sdk.diamondsdk.regist.RegistReq;
import io.tradingchain.sdk.diamondsdk.regist.RegisterRes;
import io.tradingchain.sdk.diamondsdk.regist.RegisterResOTC;
import io.tradingchain.sdk.diamondsdk.regist.SdkBeforeRegisterResp;
import io.tradingchain.sdk.diamondsdk.regist.SdkRegisterResOTC;
import io.tradingchain.sdk.diamondsdk.regist.UserReq;
import io.tradingchain.sdk.diamondsdk.regist.UserResp;
import io.tradingchain.sdk.diamondsdk.response.BaseVO;
import io.tradingchain.sdk.diamondsdk.response.OtcPostersResponse;
import io.tradingchain.sdk.diamondsdk.response.OtcPostersResponseOtc;
import io.tradingchain.sdk.diamondsdk.trustAsset.AssetsTrustReq;
import io.tradingchain.sdk.diamondsdk.util.AnnotationUtil;
import io.tradingchain.sdk.diamondsdk.util.HttpUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DiamondService {

  public static void main(String[] args) {
    BigDecimal a = new BigDecimal("1000");
    //System.out.println(a.compareTo(new BigDecimal("1000")));
  }

  /**
   * 注册前获取备份私钥
   */
  public BaseVO beforeRegister(BeforeRegisterReq req) throws Exception {
    final String path = "/api/getKeyBeforeRegister";
    BeforeRegisterResp resp = HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), Config.SECRET))
        .castTo(BeforeRegisterResp.class);
    if (resp.code == 0) {
      return new SdkBeforeRegisterResp(resp);
    } else {
      return new BaseVO(resp.code + "", resp.msg);
    }
  }

  /**
   * 注册接口
   *
   * @param req 请求体
   * @param type 操作方式 1: 安卓; 2: IOS
   */
  public BaseVO register(RegistReq req, String type) throws Exception {
    final String path = "/api/registUser2";
    //注册1
    RegisterRes res = HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), Config.SECRET))
        .castTo(RegisterRes.class);
    if (res.code == 0) {
      //去OTC做相应注册
      RegisterResOTC resOTC = userAdd(req, res, type);
      if (resOTC.code == 0) {
        return new SdkRegisterResOTC(resOTC);
      } else {
        return new BaseVO(resOTC.code + "", resOTC.msg);
      }
    } else {
      return new BaseVO(res.code + "", res.msg);
    }
  }

  /**
   * OTC注册接口
   */
  private RegisterResOTC userAdd(RegistReq req, RegisterRes res, String type) throws Exception {
    final String otc_path = "/api/user/add";
    //查询商户是否在OTC注册;
    UserReq userReq = new UserReq();
    QueryUserReq queryUserReq = new QueryUserReq();
    queryUserReq.mobile = req.phone;
    queryUserReq.accessToken = System.currentTimeMillis() + "1";
    queryUserReq.operSysType = type;
    queryUserReq.version = userReq.version;
    QueryUserResp queryUserResp = queryUser(queryUserReq);
    if (queryUserResp.resCode.equals("C502570000000")) {
      if (queryUserResp.userStatus.equals("01")) {
        //该用户没有注册,调用OTC注册接口
        //生成请求参数
        userReq.mobile = req.phone;
        userReq.loginPass = req.password;
        userReq.tradePassword = req.tradePassword;
        userReq.privateKey = req.privateKey;
        userReq.exUserId = res.data.userId + "";
        userReq.publicKey = res.data.publicKey;
        userReq.inviteCode = res.data.inviteCode;
        userReq.idCard = req.phone;
        userReq.userName = req.username;
        userReq.operSysType = type;
        userReq.nickName = req.username;
        UserResp user = HttpUtil.post(AnnotationUtil
            .buildReq(Config.OTC_BASE_URL + otc_path, setOtcCommonParams(userReq),
                Config.OTC_SECRET)).castTo(UserResp.class);
        if (user.resCode.equals("C502570000000")) {
          //System.out.println(res.data.publicKey);
          return new RegisterResOTC(res, user);
        } else {
          return new RegisterResOTC(user.resMsg);
        }
      } else {
        return new RegisterResOTC(queryUserResp.resMsg);
      }
    } else {
      return new RegisterResOTC(queryUserResp.resMsg);
    }
  }

  /**
   * 用户查询接口
   */
  public QueryUserResp queryUser(QueryUserReq req) throws Exception {
    final String path = "/api/user/query";
    return HttpUtil
        .post(AnnotationUtil
            .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req), Config.OTC_SECRET))
        .castTo(QueryUserResp.class);
  }

  /**
   * 账户详情接口
   */
  public BaseVO accountDetails(AccountDetailsReq req) throws Exception {
    final String path = "/find/account";
    AccountDetailsResp detailsResp = HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), Config.SECRET))
        .castTo(AccountDetailsResp.class);
    if (detailsResp.code == 0) {
      return new SdkAccountDetailsResp(detailsResp);
    } else {
      return new BaseVO(detailsResp.code + "", detailsResp.msg);
    }
  }

  /**
   * 获取汇率
   *
   * @param req 请求体
   */
  public ExchangeRateRes exchangeRate(ExchangeRateReq req, AssetsTrustReq assetReq)
      throws Exception {
    final String path = "/find/tradeDepth";
    OrderBookRes rateReq = HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), Config.SECRET))
        .castTo(OrderBookRes.class);
    BigDecimal rateBuy = rateReq.bids[0][0];
    BigDecimal rateSell = rateReq.asks[0][0];
    // TODO 获取OTC最新的汇率
    //计算DB-USDT的最终汇率
    String exchangeRateBuy = rateBuy.multiply(new BigDecimal("7"))
        .setScale(7, BigDecimal.ROUND_HALF_EVEN).toPlainString();
    String exchangeRateSell = rateSell.multiply(new BigDecimal("7"))
        .setScale(7, BigDecimal.ROUND_HALF_EVEN).toPlainString();
    //信任币种
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          assetsTrust(assetReq);
        } catch (Exception e) {
        }
      }
    }).start();
    return new ExchangeRateRes(exchangeRateBuy, exchangeRateSell);
  }


  /**
   * 资产列表信任接口
   */
  private void assetsTrust(AssetsTrustReq req) throws Exception {
    final String path = "/find/assetTrustList";
    HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), Config.SECRET));
  }

  /**
   * 查询商家挂单列表
   *
   * @param req 请求体
   */
  public BaseVO moneyMerchantInfo(OtcPostersReq req) throws Exception {
    final String path = "/api/fiatTrade/queryOffers";
    OtcPostersRes res = HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(OtcPostersRes.class);
    List<OtcPostersVO> lists = new ArrayList<>();
    if (res.resCode.equals("C502570000000") && res.otcPosterseList.size() > 0) {
      for (OtcPosters o : res.otcPosterseList) {
        //获取币商的收款账户
        QueryPaymentReq receiveReq = new QueryPaymentReq();
        receiveReq.userId = o.userId;
        receiveReq.operSysType = req.operSysType;
        QueryPaymentResp receiveResp = findPayments(receiveReq);
        if (receiveResp.resCode.equals("C502570000000") && receiveResp.merReceiveVos.size() > 0) {
          lists.add(new OtcPostersVO(o, receiveResp.merReceiveVos));
        }
      }
      return new OtcPostersResponse(lists);
    } else {
      return new BaseVO(res.resCode, res.resMsg);
    }
  }

  /**
   * 推荐商家挂单
   *
   * @param req 请求体
   */
  public BaseVO moneyMerchantOrder(OtcPostersReq req) throws Exception {
    final String path = "/api/fiatTrade/queryOffers";
    OtcPostersRes res = HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(OtcPostersRes.class);
    List<OtcPostersResVO> lists = new ArrayList<>();
    List<OtcPosters> banks = new ArrayList<>();
    List<OtcPosters> alipays = new ArrayList<>();
    List<OtcPosters> wepays = new ArrayList<>();
    if (res.resCode.equals("C502570000000") && res.otcPosterseList.size() > 0) {
      for (OtcPosters o : res.otcPosterseList) {
        //推荐查询银行卡挂单
        if (o.paymentType.contains("bank")) {
          banks.add(o);
        }
        if (o.paymentType.contains("alipay")) {
          alipays.add(o);
        }
        if (o.paymentType.contains("wepay")) {
          wepays.add(o);
        }
      }
      //首先判断银行卡用户
      OtcPosters otcPosters = new OtcPosters();
      if (req.amount.compareTo(new BigDecimal("1000")) >= 0) {
        if (banks.size() > 0) {
          otcPosters = banks.get(banks.size() - 1);
        } else if (alipays.size() > 0) {
          otcPosters = alipays.get(alipays.size() - 1);
        } else if (wepays.size() > 0) {
          otcPosters = wepays.get(wepays.size() - 1);
        }
      } else {
        if (alipays.size() > 0) {
          otcPosters = alipays.get(alipays.size() - 1);
        } else if (banks.size() > 0) {
          otcPosters = banks.get(banks.size() - 1);
        } else if (wepays.size() > 0) {
          otcPosters = wepays.get(wepays.size() - 1);
        }
      }
      if (otcPosters == null) {
        return new BaseVO(res.resCode, res.resMsg);
      }
      //获取商户挂单信息
      QueryFiatTradeReceiveReq receiveReq = new QueryFiatTradeReceiveReq();
      receiveReq.operSysType = req.operSysType;
      receiveReq.userId = otcPosters.userId;
      receiveReq.payMode = otcPosters.paymentType;
      List<QueryFiatTradeReceiveResp.MerReceiveVo> mlists = new ArrayList<>();
      QueryFiatTradeReceiveResp queryResp = queryReceive(receiveReq);
      if (queryResp.resCode.equals("C502570000000")) {
        mlists.add(queryResp.receiveVo);
        lists.add(new OtcPostersResVO(otcPosters, mlists));
        return new OtcPostersResponseOtc(lists);
      }
    }
    return new BaseVO(res.resCode, res.resMsg);
  }

  /**
   * 收款方式设置信息提交
   *
   * @param req 请求体
   */
  public AddPaymentResp addPayment(AddPaymentReq req) throws Exception {
    final String path = "/api/info/receive/add";
    return HttpUtil.postForm(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(AddPaymentResp.class);
  }


  /**
   * 查询收款方式列表
   *
   * @param req 请求体
   */
  public QueryPaymentResp findPayments(QueryPaymentReq req) throws Exception {
    final String path = "/api/info/receive/list";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    treeMap.put("userId", req.userId);
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(QueryPaymentResp.class);
  }

  /**
   * 删除收款方式
   *
   * @param req 请求体
   */
  public DelPaymentResp delReceive(DelPaymentReq req) throws Exception {
    final String path = "/api/info/receive/delReceive";
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(DelPaymentResp.class);
  }


  /**
   * 创建订单
   *
   * @param req 请求体
   */
  public CreateOrderResp createOrder(CreateOrderReq req) throws Exception {
    final String path = "/api/fiatTrade/create";
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(CreateOrderResp.class);
  }


  /**
   * 取消订单
   *
   * @param req 请求体
   */
  public CancelOrderResp cancelOrder(CancelOrderReq req) throws Exception {
    final String path = "/api/fiatTrade/cancel";
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(CancelOrderResp.class);
  }

  /**
   * 确认付款
   *
   * @param req 请求体
   */
  public ConfirmPayResp confirmPay(ConfirmPayReq req) throws Exception {
    final String path = "/api/fiatTrade/pay";
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(ConfirmPayResp.class);
  }

  /**
   * 交易申诉
   *
   * @param req 请求体
   */
  public FiatTradeAppealResp fiatTradeAppeal(FiatTradeAppealReq req) throws Exception {
    final String path = "/api/fiatTrade/appeal";
    return HttpUtil.postForm(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(FiatTradeAppealResp.class);
  }


  /**
   * 订单列表查询
   *
   * @param req 请求体
   */
  public QueryOrderListResp orderList(QueryOrderListReq req) throws Exception {
    final String path = "/api/fiatTrade/query";
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(QueryOrderListResp.class);
  }


  /**
   * 查询单个收款方式信息
   *
   * @param req 请求体
   */
  public QueryFiatTradeReceiveResp queryReceive(QueryFiatTradeReceiveReq req) throws Exception {
    final String path = "/api/fiatTrade/queryReceives";

    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(QueryFiatTradeReceiveResp.class);
  }


  /**
   * 查询单个订单信息
   *
   * @param req 请求体
   */
  public QueryOrderResp orderInfo(QueryOrderReq req) throws Exception {
    final String path = "/api/fiatTrade/queryByOrderNo";
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET)).castTo(QueryOrderResp.class);
  }

  /**
   * 转账接口(接收方扣手续费,到付)
   */
  public BaseVO freightCollectTransfer(ChargeCollectTransferReq req)
      throws Exception {
    final String path = "/trade/api/dfPayment";

    ChargeCollectTransferResp collectTransferResp = HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), Config.SECRET))
        .castTo(ChargeCollectTransferResp.class);
    if (collectTransferResp.code == 0) {
      return new BaseVO();
    } else {
      return new BaseVO(collectTransferResp.code + "", collectTransferResp.msg);
    }
  }
}
