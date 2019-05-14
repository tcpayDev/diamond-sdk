package io.tradingchain.sdk.diamondsdk;

import static io.tradingchain.sdk.diamondsdk.config.Config.setCommonParams;

import com.alibaba.fastjson.JSON;
import io.tradingchain.sdk.diamondsdk.account.AccountDetailsReq;
import io.tradingchain.sdk.diamondsdk.api.DiamondService;
import io.tradingchain.sdk.diamondsdk.config.Config;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateRes;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeReq;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersReq;
import io.tradingchain.sdk.diamondsdk.order.*;
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
import io.tradingchain.sdk.diamondsdk.regist.*;
import io.tradingchain.sdk.diamondsdk.response.BaseRes;
import io.tradingchain.sdk.diamondsdk.response.BaseVO;
import io.tradingchain.sdk.diamondsdk.trustAsset.AssetPair;
import io.tradingchain.sdk.diamondsdk.util.AnnotationUtil;
import io.tradingchain.sdk.diamondsdk.util.HttpUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Ignore
public class DiamondSdkApplicationTests {

  DiamondService DiamondService = new DiamondService();

  @Test
  public void beforeRegister() throws Exception {
    BeforeRegisterReq req = new BeforeRegisterReq();
    req.apiKey = "chenyu";
    BeforeRegisterResp resp = DiamondService.beforeRegister(req, "2fb756b5284847f19fa3160a43f149e9");
    System.out.println(JSON.toJSONString(resp));
  }

  @Test
  public void register() throws Exception {
    RegistReq registReq = new RegistReq();
    registReq.apiKey = "chenyu";
    registReq.username = "88888888888";
    registReq.password = "12345678";
    registReq.phone = "88888888888";
    registReq.platform = "tradingchain";
    registReq.privateKey = "SAYIAJFURBNZB6TZC33ASK64SCXJHDN6AB2EBLXGDJ622PPNMGFZFLSG";
    registReq.backupKey = "SASHJYOSGC3LB6Z7N5NIPL4Y6RH7V7X3WHREQ7IV3PD3O3ILJDYQRV3Y";
    registReq.tradePassword = "123456";
    RegisterResOTC register = DiamondService.register(registReq, "1", "2fb756b5284847f19fa3160a43f149e9");
    System.out.println(register);
  }

  /*
    @Test
    public void accountDetails() throws Exception {
      AccountDetailsReq registReq = new AccountDetailsReq();
      registReq.apiKey = "tradingchain";
      registReq.username = "15921863925";
      registReq.password = "12345678";
      registReq.platform = "tradingchain_test";
      registReq.counterAssetName = "USDT";
      registReq.counterAssetIssuer = "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
      AccountDetailsResp resp = DiamondService.accountDetails(registReq);
      System.out.println("");
    }
*/
//
//    @Test
//    public void exchangeRate() throws Exception {
//      ExchangeRateReq registReq = new ExchangeRateReq();
//      registReq.apiKey = "tradingchain";
//      registReq.baseAsset = "BTC";
//      registReq.baseAssetIssuer = "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
//      registReq.counterAsset = "USDT";
//      registReq.counterAssetIssuer = "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
//      registReq.size = 2;
//      registReq.sign = "";
//
//
//
//      ExchangeRateRes rateRes = DiamondService.exchangeRate(registReq, "buy");
//      System.out.println(rateRes);
//    }

  @Test
  public void moneyMerchantInfo() throws Exception {
    OtcPostersReq registReq = new OtcPostersReq();
    registReq.tradeType = "buy";
//    registReq.amount = new BigDecimal("100");
//    registReq.payMode = "alipay,bank,wepay";
//    registReq.assetCode = "USDT";
    registReq.page = 1;
    registReq.pageSize = 100;
    registReq.operSysType = "1";
    BaseVO vos = DiamondService.moneyMerchantOrder(registReq);
    System.out.println(JSON.toJSONString(vos));
  }


