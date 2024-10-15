package Baekjoon._3758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int c = 0; c < T; c++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      ArrayList<Node> nodes = new ArrayList<>();
      for (int cm = 0; cm < m; cm++) {
        nodes.add(new Node(cm));
      }

      int[][] problem = new int[n][k + 1];

      for (int cm = 0; cm < m; cm++) {
        st = new StringTokenizer(br.readLine());
        int id = Integer.parseInt(st.nextToken()) - 1;
        int j = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int prev = problem[id][j];
        Node node = nodes.get(id);
        if (prev < s) {
          node.score += s - prev;
          problem[id][j] = s;
        }

        node.submitCnt++;
        node.lastIdx = cm;
      }

      Collections.sort(nodes);
      for (int i = 0; i < nodes.size(); i++) {
        if (nodes.get(i).id + 1 == t) {
          System.out.println(i + 1);
          break;
        }
      }
    }
  }

  static class Node implements Comparable<Node> {

    int id;
    int submitCnt;
    int lastIdx;
    int score;

    public Node(int id) {
      this.id = id;
      this.submitCnt = 0;
      this.lastIdx = -1;
      this.score = 0;
    }

    @Override
    public int compareTo(Node o) {
      if (this.score == o.score) {
        if (this.submitCnt == o.submitCnt) {
          return this.lastIdx - o.lastIdx;
        }
        return this.submitCnt - o.submitCnt;
      }
      return o.score - this.score;
    }
  }
}
