package io.tradingchain.sdk.diamondsdk.trustAsset;

import io.tradingchain.sdk.diamondsdk.annotation.ReqParam;
import java.util.ArrayList;
import java.util.List;

public class AssetsTrustReq {
  @ReqParam(isSgin = true,nullable = false, comment = "用户名")
  public String username;
  @ReqParam(isSgin = true,comment = "用户私钥, 与backupKey二选一")
  public String privateKey;
  @ReqParam(isSgin = true,nullable = false, comment = "资产列表")
  public List<AssetPair> list;
  @ReqParam(isSgin = true,nullable = false, comment = "标识")
  public String platform;
  @ReqParam(isSgin = false,nullable = false, comment = "签名", userset = false)
  public String sign;
  @ReqParam(isSgin = true,nullable = false, comment = "签名key")
  public String apiKey;

  public AssetsTrustReq() {
  }

  public AssetsTrustReq addAsset(AssetPair assetPair) {
    if (null == this.list) this.list = new ArrayList<>();
    this.list.add(assetPair);
    return this;
  }

  public AssetsTrustReq(String username, String privateKey) {
    this.username = username;
    this.privateKey = privateKey;
  }

  public AssetsTrustReq setUsername(String username) {
    this.username = username;
    return this;
  }

  public AssetsTrustReq setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  public AssetsTrustReq setList(List<AssetPair> list) {
    this.list = list;
    return this;
  }

  public AssetsTrustReq setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  public AssetsTrustReq setSign(String sign) {
    this.sign = sign;
    return this;
  }

  public AssetsTrustReq setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }

}
