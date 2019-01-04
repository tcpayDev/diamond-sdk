package io.tradingchain.sdk.diamondsdk.util;

import com.alibaba.fastjson.JSON;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.xml.bind.DatatypeConverter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import sun.security.provider.MD5;

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

  public static String signByMD5(String md5key, TreeMap<String, String> fieldsMap) {
    String sign = "";
    try {
      if (CollectionUtils.isEmpty(fieldsMap)) {
        return sign;
      }
      fieldsMap.put("sign", null);
      Set entrySet = fieldsMap.entrySet();
      StringBuilder sb = new StringBuilder();
      Iterator var4 = entrySet.iterator();

      while (var4.hasNext()) {
        Map.Entry sortData = (Map.Entry) var4.next();
        String key = (String) sortData.getKey();
        String value = (String) sortData.getValue();
        if (!StringUtils.isEmpty(value)) {
          sb.append("&").append(key).append("=").append(value);
        }
      }

      sb.deleteCharAt(0);
      String sortData1 = sb.toString();
//      String sortData = ReflectionUtil.sortData(fieldsMap);
      sortData1 = sortData1 + "&key=" + md5key;
      System.out.println(sortData1);
      sign = MD5OTC(sortData1);
      System.out.println(sign);
    } catch (Exception e) {
    }
    return sign;
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


  public static void main(String[] args) {
    TreeMap treeMap = new TreeMap();
    treeMap.put("accessToken", "1546509976245");
    treeMap.put("amount", "1");
    treeMap.put("page", "1");
    treeMap.put("assetCode", "btc");
    treeMap.put("tradeType", "sell");
    treeMap.put("payMode", "alipay");
    treeMap.put("pageSize", "10");
    signByMD5("iaM43PnzzfY6Xdeo", treeMap);
  }
}
