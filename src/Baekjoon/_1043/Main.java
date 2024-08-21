package Baekjoon._1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<Integer> truth;
  static ArrayList<ArrayList<Integer>> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());

    if (T == 0) {
      System.out.println(M);
      return;
    }

    truth = new ArrayList<>();
    for (int i = 0; i < T; i++) {
      truth.add(Integer.parseInt(st.nextToken()));
    }

    int[] parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    list = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      list.add(new ArrayList<>());

      for (int j = 0; j < num; j++) {
        list.get(i).add(Integer.parseInt(st.nextToken()));
      }

      for (int j = 0; j < list.get(i).size() - 1; j++) {
        union(parent, list.get(i).get(j), list.get(i).get(j + 1));
      }
    }

    int result = 0;

    for (ArrayList<Integer> now : list) {
      boolean flag = true;

      for (int i = 0; i < now.size() && flag; i++) {
        for (int j = 0; j < truth.size(); j++) {
          if (isSameParent(parent, now.get(i), truth.get(j))) {
            flag = false;
            break;
          }
        }
      }

      if (flag) {
        result++;
      }
    }

    System.out.println(result);
  }

  private static int getParent(int[] parent, int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = getParent(parent, parent[x]);
  }

  private static boolean isSameParent(int[] parent, int x, int y) {
    int a = getParent(parent, x);
    int b = getParent(parent, y);
    if (a == b) {
      return true;
    } else {
      return false;
    }
  }

  private static void union(int[] parent, int x, int y) {
    int a = getParent(parent, x);
    int b = getParent(parent, y);

    if (a < b) {
      parent[b] = a;
    } else {
      parent[a] = b;
    }
  }
}
