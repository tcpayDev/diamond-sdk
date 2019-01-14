package io.tradingchain.sdk.diamondsdk.util;

import java.util.Random;

public class RandomUtil {
  private static final Random random = new Random();


  public static final int get(int n){
   return random.nextInt(n);
  }

}
