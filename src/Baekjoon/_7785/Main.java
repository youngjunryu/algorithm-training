package Baekjoon._7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashMap<String, String> map = new HashMap<>();

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String command = st.nextToken();

      map.put(name, command);
    }

    ArrayList<String> result = new ArrayList<>();
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (entry.getValue().equals("enter")) {
        result.add(entry.getKey());
      }
    }

    Collections.sort(result, Collections.reverseOrder());

    for (String a : result) {
      System.out.println(a);
    }
  }
}

/*

812215

 */
