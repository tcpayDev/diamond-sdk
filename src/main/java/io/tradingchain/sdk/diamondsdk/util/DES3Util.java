package io.tradingchain.sdk.diamondsdk.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class DES3Util {

  private static final String CODE = "UTF-8";
  private static final String Algorithm = "DESede"; // 定义 加密算法,可用
  private static ReentrantLock lock = new ReentrantLock();
  private static ConcurrentHashMap<String, byte[]> keyMap = new ConcurrentHashMap<>();

  /**
   * Decrypt3DES 3des解码<br/>
   *
   * @param value
   * @param key
   * @return
   * @throws Exception
   *             String
   * @exception
   * @since 1.0.0
   */
  public static String Decrypt3DES(String value, String key) throws Exception {

    if(value == null)
      return null;
    byte[] b = decryptMode(GetKeyBytes(key), Base64.decodeBase64((value)));

    return new String(b, CODE);

  }

  // 计算24位长的密码byte值,首先对原始密钥做MD5算hash值，再用前8位数据对应补全后8位

  /**
   * Encrypt3DES 3DES加密<br/>
   *
   * @param value
   * @param key
   * @return
   * @throws Exception
   *             String
   * @exception
   * @since 1.0.0
   */
  public static String Encrypt3DES(String value, String key) throws Exception {

    String str = byte2Base64(encryptMode(GetKeyBytes(key), value.getBytes(CODE)));

    return str;

  }

  public static byte[] GetKeyBytes(String strKey) throws Exception {

    if (keyMap.get(strKey) != null) {
      return keyMap.get(strKey);
    }

    try {
      lock.lock();

      if (keyMap.get(strKey) != null) {
        return keyMap.get(strKey);
      }

      if (null == strKey || strKey.length() < 1)

        throw new Exception("key is null or empty!");

      java.security.MessageDigest alg = java.security.MessageDigest.getInstance("MD5");

      alg.update(strKey.getBytes());

      byte[] bkey = alg.digest();

      int start = bkey.length;

      byte[] bkey24 = new byte[24];

      for (int i = 0; i < start; i++) {

        bkey24[i] = bkey[i];

      }

      for (int i = start; i < 24; i++) {// 为了与.net16位key兼容
        bkey24[i] = bkey[i - start];
      }
      keyMap.put(strKey, bkey24);

      return bkey24;
    } finally {
      lock.unlock();
    }

  }
  // DES,DESede,Blowfish

  // keybyte为加密密钥，长度为24字节

  // src为被加密的数据缓冲区（源）

  public static byte[] encryptMode(byte[] keybyte, byte[] src) {

    try {

      // 生成密钥

      SecretKey deskey = new SecretKeySpec(keybyte, Algorithm); // 加密

      Cipher c1 = Cipher.getInstance(Algorithm);

      c1.init(Cipher.ENCRYPT_MODE, deskey);

      return c1.doFinal(src);

    } catch (java.security.NoSuchAlgorithmException e1) {

      e1.printStackTrace();

    } catch (javax.crypto.NoSuchPaddingException e2) {

      e2.printStackTrace();

    } catch (Exception e3) {

      e3.printStackTrace();

    }

    return null;

  }

  // keybyte为加密密钥，长度为24字节

  // src为加密后的缓冲区

  public static byte[] decryptMode(byte[] keybyte, byte[] src) {

    try { // 生成密钥

      SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

      // 解密

      Cipher c1 = Cipher.getInstance(Algorithm);

      c1.init(Cipher.DECRYPT_MODE, deskey);

      return c1.doFinal(src);

    } catch (java.security.NoSuchAlgorithmException e1) {

      e1.printStackTrace();

    } catch (javax.crypto.NoSuchPaddingException e2) {

      e2.printStackTrace();

    } catch (Exception e3) {

      e3.printStackTrace();

    }

    return null;

  }

  // 转换成base64编码

  public static String byte2Base64(byte[] b) {
    return new String(Base64.encodeBase64((b)));

  }

  // 转换成十六进制字符串

  public static String byte2hex(byte[] b) {

    String hs = "";

    String stmp = "";

    for (int n = 0; n < b.length; n++) {

      stmp = (Integer.toHexString(b[n] & 0XFF));

      if (stmp.length() == 1)

        hs = hs + "0" + stmp;

      else

        hs = hs + stmp;

      if (n < b.length - 1)

        hs = hs + ":";

    }

    return hs.toUpperCase();

  }

  public static void main(String[] args) throws Exception {
//
//		ZkClient zkClient = new ZkClient("182.92.3.15 2181");
//
//		zkClient.connect(5000, new Watcher(){com/ninefbank/smallpay/payment/ZookeeperClientTest.java:18
//			public void process(WatchedEvent event) {
//				System.out.println(event.getState());;
//			}
//		});2016-05-28 10:33:31
//		zkClient.close();
//		ZookeeperClientTest test = new ZookeeperClientTest();
//		test.setBigDecimal(test.getBigDecimal().setScale(2));
//		System.out.print(test.getBigDecimal());
//
//		System.out.println(ConfidentialDataUtil.decrypt3DES("18910287806","wang!@#2"));
		System.out.println(Encrypt3DES("1","aki1CcBk3HYgdYuS"));
    System.out.println(GetKeyBytes("aki1CcBk3HYgdYuS"));
    System.out.println(Decrypt3DES("ra6pzFNcYMI=","aki1CcBk3HYgdYuS"));
//		throw  new UndeclaredThrowableException(new Throwable("11"));

  }


}
