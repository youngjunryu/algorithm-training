package Baekjoon._9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());
      HashMap<String, ArrayList<String>> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        String category = st.nextToken();

        if (!map.containsKey(category)) {
          map.put(category, new ArrayList<>());
        }

        map.get(category).add(name);
      }

      int result = 1;
      for (ArrayList<String> list : map.values()) {
        result *= (list.size() + 1);
      }

      System.out.println(result - 1);
    }
  }
}

