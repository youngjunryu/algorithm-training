package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ14395 {
  static int target;
  static Queue<Data> q;
  static Set<Integer> visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    target = Integer.parseInt(st.nextToken());
    q = new LinkedList<>();
    visited = new HashSet<>();

    if (s == target) {
      System.out.println(0);
    } else {
      String result = bfs(new Data(s, ""));
      if (visited.contains(target)) {
        System.out.println(result);
      } else {
        System.out.println(-1);
      }
    }
  }

  private static String bfs(Data data) {
    q.add(data);

    while(!q.isEmpty()) {
      Data cur = q.poll();

      if (cur.value == target) {
        return cur.formula;
      }

      for (int i = 0; i < 3; i++) {
        long tmp = cur.value;
        if (i == 0) {
          tmp *= tmp;
        } else if (i == 1) {
          tmp += tmp;
        } else {
          tmp = 1;
        }

        if (tmp > target) {
          continue;
        }

        if (visited.contains((int) tmp)) {
          continue;
        }

        visited.add((int) tmp);
        if (i == 0) {
          q.add(new Data((int) tmp , cur.formula + "*"));
        } else if (i == 1) {
          q.add(new Data((int) tmp, cur.formula +  "+"));
        } else {
          q.add(new Data((int) tmp, cur.formula + "/"));
        }
      }
    }

    return null;
  }

  static class Data {
    int value;
    String formula;

    public Data(int value, String formula) {
      this.value = value;
      this.formula = formula;
    }
  }
}