  @Test
  public void queryUser() throws Exception {
    QueryUserReq registReq = new QueryUserReq();
    registReq.operSysType = "1";
    registReq.mobile = "15922222234";
    QueryUserResp resp = DiamondService.queryUser(registReq);
    System.out.println(JSON.toJSONString(resp));
  }

  /*
      @Test
      public void moneyMerchantOrder() throws Exception {
        OtcPostersReq registReq = new OtcPostersReq();
        registReq.tradeType = "buy";
        registReq.amount = BigDecimal.ONE;
        registReq.payMode = "bank,alipay";
        registReq.assetCode = "usdt";
        registReq.page = 1;
        registReq.pageSize = 10;
        registReq.operSysType = "1";
        BaseVO vos = DiamondService.moneyMerchantOrder(registReq);
        System.out.println(vos);
      }
  /*




      @Test
      public void findPayments() throws Exception {
        QueryPaymentReq registReq = new QueryPaymentReq();
        registReq.operSysType = "1";
        registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
        QueryPaymentResp resp = DiamondService.findPayments(registReq);
        System.out.println(JSON.toJSONString(resp));
      }
 @Test
  public void addPayment() throws Exception {
    AddPaymentReq registReq = new AddPaymentReq();
    registReq.accountNo = "123456";
    registReq.name = "燕子李三";
    registReq.receiveType = "alipay";
    registReq.operSysType = "1";
    registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
    AddPaymentResp resp = DiamondService.addPayment(registReq);
    System.out.println(JSON.toJSONString(resp));
  }

  */


  @Test
  public void addPayment() throws Exception {
    //tring receiveType, String name, String accountNo, String bankName,String bankAddr, File appealFile, String userId, String operSysType
    AddPaymentReq registReq = new AddPaymentReq("alipay","bwb","123456",
        "7ab3ccd3a2d54a57add1949e19030253","1");
    AddPaymentResp resp = DiamondService.addPayment(registReq);
    System.out.println(JSON.toJSONString(resp));
  }


  @Test
  public void findPayments() throws Exception {
    QueryPaymentReq registReq = new QueryPaymentReq();
    registReq.operSysType = "1";
    registReq.userId = "3a0b239f2b0540ffa6faaa1e67741b48";
    QueryPaymentResp resp = DiamondService.findPayments(registReq);
    System.out.println(JSON.toJSONString(resp));
  }

  @Test
  public void createOrder() throws Exception {
    CreateOrderReq registReq = new CreateOrderReq();
    registReq.offerOrderNo = "90005190120124109000204";
    registReq.quantity = "1.3549356";
    registReq.price = "6.85";
    registReq.amount = "9.27";
    registReq.type = "sell";
    registReq.operSysType = "2";
    registReq.userId = "6a07c3f139ee4eb49d6d69720e609bbd";
    CreateOrderResp resp = DiamondService.createOrder(registReq);
    System.out.println(JSON.toJSONString(resp));
  }


  @Test
  public void delReceive() throws Exception {
    DelPaymentReq registReq = new DelPaymentReq("235","2","6239bf05346e41f486f555bb92652fa5");

    DelPaymentResp resp = DiamondService.delReceive(registReq);
    System.out.println(JSON.toJSONString(resp));
  }

  /*
      @Test
      public void cancelOrder() throws Exception {
        CancelOrderReq registReq = new CancelOrderReq();
        registReq.orderNo = "99110190104184625000002";
        registReq.operSysType = "1";
        registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
        CancelOrderResp resp = DiamondService.cancelOrder(registReq);
        System.out.println(JSON.toJSONString(resp));
      }

      @Test
      public void fiatTradeAppeal() throws Exception {
        FiatTradeAppealReq registReq = new FiatTradeAppealReq();
        registReq.orderNo = "99110190104184625000002";
        registReq.appealRemark = "test";
        registReq.operSysType = "1";
        registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
        FiatTradeAppealResp resp = DiamondService.fiatTradeAppeal(registReq);
        System.out.println(JSON.toJSONString(resp));
      }
    */
  @Test
  public void orderList() throws Exception {
    QueryOrderListReq registReq = new QueryOrderListReq();
    registReq.operSysType = "1";
    registReq.userId = "5f57e5db4a244ef0ac05c88986dafaba";
    QueryOrderListResp resp = DiamondService.orderList(registReq);
    System.out.println(JSON.toJSONString(resp));
  }

