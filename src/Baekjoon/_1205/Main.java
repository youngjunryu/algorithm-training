package Baekjoon._1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int newPoint = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    if (N == 0) {
      System.out.println("1");
      return;
    }

    st = new StringTokenizer(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    list.sort(Collections.reverseOrder());

    if (list.size() >= P && list.get(P - 1) >= newPoint) {
      System.out.println("-1");
    } else {
      int rank = 1;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i) > newPoint) {
          rank++;
        } else {
          break;
        }
      }

      System.out.println(rank);
    }
  }
}
