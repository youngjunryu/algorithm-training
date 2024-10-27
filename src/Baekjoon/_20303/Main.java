package Baekjoon._20303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K;
  static int[] store;
  static ArrayList<ArrayList<Integer>> map;
  static int[] parent;
  static HashMap<Integer, ArrayList<Integer>> parentCount;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    store = new int[N + 1];

    map = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      store[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      map.get(a).add(b);
      map.get(b).add(a);
    }

    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 1; i <= N; i++) {
      for (int next : map.get(i)) {
        if (!isSameParent(i, next)) {
          union(i, next);
        }
      }
    }
    
    for (int i = 1; i <= N; i++) {
      parent[i] = find(i);
    }

    parentCount = new HashMap<>();

    for (int i = 1; i <= N; i++) {
      int parentNum = parent[i];
      parentCount.putIfAbsent(parentNum, new ArrayList<>());
      parentCount.get(parentNum).add(store[i]);
    }

    long[] dp = new long[K];

    for (int parentNum : parentCount.keySet()) {
      ArrayList<Integer> list = parentCount.get(parentNum);
      int size = list.size();
      long sum = list.stream().mapToLong(Integer::longValue).sum();

      for (int j = K - 1; j >= size; j--) {
        dp[j] = Math.max(dp[j], dp[j - size] + sum);
      }
    }

    System.out.println(dp[K - 1]);
  }

  private static int find(int a) {
    if (parent[a] == a) {
      return a;
    }

    return parent[a] = find(parent[a]);
  }

  private static boolean isSameParent(int a, int b) {
    return find(a) == find(b);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b) {
      parent[b] = a;
    }
  }
}


