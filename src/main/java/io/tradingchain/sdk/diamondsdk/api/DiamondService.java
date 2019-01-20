package io.tradingchain.sdk.diamondsdk.api;

import static io.tradingchain.sdk.diamondsdk.config.Config.setCommonParams;
import static io.tradingchain.sdk.diamondsdk.config.Config.setOtcCommonParams;

import io.tradingchain.sdk.diamondsdk.account.AccountDetailsReq;
import io.tradingchain.sdk.diamondsdk.account.AccountDetailsResp;
import io.tradingchain.sdk.diamondsdk.config.Config;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeOTCRateReq;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeOTCRateRes;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateReq;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateRes;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeReq;
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
import io.tradingchain.sdk.diamondsdk.order.TradeGrantReq;
import io.tradingchain.sdk.diamondsdk.order.TradeGrantResp;
import io.tradingchain.sdk.diamondsdk.pathPayment.DoPathPaymentReq;
import io.tradingchain.sdk.diamondsdk.pathPayment.DoPathPaymentResp;
import io.tradingchain.sdk.diamondsdk.pathPayment.PaymentPathListReq;
import io.tradingchain.sdk.diamondsdk.pathPayment.PaymentPathListResp;
import io.tradingchain.sdk.diamondsdk.pathPayment.SdkPaymentPathListResp;
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
import io.tradingchain.sdk.diamondsdk.regist.ForgetPasswordRequestVO;
import io.tradingchain.sdk.diamondsdk.regist.QueryUserReq;
import io.tradingchain.sdk.diamondsdk.regist.QueryUserResp;
import io.tradingchain.sdk.diamondsdk.regist.RegistReq;
import io.tradingchain.sdk.diamondsdk.regist.RegisterRes;
import io.tradingchain.sdk.diamondsdk.regist.RegisterResOTC;
import io.tradingchain.sdk.diamondsdk.regist.ResetPasswordRequestVO;
import io.tradingchain.sdk.diamondsdk.regist.ResetPasswordResponseVO;
import io.tradingchain.sdk.diamondsdk.regist.UserReq;
import io.tradingchain.sdk.diamondsdk.regist.UserResp;
import io.tradingchain.sdk.diamondsdk.response.BaseRes;
import io.tradingchain.sdk.diamondsdk.response.BaseVO;
import io.tradingchain.sdk.diamondsdk.response.OtcPostersResponse;
import io.tradingchain.sdk.diamondsdk.response.OtcPostersResponseOtc;
import io.tradingchain.sdk.diamondsdk.trustAsset.AssetsTrustReq;
import io.tradingchain.sdk.diamondsdk.user.UserInfoReq;
import io.tradingchain.sdk.diamondsdk.user.UserInfoReqVO;
import io.tradingchain.sdk.diamondsdk.user.UserInfoResp;
import io.tradingchain.sdk.diamondsdk.util.AnnotationUtil;
import io.tradingchain.sdk.diamondsdk.util.HttpUtil;
import io.tradingchain.sdk.diamondsdk.util.RandomUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import io.tradingchain.sdk.diamondsdk.payment.QueryPaymentResp.MerReceiveVo;

public class DiamondService {

