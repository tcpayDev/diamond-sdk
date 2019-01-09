package io.tradingchain.sdk.diamondsdk;

import com.alibaba.fastjson.JSON;
import io.tradingchain.sdk.diamondsdk.api.DiamondService;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateRes;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeReq;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersReq;
import io.tradingchain.sdk.diamondsdk.order.CreateOrderReq;
import io.tradingchain.sdk.diamondsdk.order.CreateOrderResp;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderListReq;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderListResp;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderReq;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderResp;
import io.tradingchain.sdk.diamondsdk.pathPayment.DoPathPaymentReq;
import io.tradingchain.sdk.diamondsdk.payment.AddPaymentReq;
import io.tradingchain.sdk.diamondsdk.payment.AddPaymentResp;
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveReq;
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveResp;
import io.tradingchain.sdk.diamondsdk.regist.BeforeRegisterReq;
import io.tradingchain.sdk.diamondsdk.regist.BeforeRegisterResp;
import io.tradingchain.sdk.diamondsdk.regist.RegistReq;
import io.tradingchain.sdk.diamondsdk.regist.RegisterResOTC;
import io.tradingchain.sdk.diamondsdk.response.BaseVO;
import io.tradingchain.sdk.diamondsdk.trustAsset.AssetPair;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class DiamondSdkApplicationTests {

  DiamondService DiamondService = new DiamondService();

  @Test
  public void contextLoads() {
  }



  @Test
  public void beforeRegister() throws Exception {
    BeforeRegisterReq req = new BeforeRegisterReq();
    req.apiKey = "tradingchain";
    BeforeRegisterResp resp = DiamondService.beforeRegister(req);
    System.out.println(JSON.toJSONString(resp));
  }

  @Test
  public void register() throws Exception {
    RegistReq registReq = new RegistReq();
    registReq.apiKey = "tradingchain";
    registReq.username = "15966668888";
    registReq.password = "12345678";
    registReq.phone = "15966668888";
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
      //System.out.println("");
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
    //System.out.println(vos);
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
      public void queryUser() throws Exception {
        QueryUserReq registReq = new QueryUserReq();
        registReq.operSysType = "1";
        registReq.mobile = "15922222232";
        QueryUserResp resp = DiamondService.queryUser(registReq);
        //System.out.println(resp);
      }



      @Test
      public void findPayments() throws Exception {
        QueryPaymentReq registReq = new QueryPaymentReq();
        registReq.operSysType = "1";
        registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
        QueryPaymentResp resp = DiamondService.findPayments(registReq);
        //System.out.println(resp);
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
    System.out.println(resp);
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
    System.out.println(resp);
  }

  /*
      @Test
      public void cancelOrder() throws Exception {
        CancelOrderReq registReq = new CancelOrderReq();
        registReq.orderNo = "99110190104184625000002";
        registReq.operSysType = "1";
        registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
        CancelOrderResp resp = DiamondService.cancelOrder(registReq);
        //System.out.println(resp);
      }

      @Test
      public void fiatTradeAppeal() throws Exception {
        FiatTradeAppealReq registReq = new FiatTradeAppealReq();
        registReq.orderNo = "99110190104184625000002";
        registReq.appealRemark = "test";
        registReq.operSysType = "1";
        registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
        FiatTradeAppealResp resp = DiamondService.fiatTradeAppeal(registReq);
        //System.out.println(resp);
      }
    */
  @Test
  public void orderList() throws Exception {
    QueryOrderListReq registReq = new QueryOrderListReq();
    registReq.operSysType = "1";
    registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
    QueryOrderListResp resp = DiamondService.orderList(registReq);
    //System.out.println(resp);
  }

  @Test
  public void queryReceive() throws Exception {
    QueryFiatTradeReceiveReq registReq = new QueryFiatTradeReceiveReq();
    registReq.operSysType = "1";
    registReq.payMode = "alipay";
    registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
    QueryFiatTradeReceiveResp resp = DiamondService.queryReceive(registReq);
    //System.out.println(resp);
  }


  @Test
  public void orderInfo() throws Exception {
    QueryOrderReq registReq = new QueryOrderReq();
    registReq.operSysType = "2";
    registReq.orderNo = "90005181102172044000027";
    registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
    QueryOrderResp resp = DiamondService.orderInfo(registReq);
    System.out.println(resp);
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
    ExchangeRateRes rateRes = DiamondService.exchangeRate(exchangeReq,"");
    Thread.sleep(15000);
    System.out.println(rateRes);
  }

  @Test
  public void doPathPaymentFreightCollect() throws Exception {
    //String username, String tradePassword, String sourceAmount, String sourceAssetName, String sourceAssetIssuer,
    // String destinationAmount, String destinationAssetName, String destinationAssetIssuer, String destination,
    // String privateKey, String backupKey
    DoPathPaymentReq registReq = DoPathPaymentReq.getInstanceByPrivateKey("15922222234","123456","0.0001000",
        "BTC","GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG",
        "0.4007827","USDT","GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG",
        "GAYEHYYEMTLQMUJGIRSWZDOF6CE5ESBYV5SV2YNJLAKKDMVECWY7ZAWR","SBC2WDTSXF55ZRUBYVHXI6S7UDKYUADUQTKGC52ILWC4O4ML5HZBDNCR");
    BaseVO baseVO = DiamondService.doPathPaymentFreightCollect(registReq,"");
    System.out.println(baseVO);
  }

}

