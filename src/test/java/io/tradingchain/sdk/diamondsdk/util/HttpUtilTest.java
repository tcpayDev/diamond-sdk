package io.tradingchain.sdk.diamondsdk.util;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;

public class HttpUtilTest {

    /**
     * 测试超时时间
     *
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void post() throws NoSuchAlgorithmException {
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put("123", "123");
        try {
            HttpUtil.Response response = HttpUtil.post(new HttpUtil.Request("http://dev.local:20010/test/mapping/eee", treeMap, "secret", treeMap));
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}