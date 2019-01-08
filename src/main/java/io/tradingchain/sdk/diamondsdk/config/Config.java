package io.tradingchain.sdk.diamondsdk.config;

import java.lang.reflect.Field;

public class Config {

  public static String BASE_URL = "http://api.1mfpay.com";//"http://localhost:8802";//
  public static String OTC_BASE_URL = "http://101.200.122.153:8380";
  public static String DIAMOND_BASE_URL = "http://localhost:8080";
  public static String PLATFORM = "tradingchain_test";
  public static String API_KEY = "tradingchain";
  public static String SECRET = "yScdDvjCDJ906OlrIGIzITnOZVDKKEpm";
  public static String OTC_SECRET = "iaM43PnzzfY6Xdeo";


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

  // 设置OTC请求对象的公共参数
  public static final Object setOtcCommonParams(Object o) throws Exception {
//    setField("operSysType", operSysType, o);
//    setField("version", "1.0.0", o);
    return o;
  }
}
