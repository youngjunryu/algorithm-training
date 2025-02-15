package Baekjoon._1269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int k = 0;
    HashSet<Integer> set = new HashSet<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a; i++) {
      set.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < b; i++) {
      int val = Integer.parseInt(st.nextToken());
      if (set.contains(val)) {
        k++;
      } else {
        set.add(val);
      }
    }

    System.out.println(set.size() - k);
  }
}
