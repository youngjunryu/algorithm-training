package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ15686 {
  static int N, M;
  static ArrayList<int[]> houses;
  static ArrayList<int[]> chickens;
  static LinkedList<int[]> selectedChickens;
  static boolean[] visited;
  static int totalMin = 100000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    houses = new ArrayList<>();
    chickens = new ArrayList<>();
    selectedChickens = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int num = Integer.parseInt(st.nextToken());
        if (num == 2) {
          chickens.add(new int[]{i, j});
          continue;
        } else if (num == 1) {
          houses.add(new int[]{i, j});
        }
      }
    }

    visited = new boolean[chickens.size()];
    selectChicken(0, 0);
    System.out.println(totalMin);
  }

  private static void selectChicken(int start, int count) {
    if (count == M) {
      getChickenDistance();
      return;
    }

    for (int i = start; i < chickens.size(); i++) {
      if (!visited[i]) {
        selectedChickens.add(new int[]{chickens.get(i)[0], chickens.get(i)[1]});
        visited[i] = true;
        selectChicken(i + 1, count + 1);
        visited[i] = false;
        selectedChickens.removeLast();
      }
    }
  }

  private static void getChickenDistance() {
    int total = 0;
    for (int[] house : houses) {
      int min = 100000;
      for (int[] chicken : selectedChickens) {
        min = Math.min(Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]), min);
      }
      total += min;
    }

    totalMin = Math.min(total, totalMin);
  }
}
