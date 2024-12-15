package Baekjoon._25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashMap<String, Double> map = new HashMap<>();
    map.put("A+", 4.5);
    map.put("A0", 4.0);
    map.put("B+", 3.5);
    map.put("B0", 3.0);
    map.put("C+", 2.5);
    map.put("C0", 2.0);
    map.put("D+", 1.5);
    map.put("D0", 1.0);
    map.put("F", 0.0);

    int sum = 0;
    double total = 0;
    for (int i = 0; i < 20; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      st.nextToken();
      int a = (int) Double.parseDouble(st.nextToken());

      String val = st.nextToken();
      if (!map.containsKey(val)) {
        continue;
      }

      double b = map.get(val);

      sum += a;
      total += b * a;
    }

    System.out.println(total / sum);
  }
}
