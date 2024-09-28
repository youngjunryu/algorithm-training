package Baekjoon._2166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());  // 다각형의 꼭짓점 개수
    long[] x = new long[N + 1];  // x 좌표 저장 배열
    long[] y = new long[N + 1];  // y 좌표 저장 배열

    // 좌표 입력받기
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      x[i] = Long.parseLong(st.nextToken());
      y[i] = Long.parseLong(st.nextToken());
    }

    // 마지막 점을 첫 번째 점과 동일하게 만들어줌 (닫힌 다각형)
    x[N] = x[0];
    y[N] = y[0];

    // 신발끈 공식 적용
    long sum1 = 0;  // x_i * y_(i+1)
    long sum2 = 0;  // y_i * x_(i+1)

    for (int i = 0; i < N; i++) {
      sum1 += x[i] * y[i + 1];
      sum2 += y[i] * x[i + 1];
    }

    // 절댓값을 취하고 2로 나누어 면적 계산
    double area = Math.abs(sum1 - sum2) / 2.0;

    // 소수점 첫째 자리까지 출력
    System.out.printf("%.1f\n", area);
  }
}

