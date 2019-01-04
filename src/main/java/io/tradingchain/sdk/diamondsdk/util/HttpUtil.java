package io.tradingchain.sdk.diamondsdk.util;

import com.alibaba.fastjson.JSON;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.ContentType;

public class HttpUtil {

  private static final Response post(String url, InputStream data) throws IOException {
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpPost = new HttpPost(url);
    httpPost.addHeader(new BasicHeader("Content-Type", ContentType.APPLICATION_JSON.toString()));
    HttpEntity httpEntity = new BasicHttpEntity();
    ((BasicHttpEntity) httpEntity).setContent(data);
    httpPost.setEntity(httpEntity);
    Response response =  new Response(httpClient.execute(httpPost));
    return response;
  }

  private static final Response post(String url, String data) throws IOException {
    return post(url, new ByteArrayInputStream(data.getBytes()));
  }

  private static final Response post(String url, Map data) throws IOException {
    return post(url, new ByteArrayInputStream(JSON.toJSONString(data).getBytes()));
  }

  public static final Response post(Request request) throws IOException {
    return post(request.url, request.data);
  }

  // 包装签名请求
  public static class Request {

    private String url;
    private Map data;

    public Request(String url, Map data, String secret, TreeMap treeMap)
        throws NoSuchAlgorithmException {
      this.url = url;
      this.data = data;
      if (treeMap.isEmpty()) {
        SignUtil.sign(data, secret);
      }else {
        SignUtil.signOTC(treeMap, secret, data);
      }
      System.out.println("data="+data);
      System.out.println("treeMap="+treeMap);
    }
  }


  // 包装返回结果
  public static class Response {

    private String responseText;

    private Response(String responseText) {
      this.responseText = responseText;
    }

    private Response(HttpEntity httpEntity) throws IOException {
      this(EntityUtils.toString(httpEntity));
    }

    public Response(HttpResponse httpResponse) throws IOException {
      this(httpResponse.getEntity());
    }

    public String toString() {
      return responseText;
    }

    public Map toMap() {
      return JSON.parseObject(this.responseText);
    }

    public <T> T castTo(Class<T> clazz) throws Exception {
      return JSON.parseObject(responseText, clazz);
    }
  }
}
