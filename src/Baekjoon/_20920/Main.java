package Baekjoon._20920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, Node> map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      if (str.length() < M) {
        continue;
      }

      if (map.containsKey(str)) {
        Node n = map.get(str);
        n.up();
      } else {
        map.put(str, new Node(str));
      }
    }

    PriorityQueue<Node> pq = new PriorityQueue<>(map.values());
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while (!pq.isEmpty()) {
      bw.write(pq.poll().str + "\n");
    }
    bw.flush();
  }

  static class Node implements Comparable<Node> {

    String str;
    int n;

    public Node(String str) {
      this.str = str;
      this.n = 0;
    }

    public void up() {
      n++;
    }

    @Override
    public int compareTo(Node o) {
      if (n == o.n) {
        if (str.length() == o.str.length()) {
          return str.compareTo(o.str);
        }

        return o.str.length() - str.length();
      }

      return o.n - n;
    }
  }
}
