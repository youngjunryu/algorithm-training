package Baekjoon._1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long S = Long.parseLong(br.readLine());

    int now = 1;
    int answer = 0;

    while (true) {
      if (S - now < now + 1) {
        answer++;
        break;
      }

      answer++;
      S -= now;
      now++;
    }

    System.out.println(answer);
  }
}