  @Test
  public void queryReceive() throws Exception {
    QueryFiatTradeReceiveReq registReq = new QueryFiatTradeReceiveReq();
    registReq.operSysType = "1";
    registReq.payMode = "bank";
    registReq.userId = "f8803ef976c2491d8b7fb94f5cd71019";
    QueryFiatTradeReceiveResp resp = DiamondService.queryReceive(registReq);
    System.out.println(JSON.toJSONString(resp));
  }


  @Test
  public void exchangeRate() throws Exception {

    ExchangeReq exchangeReq = new ExchangeReq();
    exchangeReq.apiKey = "hxbapp";
    exchangeReq.baseAsset = "hxb";
    exchangeReq.baseAssetIssuer = "GCTK3HEOXEH2J6W5BFV62Q5PWTS34TK6SYV74YKZ2XSZW6F45TSJPLF2";
    exchangeReq.counterAsset = "USDT";
    exchangeReq.counterAssetIssuer = "GCTK3HEOXEH2J6W5BFV62Q5PWTS34TK6SYV74YKZ2XSZW6F45TSJPLF2";
    exchangeReq.size = 1;
    List<AssetPair> list = new ArrayList<>();
    list.add(new AssetPair("USDT", "GCTK3HEOXEH2J6W5BFV62Q5PWTS34TK6SYV74YKZ2XSZW6F45TSJPLF2"));
    list.add(new AssetPair("hxb", "GCTK3HEOXEH2J6W5BFV62Q5PWTS34TK6SYV74YKZ2XSZW6F45TSJPLF2"));
    exchangeReq.apiKey = "hxbapp";
    exchangeReq.username = "hxb001";
    exchangeReq.privateKey = "SDSF4NU2OWV4FZL576RIEMET3KHK2MOIBFLC3RPLISINDYOXSFWOOQXF";
    exchangeReq.list = list;
    exchangeReq.operSysType = "1";
    ExchangeRateRes rateRes = DiamondService.exchangeRate(exchangeReq, "hGO0GY9ZMPXQSDcKj7yHmknkJaKD3BY0");
    Thread.sleep(15000);
    System.out.println(JSON.toJSONString(rateRes));
  }

//  @Test
//  public void doPathPaymentFreightCollect() throws Exception {
//    //String username, String tradePassword, String sourceAmount, String sourceAssetName, String sourceAssetIssuer,
//    // String destinationAmount, String destinationAssetName, String destinationAssetIssuer, String destination,
//    // String privateKey, String backupKey
//    DoPathPaymentReq registReq = DoPathPaymentReq.getInstanceByPrivateKey("tradingchain_test","15922222234", "123456", "0.0001000",
//            "BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG",
//            "0.4007827", "USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG",
//            "GAYEHYYEMTLQMUJGIRSWZDOF6CE5ESBYV5SV2YNJLAKKDMVECWY7ZAWR", "SBC2WDTSXF55ZRUBYVHXI6S7UDKYUADUQTKGC52ILWC4O4ML5HZBDNCR");
//    BaseVO baseVO = DiamondService.doPathPaymentFreightCollect(registReq, "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm");
//    System.out.println(JSON.toJSONString(baseVO));
//  }

