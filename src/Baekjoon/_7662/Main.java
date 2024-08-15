package Baekjoon._7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int k = Integer.parseInt(br.readLine());

      TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());

      for (int j = 0; j < k; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String command = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        if (command.equals("D")) {
          if (treeMap.isEmpty()) {
            continue;
          }

          if (n == 1) {
            int key = treeMap.firstKey();
            int val = treeMap.get(key);
            if (val == 1) {
              treeMap.remove(key);
            } else {
              treeMap.put(key, val - 1);
            }
          } else if (n == -1) {
            int key = treeMap.lastKey();
            int val = treeMap.get(key);
            if (val == 1) {
              treeMap.remove(key);
            } else {
              treeMap.put(key, val - 1);
            }
          }
        } else {
          treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
        }
      }

      if (treeMap.isEmpty()) {
        sb.append("EMPTY");
        sb.append("\n");
      } else {
        sb.append(treeMap.firstKey());
        sb.append(" ");
        sb.append(treeMap.lastKey());
        sb.append("\n");
      }
    }

    System.out.println(sb);
  }
}
