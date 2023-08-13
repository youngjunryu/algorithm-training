package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class 수식_최대화 {
  public static long solution(String expression) {
    long answer = 0;

    List<String> expressionList = Arrays.stream(expression.split("-|\\+|\\*"))
                                 .collect(Collectors.toList());

    int idx = 1;
    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '*' || c == '+' || c == '-') {
        set.add(c);
        expressionList.add(idx, String.valueOf(c));
        idx += 2;
      }
    }

    Character[] characters = set.toArray(new Character[0]);
    ArrayList<String> list = new ArrayList<>();
    dfs(list, characters, "", new boolean[characters.length]);

    long max = 0;
    for (int i = 0; i < list.size(); i++) {
      List<String> now = new ArrayList<>(expressionList);
      String s = list.get(i);
      for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j);
        for (int k = 0; k < now.size(); k++) {
          if (now.get(k).equals(String.valueOf(c))) {
            calculate(now, k, c);
            k = -1;
          }
        }
      }

      max = Math.max(max, Math.abs(Long.parseLong(now.get(0))));
    }

    System.out.println(max);
    return max;
  }

  private static void calculate(List<String> now, int k, char op) {
    long sum = 0;
    switch (op) {
      case '*':
        sum = Long.parseLong(now.get(k-1)) * Long.parseLong(now.get(k+1));
        break;
      case '+':
        sum = Long.parseLong(now.get(k-1)) + Long.parseLong(now.get(k+1));
        break;
      case '-':
        sum = Long.parseLong(now.get(k-1)) - Long.parseLong(now.get(k+1));
        break;
    }

    now.remove(k - 1);
    now.remove(k - 1);
    now.remove(k - 1);
    now.add(k - 1, String.valueOf(sum));
  }

  private static void dfs(ArrayList<String> list, Character[] characters, String now, boolean[] visited) {
    if (now.length() == characters.length) {
      list.add(now);
      return;
    }

    for (int i = 0; i < characters.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(list, characters, now + characters[i], visited);
        visited[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    solution("50*6-3*2");
  }
}
