package Baekjoon._1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String str = br.readLine();

      int len = str.length();

      for (int j = len - 1; j >= 0; j--) {
        char c = str.charAt(j);
        int score = (int) Math.pow(10, len - j - 1);
        map.put(c, map.getOrDefault(c, 0) + score);
      }
    }

    int result = 0;

    List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
    entryList.sort(Map.Entry.comparingByValue());
    int idx = 10 - entryList.size();
    for (Map.Entry<Character, Integer> entry : entryList) {
      Character key = entry.getKey();
      int val = entry.getValue();

      result += val * idx;

      idx++;
    }

    System.out.println(result);
  }
}
