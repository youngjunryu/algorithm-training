package Baekjoon._2816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] k = new int[2];

    for (int i = 0; i < N; i++) {
      String channel = br.readLine();
      if (channel.equals("KBS1")) {
        k[0] = i;
      } else if (channel.equals("KBS2")) {
        k[1] = i;
      }
    }

    // kbs2, kbs1 순서이면 kbs1이 올라가면서 kbs2를 아래로 한칸 내린다
    if (k[0] > k[1]) {
      k[1]++;
    }
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < k[i]; j++) {
        System.out.print("1");
      }
      if (i == 1) {
        k[1]--;
      }
      for (int j = 0; j < k[i]; j++) {
        System.out.print("4");
      }
    }

  }

}