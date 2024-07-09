package Baekjoon._20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    LinkedList<Integer> belt = new LinkedList<>();
    LinkedList<Boolean> robots = new LinkedList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 2 * N; i++) {
      int A = Integer.parseInt(st.nextToken());
      belt.add(A);
      robots.add(false); // 로봇이 없는 상태로 초기화
    }

    int step = 0;
    int sum = 0;

    while (true) {
      step++;

      // 1. 벨트 회전
      belt.addFirst(belt.removeLast());
      robots.addFirst(robots.removeLast());

      // N 위치에 있는 로봇은 즉시 내림
      if (robots.get(N - 1)) {
        robots.set(N - 1, false);
      }

      // 2. 로봇 이동
      for (int i = N - 2; i >= 0; i--) {
        if (robots.get(i) && !robots.get(i + 1) && belt.get(i + 1) > 0) {
          robots.set(i, false);
          robots.set(i + 1, true);
          belt.set(i + 1, belt.get(i + 1) - 1);
          if (belt.get(i + 1) == 0) {
            sum++;
          }
        }
      }

      // N 위치에 있는 로봇은 즉시 내림
      if (robots.get(N - 1)) {
        robots.set(N - 1, false);
      }

      // 3. 로봇 올리기
      if (belt.get(0) > 0) {
        robots.set(0, true);
        belt.set(0, belt.get(0) - 1);
        if (belt.get(0) == 0) {
          sum++;
        }
      }

      // 4. 내구도가 0인 칸의 수가 K개 이상이면 종료
      if (sum >= K) {
        break;
      }
    }

    System.out.println(step);
  }
}
