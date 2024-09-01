package Baekjoon._1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(br.readLine());
    }

    ArrayList<String> result = new ArrayList<>();

    for (int j = 0; j < n; j++) {
      String val = br.readLine();
      if (set.contains(val)) {
        result.add(val);
      }
    }

    Collections.sort(result);

    System.out.println(result.size());
    for (String val : result) {
      System.out.println(val);
    }
  }
}
