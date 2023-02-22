package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    parent = new int[n+1];
    for (int i = 0; i <= n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int command = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (command == 1) {
        if (isSameParent(a, b)) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      } else if (command == 0) {
        union(a, b);
      }
    }
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      parent[b] = a;
    }
  }

  static boolean isSameParent(int a, int b) {
    if (find(a) == find(b)) {
      return true;
    }

    return false;
  }

  private static int find(int a) {
    if (parent[a] == a) {
      return a;
    }

    return parent[a] = find(parent[a]);
  }
}
