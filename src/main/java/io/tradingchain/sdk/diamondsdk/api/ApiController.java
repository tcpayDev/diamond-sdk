package io.tradingchain.sdk.diamondsdk.api;

import static io.tradingchain.sdk.diamondsdk.config.Config.setCommonParams;
import static io.tradingchain.sdk.diamondsdk.config.Config.setOtcCommonParams;

import com.alibaba.fastjson.JSON;
import io.tradingchain.sdk.diamondsdk.account.AccountDetailsReq;
import io.tradingchain.sdk.diamondsdk.account.AccountDetailsResp;
import io.tradingchain.sdk.diamondsdk.config.Config;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateRes;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateReq;
import io.tradingchain.sdk.diamondsdk.exchangeRate.OrderBookRes;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersReq;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersRes;
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
import io.tradingchain.sdk.diamondsdk.regist.UserReq;
import io.tradingchain.sdk.diamondsdk.regist.UserResp;
import io.tradingchain.sdk.diamondsdk.response.BaseVO;
import io.tradingchain.sdk.diamondsdk.util.AnnotationUtil;
import io.tradingchain.sdk.diamondsdk.util.HttpUtil;
import io.tradingchain.sdk.diamondsdk.util.HttpUtil.Response;
import java.math.BigDecimal;
import java.util.TreeMap;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  /**
   * 注册前获取备份私钥
   */
  public BeforeRegisterResp beforeRegister(BeforeRegisterReq req) throws Exception {
    final String path = "/api/getKeyBeforeRegister";
    return HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), Config.SECRET))
        .castTo(BeforeRegisterResp.class);
  }


  /**
   * 注册接口
   *
   * @param req 请求体
   * @param type 操作方式 1: 安卓; 2: IOS
   */
  public RegisterResOTC register(RegistReq req, String type) throws Exception {
    final String path = "/api/registUser2";
    //注册1
    RegisterRes res = HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), Config.SECRET))
        .castTo(RegisterRes.class);
    if (res.code == 0) {
      //去OTC做相应注册
      return userAdd(req, res, type);
    } else {
      return new RegisterResOTC(res.msg);
    }
  }


  /**
   * OTC注册接口
   */
  private RegisterResOTC userAdd(RegistReq req, RegisterRes res, String type)throws Exception {
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
        //生成签名参数
        TreeMap treeMap = new TreeMap();
        treeMap.put("mobile", req.phone);
        treeMap.put("loginPass", req.password);
        treeMap.put("tradePassword", req.tradePassword);
        treeMap.put("privateKey", req.privateKey);
        treeMap.put("exUserId", res.data.userId + "");
        treeMap.put("publicKey", res.data.publicKey);
        treeMap.put("inviteCode", res.data.inviteCode);
        treeMap.put("idCard", req.phone);
        treeMap.put("userName", req.username);
        treeMap.put("nickName", req.username);
        treeMap.put("accessToken", userReq.accessToken);
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
                Config.OTC_SECRET,treeMap)).castTo(UserResp.class);
        if (user.resCode.equals("C502570000000")) {
          System.out.println(res.data.publicKey);
          return new RegisterResOTC(res,user);
        } else {
          return new RegisterResOTC(user.resMsg);
        }
      }else {
        return new RegisterResOTC(queryUserResp.resMsg);
      }
    }else {
      return  new RegisterResOTC(queryUserResp.resMsg);
    }
  }


  /**
   * 用户查询接口
   */
  public QueryUserResp queryUser(QueryUserReq req) throws Exception {
    final String path = "/api/user/query";
    TreeMap treeMap = new TreeMap();
    treeMap.put("mobile", req.mobile);
    treeMap.put("accessToken", req.accessToken);
    return HttpUtil
        .post(AnnotationUtil
            .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req), Config.OTC_SECRET,
                treeMap)) .castTo(QueryUserResp.class);
  }

  /**
   * 账户详情接口
   */
  public AccountDetailsResp accountDetails(AccountDetailsReq req) throws Exception {
    final String path = "/find/account";
    return HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), Config.SECRET))
        .castTo(AccountDetailsResp.class);
  }

  /**
   * 获取汇率
   *
   * @param req 请求体
   * @param type buy(买入)/sell(卖出)
   */
  public ExchangeRateRes exchangeRate(ExchangeRateReq req, String type) throws Exception {
    final String path = "/find/tradeDepth";
    OrderBookRes rateReq = HttpUtil
        .post(AnnotationUtil.buildReq(Config.BASE_URL + path, setCommonParams(req), Config.SECRET))
        .castTo(OrderBookRes.class);
    BigDecimal rate = BigDecimal.ZERO;
    if ("buy".equals(type)) {
      rate = rateReq.bids[0][0];
    } else {
      rate = rateReq.asks[0][0];
    }
    // TODO 获取OTC最新的汇率

    //计算DB-USDT的最终汇率

    //信任币种

    return new ExchangeRateRes();
  }


  /**
   * 查询商家挂单
   *
   * @param req 请求体
   */
  public OtcPostersRes moneyMerchantInfo(OtcPostersReq req) throws Exception {
    final String path = "/api/fiatTrade/queryOffers";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET, treeMap)).castTo(OtcPostersRes.class);
  }

  /**
   * 收款方式设置信息提交
   *
   * @param req 请求体
   */
  public AddPaymentResp addPayment(AddPaymentReq req) throws Exception {
    final String path = "/api/info/receive/add";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    treeMap.put("receiveType", req.receiveType);
    treeMap.put("name", req.name);
    treeMap.put("accountNo", req.accountNo);
    treeMap.put("userId", req.userId);
    return HttpUtil.postForm(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET, treeMap)).castTo(AddPaymentResp.class);
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
            Config.OTC_SECRET, treeMap)).castTo(QueryPaymentResp.class);
  }

  /**
   * 删除收款方式
   *
   * @param req 请求体
   */
  public DelPaymentResp delReceive(DelPaymentReq req) throws Exception {
    final String path = "/api/info/receive/delReceive";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    treeMap.put("id", req.id);
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET, treeMap)).castTo(DelPaymentResp.class);
  }


  /**
   * 创建订单
   *
   * @param req 请求体
   */
  public CreateOrderResp createOrder(CreateOrderReq req) throws Exception {
    final String path = "/api/fiatTrade/create";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    treeMap.put("offerOrderNo", req.offerOrderNo);
    treeMap.put("quantity", req.quantity);
    treeMap.put("price", req.price);
    treeMap.put("amount", req.amount);
    treeMap.put("type", req.type);
    treeMap.put("userId", req.userId);
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET, treeMap)).castTo(CreateOrderResp.class);
  }


  /**
   * 取消订单
   *
   * @param req 请求体
   */
  public CancelOrderResp cancelOrder(CancelOrderReq req) throws Exception {
    final String path = "/api/fiatTrade/cancel";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    treeMap.put("orderNo", req.orderNo);
    treeMap.put("userId", req.userId);
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET, treeMap)).castTo(CancelOrderResp.class);
  }

  /**
   * 确认付款
   *
   * @param req 请求体
   */
  public ConfirmPayResp confirmPay(ConfirmPayReq req) throws Exception {
    final String path = "/api/fiatTrade/pay";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    treeMap.put("orderNo", req.orderNo);
    treeMap.put("userId", req.userId);
    treeMap.put("payMode", req.payMode);
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET, treeMap)).castTo(ConfirmPayResp.class);
  }

  /**
   * 交易申诉
   *
   * @param req 请求体
   */
  public FiatTradeAppealResp fiatTradeAppeal(FiatTradeAppealReq req) throws Exception {
    final String path = "/api/fiatTrade/appeal";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    treeMap.put("orderNo", req.orderNo);
    treeMap.put("userId", req.userId);
    return HttpUtil.postForm(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET, treeMap)).castTo(FiatTradeAppealResp.class);
  }


  /**
   * 订单列表查询
   *
   * @param req 请求体
   */
  public QueryOrderListResp orderList(QueryOrderListReq req) throws Exception {
    final String path = "/api/fiatTrade/query";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    treeMap.put("userId", req.userId);
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET, treeMap)).castTo(QueryOrderListResp.class);
  }


  /**
   * 查询单个收款方式信息
   *
   * @param req 请求体
   */
  public QueryFiatTradeReceiveResp queryReceive(QueryFiatTradeReceiveReq req) throws Exception {
    final String path = "/api/fiatTrade/queryReceives";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    treeMap.put("userId", req.userId);
    treeMap.put("payMode", req.payMode);
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET, treeMap)).castTo(QueryFiatTradeReceiveResp.class);
  }


  /**
   * 查询单个订单洗信息
   *
   * @param req 请求体
   */
  public QueryOrderResp orderInfo(QueryOrderReq req) throws Exception {
    final String path = "/api/fiatTrade/queryByOrderNo";
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", req.accessToken);
    treeMap.put("userId", req.userId);
    return HttpUtil.post(AnnotationUtil
        .buildReq(Config.OTC_BASE_URL + path, setOtcCommonParams(req),
            Config.OTC_SECRET, treeMap)).castTo(QueryOrderResp.class);
  }
}
