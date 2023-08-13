package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18352 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    ArrayList<ArrayList<Data>> list = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      list.get(start).add(new Data(end, 1));
    }

    int[] dist = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      dist[i] = Integer.MAX_VALUE;
    }

    PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

    pq.offer(new Data(x, 0));
    dist[x] = 0;

    while(!pq.isEmpty()) {
      Data now = pq.poll();

      if (dist[now.idx] < now.cost) {
        continue;
      }

      for (int i = 0; i < list.get(now.idx).size(); i++) {
        Data next = list.get(now.idx).get(i);

        if (dist[next.idx] > now.cost + next.cost) {
          dist[next.idx] = now.cost + next.cost;
          pq.offer(new Data(next.idx, dist[next.idx]));
        }
      }
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 1; i < n + 1; i++) {
      if (dist[i] == k) {
        ans.add(i);
      }
    }

    if (ans.size() == 0) {
      System.out.println(-1);
    } else {
      ans.forEach(System.out::println);
    }
  }

  static class Data {
    int idx;
    int cost;

    public Data(int idx, int cost) {
      this.idx = idx;
      this.cost = cost;
    }
  }
}
