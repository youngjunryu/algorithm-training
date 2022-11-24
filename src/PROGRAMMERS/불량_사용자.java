package PROGRAMMERS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class 불량_사용자 {
  static int n;
  static HashSet<String> set;

  public static int solution(String[] user_id, String[] banned_id) {
    n = banned_id.length;
    set = new HashSet<>();
    HashMap<String, Integer> map = new HashMap<>();
    int idx = 0;
    for (String u : user_id) {
      map.put(u, idx++);
    }

    ArrayList<ArrayList<Integer>> banList = new ArrayList<>();
    for (String b : banned_id) {
      ArrayList<Integer> ids = new ArrayList<>();
      for (String u : user_id) {
        if (b.length() != u.length()) {
          continue;
        }

        boolean flag = true;
        for (int i = 0; i < b.length(); i++) {
          if (!(b.charAt(i) == '*' || b.charAt(i) == u.charAt(i))) {
            flag = false;
            break;
          }
        }

        if (flag) {
          ids.add(map.get(u));
        }
      }

      banList.add(ids);
    }

    boolean[] visited = new boolean[user_id.length];
    dfs(banList, visited, 0, new LinkedList<>());

    return set.size();
  }

  private static void dfs(ArrayList<ArrayList<Integer>> banList, boolean[] visited, int path, LinkedList<Integer> result) {
    if (path == n) {
      LinkedList<Integer> temp = new LinkedList<>(result);
      Collections.sort(temp);
      StringBuilder sb = new StringBuilder();
      temp.forEach(sb::append);
      if (!set.contains(sb.toString())) {
        set.add(sb.toString());
      }
      return;
    }

    for (int i = 0; i < banList.get(path).size(); i++) {
      int idx = banList.get(path).get(i);
      if (!visited[idx]) {
        visited[idx] = true;
        result.add(idx);
        dfs(banList, visited, path + 1, result);
        visited[idx] = false;
        result.removeLast();
      }
    }
  }

  public static void main(String[] args) {
    solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"});
  }
}
