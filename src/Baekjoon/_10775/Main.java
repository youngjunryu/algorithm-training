package Baekjoon._10775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int g = Integer.parseInt(br.readLine());
    int p = Integer.parseInt(br.readLine());
    parent = new int[g + 1];
    for (int i = 1; i <= g; i++) {
      parent[i] = i;
    }

    int result = 0;

    for (int i = 0; i < p; i++) {
      int val = Integer.parseInt(br.readLine());

      int avail = find(val);

      if (avail == 0) {
        break;
      }

      result++;

      union(find(val) - 1, find(val));
    }

    System.out.println(result);
  }

  private static int find(int a) {
    if (parent[a] == a) {
      return a;
    }

    return parent[a] = find(parent[a]);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b) {
      parent[b] = a;
    }
  }
}

/*

find(g)가 0이 아니면 도킹 성공이며 union(find(g-1), find(g))를 하면 되고
find(g)가 0이면 도킹 실패이므로 곧바로 종료하고 지금까지 도킹을 성공한 비행기 수를 출력

 */
