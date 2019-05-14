package io.tradingchain.sdk.diamondsdk.config;

import java.lang.reflect.Field;

public class Config {
//
  public static String BASE_URL;
  public static String OTC_BASE_URL;
  public static String PLATFORM;
  public static String API_KEY;
  public static String OTC_SECRET;

//  public static String BASE_URL="http://diamond.tradingchain.io/";
//  public static String OTC_BASE_URL="http://exchange-getway.wellsfargoex.com/";
//  public static String PLATFORM="tradingchain";
//  public static String API_KEY="tradingchain";
//  public static String OTC_SECRET="iaM43PnzzfY6Xdeo";

//  public static String BASE_URL = "http://api.1mfpay.com";
//  public static String OTC_BASE_URL = "http://47.88.237.199:8980";
//  public static String PLATFORM = "tradingchain_test";
//  public static String API_KEY = "tradingchain";
//  public static String OTC_SECRET = "iaM43PnzzfY6Xdeo";

  private static final void setField(String fieldName, Object value, Object o) {
    try {
      Class clazz = o.getClass();
      Field field = clazz.getDeclaredField(fieldName);
      boolean accessible = field.isAccessible();
      if (!accessible) {
        field.setAccessible(true);
      }
      if (null == field.get(o)) {
        field.set(o, value);
      }
      if (!accessible) {
        field.setAccessible(false);
      }
    } catch (NoSuchFieldException e) {

    } catch (IllegalAccessException e) {

    }
  }


  // 设置链请求对象的公共参数
  public static final Object setCommonParams(Object o) {
    setField("apiKey", API_KEY, o);
    setField("platform", PLATFORM, o);
    return o;
  }
}
