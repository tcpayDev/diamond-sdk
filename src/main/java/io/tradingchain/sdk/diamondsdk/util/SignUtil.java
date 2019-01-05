package io.tradingchain.sdk.diamondsdk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;
import javax.xml.bind.DatatypeConverter;

public class SignUtil {

  private static final String getPreSignStr(Map data, String secret) {
    Map<String, String> treeMap = new TreeMap<>(data);
    StringBuilder sb = new StringBuilder();
    treeMap.forEach((k, v) -> {
      if (!"sign".equals(k) && null != v) {
        sb.append("&" + k + "=" + v);
      }
    });
    sb.append("&secret=" + secret);
    return sb.toString().substring(1);
  }

  private static final String getOTCPreSignStr(Map data, String secret) {
    Map<String, String> treeMap = new TreeMap<>(data);
    StringBuilder sb = new StringBuilder();
    treeMap.forEach((k, v) -> {
      if (!"sign".equals(k) && null != v) {
        sb.append("&" + k + "=" + v);
      }
    });
    sb.append("&key=" + secret);
    return sb.toString().substring(1);
  }

  public static final void sign(Map data, String secret)
      throws NoSuchAlgorithmException {
    String sign = md5(getPreSignStr(data, secret));
    data.put("sign", sign.toLowerCase());
  }

  public static final void signOTC(TreeMap map, String secret, Map data)
      throws NoSuchAlgorithmException {
    String signStr = getOTCPreSignStr(map, secret);
    String sign = MD5OTC(signStr);
    data.put("sign", sign.toLowerCase());
  }


  public static final String md5(Object o) throws NoSuchAlgorithmException {
    return DatatypeConverter
        .printHexBinary(MessageDigest.getInstance("MD5").digest(String.valueOf(o).getBytes()));
  }

  public final static String MD5OTC(String s) {
    char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
        'f'};

    try {
      byte[] btInput = s.getBytes("UTF-8");
      // 获得MD5摘要算法的 MessageDigest 对象
      MessageDigest mdInst = MessageDigest.getInstance("MD5");
      // 使用指定的字节更新摘要
      mdInst.update(btInput);
      // 获得密文
      byte[] md = mdInst.digest();
      // 把密文转换成十六进制的字符串形式
      int j = md.length;
      char str[] = new char[j * 2];
      int k = 0;
      for (int i = 0; i < j; i++) {
        byte byte0 = md[i];
        str[k++] = hexDigits[byte0 >>> 4 & 0xf];
        str[k++] = hexDigits[byte0 & 0xf];
      }
      return new String(str);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
