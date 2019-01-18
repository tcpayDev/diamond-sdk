package io.tradingchain.sdk.diamondsdk;

import com.alibaba.fastjson.JSON;
import io.tradingchain.sdk.diamondsdk.account.AccountDetailsReq;
import io.tradingchain.sdk.diamondsdk.api.DiamondService;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateRes;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeReq;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersReq;
import io.tradingchain.sdk.diamondsdk.order.*;
import io.tradingchain.sdk.diamondsdk.payment.ChargeCollectTransferReq;
import io.tradingchain.sdk.diamondsdk.payment.ChargeCollectTransferResp;
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveReq;
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveResp;
import io.tradingchain.sdk.diamondsdk.regist.*;
import io.tradingchain.sdk.diamondsdk.response.BaseRes;
import io.tradingchain.sdk.diamondsdk.response.BaseVO;
import io.tradingchain.sdk.diamondsdk.trustAsset.AssetPair;
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
    req.apiKey = "tradingchain";
    BeforeRegisterResp resp = DiamondService.beforeRegister(req, "");
    System.out.println(JSON.toJSONString(resp));
  }

  @Test
  public void register() throws Exception {
    RegistReq registReq = new RegistReq();
    registReq.apiKey = "tradingchain";
    registReq.username = "15966668889";
    registReq.password = "12345678";
    registReq.phone = "15966668889";
    registReq.platform = "tradingchain_test";
    registReq.privateKey = "SA7EAP4IA4G5GEITLW2RIESPZQ2DAZZBTNWO7JAS3VWBP6DIEQQF4EYO";
    registReq.backupKey = "SANFDFZ56TJTRHN26K3MIYDHVSSGGAIJJVP4XYVDPDSM2KW5DAWMN5KS";
    registReq.tradePassword = "123456";
    RegisterResOTC register = DiamondService.register(registReq, "1", "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm");
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
    registReq.tradeType = "sell";
    registReq.amount = BigDecimal.ONE;
    registReq.payMode = "bank,alipay";
    registReq.assetCode = "usdt";
    registReq.page = 1;
    registReq.pageSize = 10;
    registReq.operSysType = "1";
    BaseVO vos = DiamondService.moneyMerchantInfo(registReq);
    System.out.println(JSON.toJSONString(vos));
  }


  @Test
  public void queryUser() throws Exception {
    QueryUserReq registReq = new QueryUserReq();
    registReq.operSysType = "1";
    registReq.mobile = "18969099987";
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
  public void createOrder() throws Exception {
    CreateOrderReq registReq = new CreateOrderReq();
    registReq.offerOrderNo = "90005181102172044000027";
    registReq.quantity = "0.4007827";
    registReq.price = "200";
    registReq.amount = "80.1565400";
    registReq.type = "sell";
    registReq.operSysType = "1";
    registReq.userId = "c2d81d064e684c989233562c23d2dc0b";
    CreateOrderResp resp = DiamondService.createOrder(registReq);
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
    registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
    QueryOrderListResp resp = DiamondService.orderList(registReq);
    System.out.println(JSON.toJSONString(resp));
  }

  @Test
  public void queryReceive() throws Exception {
    QueryFiatTradeReceiveReq registReq = new QueryFiatTradeReceiveReq();
    registReq.operSysType = "1";
    registReq.payMode = "alipay";
    registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
    QueryFiatTradeReceiveResp resp = DiamondService.queryReceive(registReq);
    System.out.println(JSON.toJSONString(resp));
  }


  @Test
  public void orderInfo() throws Exception {
    QueryOrderReq registReq = new QueryOrderReq();
    registReq.operSysType = "2";
    registReq.orderNo = "90005181102172044000027";
    registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
    QueryOrderResp resp = DiamondService.orderInfo(registReq);
    System.out.println(JSON.toJSONString(resp));
  }


  @Test
  public void exchangeRate() throws Exception {

    ExchangeReq exchangeReq = new ExchangeReq();
    exchangeReq.apiKey = "tradingchain";
    exchangeReq.baseAsset = "BTC";
    exchangeReq.baseAssetIssuer = "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
    exchangeReq.counterAsset = "USDT";
    exchangeReq.counterAssetIssuer = "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
    exchangeReq.size = 1;
    List<AssetPair> list = new ArrayList<>();
    list.add(new AssetPair("USDT", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    list.add(new AssetPair("BTC", "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    exchangeReq.apiKey = "tradingchain";
    exchangeReq.username = "15922222234";
    exchangeReq.privateKey = "SBC2WDTSXF55ZRUBYVHXI6S7UDKYUADUQTKGC52ILWC4O4ML5HZBDNCR";
    exchangeReq.list = list;
    exchangeReq.operSysType = "1";
    ExchangeRateRes rateRes = DiamondService.exchangeRate(exchangeReq, "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm");
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
}

