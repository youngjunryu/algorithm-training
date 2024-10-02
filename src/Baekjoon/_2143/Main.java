package Baekjoon._2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  static int T;
  static HashMap<Long, Long> aMap, bMap;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    int m = Integer.parseInt(br.readLine());
    int[] b = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    aMap = new HashMap<>();
    bMap = new HashMap<>();

    getCumulativeSum(aMap, a, n);
    getCumulativeSum(bMap, b, m);

    long result = 0;
    for (long i : aMap.keySet()) {
      long target = T - i;
      if (bMap.containsKey(target)) {
        result += (long) aMap.get(i) * bMap.get(target);
      }
    }

    System.out.println(result);
  }

  private static void getCumulativeSum(HashMap<Long, Long> map,
      int[] arr, int len) {
    long[] sum = new long[len + 1];
    for (int i = 1; i <= len; i++) {
      sum[i] += sum[i - 1] + arr[i - 1];
    }

    for (int i = 1; i <= len; i++) {
      for (int j = 0; j < i; j++) {
        long val = sum[i] - sum[j];
        map.put(val, map.getOrDefault(val, 0L) + 1);
      }
    }
  }
}
