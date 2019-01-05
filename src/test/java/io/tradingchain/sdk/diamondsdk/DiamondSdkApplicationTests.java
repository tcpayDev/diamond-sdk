package io.tradingchain.sdk.diamondsdk;

import io.tradingchain.sdk.diamondsdk.account.AccountDetailsReq;
import io.tradingchain.sdk.diamondsdk.account.AccountDetailsResp;
import io.tradingchain.sdk.diamondsdk.api.ApiController;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateRes;
import io.tradingchain.sdk.diamondsdk.exchangeRate.ExchangeRateReq;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersReq;
import io.tradingchain.sdk.diamondsdk.merchantOffer.OtcPostersRes;
import io.tradingchain.sdk.diamondsdk.order.CancelOrderReq;
import io.tradingchain.sdk.diamondsdk.order.CancelOrderResp;
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
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveReq;
import io.tradingchain.sdk.diamondsdk.payment.QueryFiatTradeReceiveResp;
import io.tradingchain.sdk.diamondsdk.payment.QueryPaymentReq;
import io.tradingchain.sdk.diamondsdk.payment.QueryPaymentResp;
import io.tradingchain.sdk.diamondsdk.regist.BeforeRegisterReq;
import io.tradingchain.sdk.diamondsdk.regist.BeforeRegisterResp;
import io.tradingchain.sdk.diamondsdk.regist.QueryUserReq;
import io.tradingchain.sdk.diamondsdk.regist.QueryUserResp;
import io.tradingchain.sdk.diamondsdk.regist.RegistReq;
import io.tradingchain.sdk.diamondsdk.regist.RegisterResOTC;
import io.tradingchain.sdk.diamondsdk.response.BaseVO;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiamondSdkApplicationTests {
	@Autowired
	ApiController apiController;

	@Test
	public void contextLoads() {
	}


	@Test
	public void beforeRegister()throws Exception{
		BeforeRegisterReq req = new BeforeRegisterReq();
		req.apiKey="tradingchain";
		BeforeRegisterResp register = apiController.beforeRegister(req);
		System.out.println(register.data);
	}


	@Test
	public void register()throws Exception{
		RegistReq registReq = new RegistReq();
		registReq.apiKey="tradingchain";
		registReq.username="15922222233";
		registReq.password="12345678";
		registReq.phone="15922222233";
		registReq.platform="tradingchain_test";
		registReq.privateKey="SBC2WDTSXF55ZRUBYVHXI6S7UDKYUADUQTKGC52ILWC4O4ML5HZBDNCR";
		registReq.backupKey="SA5OSGDABAZQBLPVHRJD65OBS6NK7L2LSJ6LDO64TBINPIPJSEJ364UH";
		registReq.tradePassword="123456";
    RegisterResOTC register = apiController.register(registReq,"1");
		System.out.println(register);
	}

	@Test
	public void accountDetails()throws Exception{
		AccountDetailsReq registReq = new AccountDetailsReq();
		registReq.apiKey="tradingchain";
		registReq.username="15921863925";
		registReq.password="12345678";
		registReq.platform="tradingchain_test";
		registReq.counterAssetName="USDT";
		registReq.counterAssetIssuer="GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
		AccountDetailsResp resp = apiController.accountDetails(registReq);
		System.out.println("");
	}


	@Test
	public void exchangeRate()throws Exception{
		ExchangeRateReq registReq = new ExchangeRateReq();
		registReq.apiKey="tradingchain";
		registReq.baseAsset="BTC";
		registReq.baseAssetIssuer="GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
		registReq.counterAsset="USDT";
		registReq.counterAssetIssuer="GBFB5JCHH2KPS7TBYB3GAU6Q43S4KLVDIKLWEE3KQQHWETYKWNZY4GXG";
		registReq.size=2;
		registReq.sign="";
		ExchangeRateRes rateRes = apiController.exchangeRate(registReq,"buy");
		System.out.println(rateRes);
	}

	@Test
	public void moneyMerchantInfo()throws Exception{
		OtcPostersReq registReq = new OtcPostersReq();
		registReq.tradeType="sell";
		registReq.amount= BigDecimal.ONE;
		registReq.payMode="bank,alipay";
		registReq.assetCode="usdt";
		registReq.page=1;
		registReq.pageSize=10;
		registReq.operSysType="1";
		BaseVO vos = apiController.moneyMerchantInfo(registReq);
		System.out.println(vos);
	}


	@Test
	public void moneyMerchantOrder()throws Exception{
		OtcPostersReq registReq = new OtcPostersReq();
		registReq.tradeType="sell";
		registReq.amount= BigDecimal.ONE;
		registReq.payMode="bank,alipay";
		registReq.assetCode="usdt";
		registReq.page=1;
		registReq.pageSize=10;
		registReq.operSysType="1";
		BaseVO vos = apiController.moneyMerchantOrder(registReq);
		System.out.println(vos);
	}

	@Test
	public void queryUser()throws Exception{
		QueryUserReq registReq = new QueryUserReq();
		registReq.operSysType="1";
		registReq.mobile="15922222232";
		QueryUserResp resp = apiController.queryUser(registReq);
		System.out.println(resp);
	}


	@Test
	public void addPayment()throws Exception{
		AddPaymentReq registReq = new AddPaymentReq();
		registReq.accountNo="123456";
		registReq.name="test";
		registReq.receiveType="alipay";
		registReq.operSysType="1";
		registReq.userId="c34d93b6d68740f29518aa01571cc74b";
		AddPaymentResp resp = apiController.addPayment(registReq);
		System.out.println(resp);
	}

	@Test
	public void findPayments()throws Exception{
		QueryPaymentReq registReq = new QueryPaymentReq();
		registReq.operSysType="1";
		registReq.userId="c34d93b6d68740f29518aa01571cc74b";
		QueryPaymentResp resp = apiController.findPayments(registReq);
		System.out.println(resp);
	}


	@Test
	public void createOrder()throws Exception{
		CreateOrderReq registReq = new CreateOrderReq();
		registReq.offerOrderNo="90005181108103627000109";
		registReq.quantity="0.01";
		registReq.price="88.8";
		registReq.amount="30";
		registReq.type="buy";
		registReq.operSysType="1";
		registReq.userId="c34d93b6d68740f29518aa01571cc74b";
		CreateOrderResp resp = apiController.createOrder(registReq);
		System.out.println(resp);
	}

	@Test
	public void cancelOrder()throws Exception{
		CancelOrderReq registReq = new CancelOrderReq();
		registReq.orderNo="99110190104184625000002";
		registReq.operSysType="1";
		registReq.userId="c34d93b6d68740f29518aa01571cc74b";
		CancelOrderResp resp = apiController.cancelOrder(registReq);
		System.out.println(resp);
	}

	@Test
	public void fiatTradeAppeal()throws Exception{
		FiatTradeAppealReq registReq = new FiatTradeAppealReq();
		registReq.orderNo="99110190104184625000002";
		registReq.appealRemark="test";
		registReq.operSysType="1";
		registReq.userId="c34d93b6d68740f29518aa01571cc74b";
		FiatTradeAppealResp resp = apiController.fiatTradeAppeal(registReq);
		System.out.println(resp);
	}

	@Test
	public void orderList()throws Exception{
		QueryOrderListReq registReq = new QueryOrderListReq();
		registReq.operSysType="1";
		registReq.userId="c34d93b6d68740f29518aa01571cc74b";
		QueryOrderListResp resp = apiController.orderList(registReq);
		System.out.println(resp);
	}

	@Test
	public void queryReceive()throws Exception{
		QueryFiatTradeReceiveReq registReq = new QueryFiatTradeReceiveReq();
		registReq.operSysType="1";
		registReq.payMode="alipay";
		registReq.userId="c34d93b6d68740f29518aa01571cc74b";
		QueryFiatTradeReceiveResp resp = apiController.queryReceive(registReq);
		System.out.println(resp);
	}


	@Test
	public void orderInfo()throws Exception{
		QueryOrderReq registReq = new QueryOrderReq();
		registReq.operSysType="1";
		registReq.orderNo="99110190104185455000003";
		registReq.userId="c34d93b6d68740f29518aa01571cc74b";
		QueryOrderResp resp = apiController.orderInfo(registReq);
		System.out.println(resp);
	}
}

