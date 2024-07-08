package Baekjoon._1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] switches = new int[n + 1];  // 스위치 상태를 저장할 배열

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      switches[i] = Integer.parseInt(st.nextToken());
    }

    int studentLen = Integer.parseInt(br.readLine());
    for (int i = 0; i < studentLen; i++) {
      st = new StringTokenizer(br.readLine());
      int sex = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());

      if (sex == 1) { // 남학생
        for (int j = num; j <= n; j += num) {
          switches[j] = switches[j] ^ 1; // 스위치 상태 반전
        }
      } else { // 여학생
        switches[num] = switches[num] ^ 1; // 주어진 위치 반전
        int left = num - 1;
        int right = num + 1;

        while (left >= 1 && right <= n && switches[left] == switches[right]) {
          switches[left] = switches[left] ^ 1; // 좌우 대칭 스위치 상태 반전
          switches[right] = switches[right] ^ 1;
          left--;
          right++;
        }
      }
    }

    printSwitches(switches);
  }

  private static void printSwitches(int[] switches) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < switches.length; i++) {
      sb.append(switches[i]).append(" ");
      if (i % 20 == 0) {
        sb.append("\n");
      }
    }
    System.out.print(sb.toString().trim()); // 마지막 공백 제거 및 출력
  }
}