  @Test
  public void freightCollectTransfer() throws Exception {
    //String username, String tradePassword, String privateKey, String amount, String assetName, String assetIssuer, String destination
    ChargeCollectTransferReq chargeCollectTransferReq = ChargeCollectTransferReq.getInstanceByPrivateKey("tradingchain_hg", "hgapp", "test10002",
            "000000", "SD4ULE6JLPUVB3I5FADCKOOOX7E7X52ISEDPGI2ASDVD36IST53I42QS", "0.0001",
            "HGD", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG", "GCNUUCAWTBNUHVK4DCQ4V4NMJKKPGJ6KJSJEVPVZWKUFJQ7LI5QXZW3U");

    ChargeCollectTransferResp collectTransferResp = DiamondService
            .freightCollectTransfer(chargeCollectTransferReq, "DyiYRda1sttXO6kmLTBlhzk3UEiEzuOU");


    System.out.println(JSON.toJSONString(collectTransferResp));
  }


  @Test
  public void resetPassword() throws Exception {
    ResetPasswordRequestVO requestVO = new ResetPasswordRequestVO("15921863921", "tradingchain_test",
            "tradingchain", "P", "12345678", "11111111");
    BaseRes baseRes = DiamondService.resetPassword(requestVO, "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm");

    System.out.println(JSON.toJSONString(baseRes));
  }


  @Test
  public void confirmPay() throws Exception {
    ConfirmPayReq confirmPayReq = new ConfirmPayReq("99110190403172342000450","alipay",
        "668b91490dc346c7978e62cb7a8cad99","1");

    ConfirmPayResp payResp = DiamondService.confirmPay(confirmPayReq);

    System.out.println(JSON.toJSONString(payResp));
  }


//  @Test
//  public void fiatTradeGrant() throws Exception {
//    TradeGrantReq tradeGrantReq = new TradeGrantReq();
//    tradeGrantReq.operSysType="1";
//    tradeGrantReq.orderNo="99110190412165918000067";
//    tradeGrantReq.userId="bf735a2da0ba4c9da18ec4b41650c33d";
//    BaseVO baseVO = DiamondService.fiatTradeGrant(tradeGrantReq);
//
//    System.out.println(JSON.toJSONString(baseVO));
//  }


  @Test
  public void orderInfo() throws Exception {
    QueryOrderReq registReq = new QueryOrderReq();
    registReq.operSysType = "2";
    registReq.orderNo = "99110190514202239002597";//99110190314202543001371 //99110190314203150001373
    registReq.userId = "3ecffc4f25c343539b89541b7aaa419d";
    QueryOrderResp resp = DiamondService.orderInfo(registReq);
    System.out.println(resp);
  }


  @Test
  public void forgetPassword() throws Exception {
    ForgetPasswordRequestVO requestVO = new ForgetPasswordRequestVO("15921863921", "22222222",
            "tradingchain_test", "tradingchain", "P");
    BaseRes baseRes = DiamondService.forgetPassword(requestVO, "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm");

    System.out.println(JSON.toJSONString(baseRes));
  }

  @Test
  public void accountDetails() throws Exception {
    AccountDetailsReq accountDetailsReq = new AccountDetailsReq();
    accountDetailsReq.counterAssetName = "USDT";
    accountDetailsReq.counterAssetIssuer = "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
    accountDetailsReq.platform = "tradingchain_mon";
    accountDetailsReq.username = "17724502010";
    accountDetailsReq.password = "2546721670";
    accountDetailsReq.apiKey = "monpp";
    BaseRes baseRes = DiamondService.accountDetails(accountDetailsReq, "6JLVJp0GhYOq44SUWACXl3jKArY32bUE");

    System.out.println(JSON.toJSONString(baseRes));
  }

  public static void main(String[] args) throws Exception{
    AttributeReqVO attributeReqVO = new AttributeReqVO();
    attributeReqVO.unitPrice="6.11";
    attributeReqVO.amount="1000";
    attributeReqVO.totalPrice="6800";
    attributeReqVO.minPrice="0.01";
    attributeReqVO.maxPrice="500";
    attributeReqVO.postType="sell";
    attributeReqVO.currency="USDT";
    attributeReqVO.userId="3a0b239f2b0540ffa6faaa1e67741b48";
    attributeReqVO.operSysType="1";
//    attributeReqVO.password="12345678";
    ResetPasswordResponseVO responseVO = HttpUtil
        .post(AnnotationUtil
            .buildReq(Config.OTC_BASE_URL + "/api/posters/commit", attributeReqVO,"iaM43PnzzfY6Xdeo"))
        .castTo(ResetPasswordResponseVO.class);

    System.out.println(responseVO);
  }

}

