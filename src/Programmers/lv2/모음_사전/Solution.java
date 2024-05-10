package Programmers.lv2.모음_사전;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  List<String> result = new ArrayList<>();
  char[] arr = new char[]{'A', 'E', 'I', 'O', 'U'};

  public int solution(String word) {
    dfs("");
    for (int i = 0; i < result.size(); i++) {
      System.out.println(result.get(i));
      if (word.equals(result.get(i))) {
        return i + 1;
      }
    }

    return -1;
  }

  public void dfs(String now) {
    if (now.length() == 5) {
      return;
    }

    for (int i = 0; i < 5; i++) {
      result.add(now + arr[i]);
      dfs(now + arr[i]);
    }
  }
}

