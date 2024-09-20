package Baekjoon._30805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Node> aList = new ArrayList<>();
    ArrayList<Node> bList = new ArrayList<>();

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      aList.add(new Node(i, Integer.parseInt(st.nextToken())));
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      bList.add(new Node(i, Integer.parseInt(st.nextToken())));
    }

    Collections.sort(aList);
    Collections.sort(bList);

    ArrayList<Integer> result = new ArrayList<>();
    int aIdx = 0;
    int bIdx = 0;
    int aLastIdx = -1;
    int bLastIdx = -1;

    while (aIdx < N && bIdx < M) {
      Node aNow = aList.get(aIdx);
      Node bNow = bList.get(bIdx);

      if (aNow.val == bNow.val) {
        if (aLastIdx < aNow.idx && bLastIdx < bNow.idx) {
          result.add(aNow.val);
          aIdx++;
          bIdx++;
          aLastIdx = aNow.idx;
          bLastIdx = bNow.idx;
          continue;
        }

        if (aLastIdx > aNow.idx) {
          aIdx++;
        }

        if (bLastIdx > bNow.idx) {
          bIdx++;
        }
      } else if (aNow.val > bNow.val) {
        aIdx++;
      } else {
        bIdx++;
      }
    }

    System.out.println(result.size());
    for (int n : result) {
      System.out.print(n + " ");
    }
  }

  static class Node implements Comparable<Node> {

    int idx;
    int val;

    public Node(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }

    @Override
    public int compareTo(Node o) {
      if (this.val == o.val) {
        return this.idx - o.idx;
      }
      return o.val - this.val;
    }
  }
}
