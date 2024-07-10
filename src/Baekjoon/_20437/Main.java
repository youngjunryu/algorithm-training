package Baekjoon._20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      String w = br.readLine();
      int k = Integer.parseInt(br.readLine());

      ArrayList<ArrayList<Integer>> store = new ArrayList<>();
      for (int i = 0; i < 26; i++) {
        store.add(new ArrayList<>());
      }

      for (int i = 0; i < w.length(); i++) {
        char c = w.charAt(i);
        ArrayList<Integer> list = store.get(c - 'a');
        list.add(i);
      }

      int minLen = Integer.MAX_VALUE;
      int maxLen = Integer.MIN_VALUE;
      for (int i = 0; i < 26; i++) {
        ArrayList<Integer> list = store.get(i);
        if (list.isEmpty() || list.size() < k) {
          continue;
        }

        for (int start = 0; start <= list.size() - k; start++) {
          int first = list.get(start);
          int last = list.get(start + k - 1);
          int size = last - first + 1;
          minLen = Math.min(minLen, size);
          maxLen = Math.max(maxLen, size);
        }
      }

      if (minLen == Integer.MAX_VALUE) {
        System.out.println(-1);
      } else {
        System.out.println(minLen + " " + maxLen);
      }
    }
  }
}
