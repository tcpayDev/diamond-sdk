package io.tradingchain.sdk.diamondsdk.util;

import com.alibaba.fastjson.JSON;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

  private static final Logger LOGGER = Logger.getLogger(HttpUtil.class.getName());
  private static final int TIMEOUT_MILLS = 75000;

  private static final RequestConfig REQUEST_CONFIG = RequestConfig.custom()
      .setConnectTimeout(TIMEOUT_MILLS)
      .setSocketTimeout(TIMEOUT_MILLS)
      .build();

  private static final OkHttpClient httpClient = new OkHttpClient.Builder()
      .connectTimeout(TIMEOUT_MILLS, TimeUnit.MILLISECONDS)
      .readTimeout(TIMEOUT_MILLS, TimeUnit.MILLISECONDS)
      .writeTimeout(TIMEOUT_MILLS, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).build();

  private static final Response post(String url, String data) throws IOException {
    LOGGER.info(String.format("post request, url=%s, data=%s", url, data));
    okhttp3.Response response = httpClient.newCall(
        new Builder().post(RequestBody.create(MediaType.parse("application/json"), data))
            .url(url).build()).execute();
    String responseString = response.body().string();
    LOGGER.info(String.format("post response, response=%s", responseString));
    Integer code = JSON.parseObject(responseString).getInteger("code");
    if (code !=null) {
      return new Response(responseString);
    }else {
      throw new RuntimeException("请求服务异常");
    }
  }

  public static void main(String[] args) throws IOException {
    post("http://test-api.tcpay.info/trade/api/payment","");
  }

  private static final Response post(String url, Map data) throws IOException {
    return post(url, JSON.toJSONString(data));
  }

  public static final Response post(Request request) throws IOException {
    return post(request.url, request.data);
  }

  public static final Response postForm(Request request) throws IOException {
    return postForm(request.url, request.data);
  }

  private static final Response postForm(String url, Map data) throws IOException {
    return postFormC(url, data);
  }

  private static final Response postFormC(String url, Map data) throws IOException {
    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost httpPost = new HttpPost(url);
    httpPost.setConfig(REQUEST_CONFIG);

    ContentType strContent = ContentType.create("text/plain", Charset.forName("UTF-8"));
    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
    if (data != null) {
      Iterator iterator = data.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry entry = (Map.Entry) iterator.next();
        String key = (String) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof File) {
          builder.addBinaryBody(key, (File) value);
        } else {
          builder.addTextBody(key, (String) value, strContent);
        }
      }
    }
    HttpEntity httpEntity = builder.build();
    // 设置请求参数
    httpPost.setEntity(httpEntity);
    Response response = new Response(httpClient.execute(httpPost));
    return response;
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
      } else {
        SignUtil.signOTC(treeMap, secret, data);
      }
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
