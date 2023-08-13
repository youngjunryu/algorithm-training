package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5567 {
  static int n;
  static Queue<Integer> q = new LinkedList<>();
  static boolean[] visited;
  static List<List<Integer>> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    visited = new boolean[n + 1];

    list = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int friendA = Integer.parseInt(st.nextToken());
      int friendB = Integer.parseInt(st.nextToken());
      list.get(friendA).add(friendB);
      list.get(friendB).add(friendA);
    }

    if (list.get(1).size() == 0) {
      System.out.println(0);
    } else {
      inviteFriend();
      System.out.println(countInvitedFriend());
    }
  }

  private static int countInvitedFriend() {
    int count = -1;
    for (int i = 1; i < n + 1; i++) {
      if (visited[i]) {
        count++;
      }
    }

    return count;
  }

  private static void inviteFriend() {
    int check = 1;
    q.add(1);
    visited[1] = true;

    while (!q.isEmpty()) {
      if (check > 2) {
        break;
      }

      int stackSize = q.size();
      for (int i = 0; i < stackSize; i++) {
        int cur = q.poll();

        for (int j = 0; j < list.get(cur).size(); j++) {
          int next = list.get(cur).get(j);
          if (!visited[next]) {
            visited[next] = true;
            q.add(next);
          }
        }
      }

      check++;
    }
  }
}
