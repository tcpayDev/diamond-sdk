package io.tradingchain.sdk.diamondsdk;

import io.tradingchain.sdk.diamondsdk.api.DiamondService;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateReq;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateRes;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderListReq;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderListResp;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderReq;
import io.tradingchain.sdk.diamondsdk.order.QueryOrderResp;
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveReq;
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveResp;
import io.tradingchain.sdk.diamondsdk.regist.BeforeRegisterReq;
import io.tradingchain.sdk.diamondsdk.regist.BeforeRegisterResp;
import io.tradingchain.sdk.diamondsdk.regist.RegistReq;
import io.tradingchain.sdk.diamondsdk.regist.RegisterResOTC;
import io.tradingchain.sdk.diamondsdk.trustAsset.AssetPair;
import io.tradingchain.sdk.diamondsdk.trustAsset.AssetsTrustReq;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class DiamondSdkApplicationTests {

  DiamondService DiamondService = new DiamondService();

  @Test
  public void contextLoads() {
  }


  @Test
  public void beforeRegister() throws Exception {
    BeforeRegisterReq req = new BeforeRegisterReq();
    req.apiKey = "tradingchain";
    BeforeRegisterResp register = DiamondService.beforeRegister(req);
    System.out.println(register.data);
  }


  @Test
  public void register() throws Exception {
    RegistReq registReq = new RegistReq();
    registReq.apiKey = "tradingchain";
    registReq.username = "15922222234";
    registReq.password = "12345678";
    registReq.phone = "15922222234";
    registReq.platform = "tradingchain_test";
    registReq.privateKey = "SBC2WDTSXF55ZRUBYVHXI6S7UDKYUADUQTKGC52ILWC4O4ML5HZBDNCR";
    registReq.backupKey = "SA5OSGDABAZQBLPVHRJD65OBS6NK7L2LSJ6LDO64TBINPIPJSEJ364UH";
    registReq.tradePassword = "123456";
    RegisterResOTC register = DiamondService.register(registReq, "1");
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


    @Test
    public void exchangeRate() throws Exception {
      ExchangeRateReq registReq = new ExchangeRateReq();
      registReq.apiKey = "tradingchain";
      registReq.baseAsset = "BTC";
      registReq.baseAssetIssuer = "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
      registReq.counterAsset = "USDT";
      registReq.counterAssetIssuer = "GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
      registReq.size = 2;
      registReq.sign = "";
      ExchangeRateRes rateRes = DiamondService.exchangeRate(registReq, "buy");
      System.out.println(rateRes);
    }

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
      System.out.println(vos);
    }


    @Test
    public void moneyMerchantOrder() throws Exception {
      OtcPostersReq registReq = new OtcPostersReq();
      registReq.tradeType = "sell";
      registReq.amount = BigDecimal.ONE;
      registReq.payMode = "bank,alipay";
      registReq.assetCode = "usdt";
      registReq.page = 1;
      registReq.pageSize = 10;
      registReq.operSysType = "1";
      BaseVO vos = DiamondService.moneyMerchantOrder(registReq);
      System.out.println(vos);
    }

    @Test
    public void queryUser() throws Exception {
      QueryUserReq registReq = new QueryUserReq();
      registReq.operSysType = "1";
      registReq.mobile = "15922222232";
      QueryUserResp resp = DiamondService.queryUser(registReq);
      System.out.println(resp);
    }


    @Test
    public void addPayment() throws Exception {
      AddPaymentReq registReq = new AddPaymentReq();
      registReq.accountNo = "123456";
      registReq.name = "test";
      registReq.receiveType = "alipay";
      registReq.operSysType = "1";
      registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
      AddPaymentResp resp = DiamondService.addPayment(registReq);
      System.out.println(resp);
    }

    @Test
    public void findPayments() throws Exception {
      QueryPaymentReq registReq = new QueryPaymentReq();
      registReq.operSysType = "1";
      registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
      QueryPaymentResp resp = DiamondService.findPayments(registReq);
      System.out.println(resp);
    }


    @Test
    public void createOrder() throws Exception {
      CreateOrderReq registReq = new CreateOrderReq();
      registReq.offerOrderNo = "90005181108103627000109";
      registReq.quantity = "0.01";
      registReq.price = "88.8";
      registReq.amount = "30";
      registReq.type = "buy";
      registReq.operSysType = "1";
      registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
      CreateOrderResp resp = DiamondService.createOrder(registReq);
      System.out.println(resp);
    }

    @Test
    public void cancelOrder() throws Exception {
      CancelOrderReq registReq = new CancelOrderReq();
      registReq.orderNo = "99110190104184625000002";
      registReq.operSysType = "1";
      registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
      CancelOrderResp resp = DiamondService.cancelOrder(registReq);
      System.out.println(resp);
    }

    @Test
    public void fiatTradeAppeal() throws Exception {
      FiatTradeAppealReq registReq = new FiatTradeAppealReq();
      registReq.orderNo = "99110190104184625000002";
      registReq.appealRemark = "test";
      registReq.operSysType = "1";
      registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
      FiatTradeAppealResp resp = DiamondService.fiatTradeAppeal(registReq);
      System.out.println(resp);
    }
  */
  @Test
  public void orderList() throws Exception {
    QueryOrderListReq registReq = new QueryOrderListReq();
    registReq.operSysType = "1";
    registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
    QueryOrderListResp resp = DiamondService.orderList(registReq);
    System.out.println(resp);
  }

  @Test
  public void queryReceive() throws Exception {
    QueryFiatTradeReceiveReq registReq = new QueryFiatTradeReceiveReq();
    registReq.operSysType = "1";
    registReq.payMode = "alipay";
    registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
    QueryFiatTradeReceiveResp resp = DiamondService.queryReceive(registReq);
    System.out.println(resp);
  }


  @Test
  public void orderInfo() throws Exception {
    QueryOrderReq registReq = new QueryOrderReq();
    registReq.operSysType = "1";
    registReq.orderNo = "99110190104185455000003";
    registReq.userId = "c34d93b6d68740f29518aa01571cc74b";
    QueryOrderResp resp = DiamondService.orderInfo(registReq);
    System.out.println(resp);
  }


  @Test
  public void exchangeRate() throws Exception {
    ExchangeRateReq registReq = new ExchangeRateReq();
    registReq.apiKey="tradingchain";
    registReq.baseAsset="BTC";
    registReq.baseAssetIssuer="GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
    registReq.counterAsset="USDT";
    registReq.counterAssetIssuer="GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
    registReq.size=1;
    AssetsTrustReq assetsTrustReq = new AssetsTrustReq();
    List<AssetPair> list = new ArrayList<>();
    list.add(new AssetPair("USDT","GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    list.add(new AssetPair("BTC","GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG"));
    assetsTrustReq.apiKey="tradingchain";
    assetsTrustReq.platform="tradingchain_test";
    assetsTrustReq.username="15922222234";
    assetsTrustReq.privateKey="SBC2WDTSXF55ZRUBYVHXI6S7UDKYUADUQTKGC52ILWC4O4ML5HZBDNCR";
    assetsTrustReq.list=list;
    ExchangeRateRes rateRes = DiamondService.exchangeRate(registReq, assetsTrustReq);
    Thread.sleep(15000);
    System.out.println(rateRes);
  }
}