  /**
   * 注册前获取备份私钥
   */
  public BeforeRegisterResp beforeRegister(BeforeRegisterReq req, String SECRET) throws Exception {
    final String path = "/api/getKeyBeforeRegister";
    return HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), SECRET))
        .castTo(BeforeRegisterResp.class);
  }

  /**
   * 注册接口
   *
   * @param req 请求体
   * @param type 操作方式 1: 安卓; 2: IOS
   */
  public RegisterResOTC register(RegistReq req, String type, String SECRET) throws Exception {
    final String path = "/api/registUser2";
    //注册1
    RegisterRes res = HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), SECRET))
        .castTo(RegisterRes.class);
    if (res.code == 0) {
      //去OTC做相应注册
      return userAdd(req, res, type);
    } else {
      return new RegisterResOTC(res.msg, req.username, req.platform);
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
  public AccountDetailsResp accountDetails(AccountDetailsReq req, String SECRET) throws Exception {
    final String path = "/find/otc/account";
    return HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), SECRET))
        .castTo(AccountDetailsResp.class);
  }

  /**
   * 获取汇率
   *
   * @param req 请求体
   */
  public ExchangeRateRes exchangeRate(ExchangeReq req, String SECRET)
      throws Exception {
    final String path = "/find/tradeDepth";
    final String otc_path = "/api/fiatTrade/queryExchangeRate";
    //信任资产
    AssetsTrustReq assetReq = new AssetsTrustReq();
    assetReq.username = req.username;
    assetReq.platform = req.platform;
    assetReq.privateKey = req.privateKey;
    assetReq.apiKey = req.apiKey;
    assetReq.list = req.list;
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          assetsTrust(assetReq, SECRET);
        } catch (Exception e) {
        }
      }
    }).start();
    //获取汇率
    String exchangeRateBuy = "0.0";
    String exchangeRateSell = "0.0";
    ExchangeRateReq exchangeRateReq = new ExchangeRateReq();
    exchangeRateReq.counterAsset = req.counterAsset;
    exchangeRateReq.counterAssetIssuer = req.counterAssetIssuer;
    exchangeRateReq.baseAsset = req.baseAsset;
    exchangeRateReq.baseAssetIssuer = req.baseAssetIssuer;
    exchangeRateReq.size = req.size;
    exchangeRateReq.apiKey = req.apiKey;
    OrderBookRes rateReq = HttpUtil.post(AnnotationUtil
        .buildReq(Config.BASE_URL + path, setCommonParams(exchangeRateReq), SECRET))
        .castTo(OrderBookRes.class);
    if (rateReq.code != 0) {
      return new ExchangeRateRes(rateReq.code + "", "暂无币商挂单,请选择其他交易方式");
    }
    BigDecimal rateBuy;
    if (rateReq.bids.length <= 0) {
      rateBuy = BigDecimal.ZERO;
    } else {
      rateBuy = rateReq.bids[0][0];
    }
    BigDecimal rateSell;
    if (rateReq.asks.length <= 0) {
      rateSell = BigDecimal.ZERO;
    } else {
      rateSell = rateReq.asks[0][0];
    }
    //  获取OTC最新的汇率
    ExchangeOTCRateReq exchangeOTCRateReq = new ExchangeOTCRateReq();
    exchangeOTCRateReq.assetCode = req.counterAsset;
    exchangeOTCRateReq.operSysType = req.operSysType;
    ExchangeOTCRateRes rate = HttpUtil
        .post(AnnotationUtil
            .buildReq(Config.OTC_BASE_URL + otc_path, setCommonParams(exchangeOTCRateReq),
                Config.OTC_SECRET))
        .castTo(ExchangeOTCRateRes.class);
    if (rate.resCode.equals("C502570000000")) {
      exchangeRateBuy = rateBuy.multiply(rate.buyRate).setScale(7, BigDecimal.ROUND_HALF_EVEN)
          .toPlainString();
      exchangeRateSell = rateSell.multiply(rate.sellRate).setScale(7, BigDecimal.ROUND_HALF_EVEN)
          .toPlainString();
    } else {
      return new ExchangeRateRes(rate.resCode, "暂无币商挂单,请选择其他交易方式");
    }
    return new ExchangeRateRes(rateBuy + "", rateSell + "", exchangeRateBuy, exchangeRateSell);
  }


  /**
   * 资产列表信任接口
   */
  public void assetsTrust(AssetsTrustReq req, String SECRET) {
    final String path = "/find/assetTrustList";
    try {
      HttpUtil
          .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), SECRET));
    } catch (Exception e) {
    }
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
        if (new BigDecimal(o.minPrice).compareTo(req.amount) <= 0
            && new BigDecimal(o.maxPrice).compareTo(req.amount) >= 0) {
          //获取币商的收款账户
          if (new BigDecimal(o.amount).compareTo(req.amount) >= 0) {
            QueryPaymentReq receiveReq = new QueryPaymentReq();
            receiveReq.userId = o.userId;
            receiveReq.operSysType = req.operSysType;
            QueryPaymentResp receiveResp = findPayments(receiveReq);
            List<MerReceiveVo> list = new ArrayList<>();
            if (receiveResp.resCode.equals("C502570000000")
                && receiveResp.merReceiveVos.size() > 0) {
              for (MerReceiveVo m :receiveResp.merReceiveVos){
                if (m.stutas.equals("1")){
                  list.add(m);
                }
              }
              lists.add(new OtcPostersVO(o, list));
            }
          }
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
        if (new BigDecimal(o.minPrice).compareTo(req.amount) <= 0 && new BigDecimal(o.maxPrice).compareTo(req.amount) >= 0) {
          if (new BigDecimal(o.amount).compareTo(req.amount) >= 0) {
            //查询挂单商户的收款方式
            QueryPaymentReq receiveReq = new QueryPaymentReq();
            receiveReq.userId = o.userId;
            receiveReq.operSysType = req.operSysType;
            QueryPaymentResp receiveResp = findPayments(receiveReq);
            if (receiveResp.merReceiveVos.size()>0){
              for (MerReceiveVo m : receiveResp.merReceiveVos){
                //判断收款方式是否可用.并根据收款类型分别处理
                if (m.stutas.equals("1")){
                  if (m.receiveType.equals("bank")) {
                    banks.add(o);
                  }
                  if (m.receiveType.equals("alipay")) {
                    alipays.add(o);
                  }
                  if (m.receiveType.equals("wepay")) {
                    wepays.add(o);
                  }
                }
              }
            }
          }
        }
      }
      //首先判断银行卡用户
      OtcPosters otcPosters = new OtcPosters();
      String paymentType= "";
      if (req.amount.compareTo(new BigDecimal("1000")) >= 0) {
        if (banks.size() > 0) {
          paymentType="bank";
          otcPosters = banks.get(RandomUtil.get(banks.size()));
        } else if (alipays.size() > 0) {
          paymentType="alipay";
          otcPosters = alipays.get(RandomUtil.get(alipays.size()));
        } else if (wepays.size() > 0) {
          paymentType="wepay";
          otcPosters = wepays.get(RandomUtil.get(wepays.size()));
        }
      } else {
        if (alipays.size() > 0) {
          paymentType="alipay";
          otcPosters = alipays.get(RandomUtil.get(alipays.size()));
        } else if (banks.size() > 0) {
          paymentType="bank";
          otcPosters = banks.get(RandomUtil.get(banks.size()));
        } else if (wepays.size() > 0) {
          paymentType="wepay";
          otcPosters = wepays.get(RandomUtil.get(wepays.size()));
        }
      }
      if (otcPosters == null) {
        return new BaseVO(res.resCode, res.resMsg);
      }
      //获取商户挂单信息
      QueryFiatTradeReceiveReq receiveReq = new QueryFiatTradeReceiveReq();
      receiveReq.operSysType = req.operSysType;
      receiveReq.userId = otcPosters.userId;
      receiveReq.payMode = paymentType;
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
  public ChargeCollectTransferResp freightCollectTransfer(ChargeCollectTransferReq req,
      String SECRET)
      throws Exception {
    final String path = "/trade/api/dfPayment";
    return HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), SECRET))
        .castTo(ChargeCollectTransferResp.class);
  }

  /**
   * 桥链列表接口(接收方扣手续费,到付)
   */
  public BaseVO paymentPathListOfFreightCollect(PaymentPathListReq req, String SECRET)
      throws Exception {
    final String path = "/find/getPaymentPathList";
    PaymentPathListResp pathListResp = HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), SECRET))
        .castTo(PaymentPathListResp.class);
    if (pathListResp.code == 0) {
      return new SdkPaymentPathListResp(pathListResp);
    } else {
      return new BaseVO(pathListResp.code + "", pathListResp.msg);
    }
  }

  /**
   * 桥链支付接口(接收方扣手续费,到付)
   */
  public BaseVO doPathPaymentFreightCollect(DoPathPaymentReq req, String SECRET) throws Exception {
    final String path = "/trade/api/dfPaymentPath";
    DoPathPaymentResp doPathPaymentResp = HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), SECRET))
        .castTo(DoPathPaymentResp.class);
    if (doPathPaymentResp.code == 0) {
      return new BaseVO();
    } else {
      return new BaseVO(doPathPaymentResp.code + "", doPathPaymentResp.msg);
    }
  }


  /**
   * 交易放币接口
   */
  public BaseVO fiatTradeGrant(TradeGrantReq req) throws Exception {
    final String path = "/api/fiatTrade/grant";
    TradeGrantResp grantResp = HttpUtil
        .post(AnnotationUtil
            .buildReq(Config.OTC_BASE_URL + path, setCommonParams(req), Config.OTC_SECRET))
        .castTo(TradeGrantResp.class);
    if (grantResp.resCode.equals("C502570000000")) {
      return new BaseVO();
    } else {
      return new BaseVO(grantResp.resCode, grantResp.resMsg);
    }
  }

  /**
   * 获取用户信息
   */
  public UserInfoResp userInfo(UserInfoReq req) throws Exception {
    UserInfoReqVO userInfoReqVO = new UserInfoReqVO();
    userInfoReqVO.userId = req.userId;
    userInfoReqVO.apiKey = req.apiKey;
    userInfoReqVO.timeStamp = req.timeStamp;
    return HttpUtil
        .post(AnnotationUtil.buildReq(req.pathUrl, setCommonParams(userInfoReqVO), req.secret))
        .castTo(UserInfoResp.class);
  }


  /**
   * 修改密码
   */
  public BaseRes resetPassword(ResetPasswordRequestVO basePasswordVO, String secret)
      throws Exception {
    final String path = "/api/resetPassword";
    return HttpUtil
        .post(AnnotationUtil
            .buildReq(Config.BASE_URL + path, setCommonParams(basePasswordVO), secret))
        .castTo(ResetPasswordResponseVO.class);
  }

  /**
   * 忘记密码
   */
  public BaseRes forgetPassword(ForgetPasswordRequestVO basePasswordVO, String secret)
      throws Exception {
    final String path = "/api/forgetPassword";
    return HttpUtil
        .post(AnnotationUtil
            .buildReq(Config.BASE_URL + path, setCommonParams(basePasswordVO), secret))
        .castTo(ResetPasswordResponseVO.class);
  }


}
