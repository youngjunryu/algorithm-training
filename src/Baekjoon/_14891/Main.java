package Baekjoon._14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int[][] data = new int[4][8];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (int i = 0; i < 4; i++) {
      String line = br.readLine();
      for (int j = 0; j < 8; j++) {
        data[i][j] = line.charAt(j) - '0';
      }
    }

    int k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken()) - 1;
      int dir = Integer.parseInt(st.nextToken());
      process(idx, dir);
    }

    int result = 0;
    for (int i = 0; i < 4; i++) {
      result += Math.pow(2, i) * data[i][0];
    }
    System.out.println(result);
  }

  private static void process(int idx, int dir) {
    left(idx - 1, -dir);
    right(idx + 1, -dir);
    rotate(idx, dir);
  }

  private static void left(int idx, int dir) {
    if (idx < 0) return;

    if (data[idx][2] == data[idx + 1][6]) return;
    left(idx - 1, -dir);
    rotate(idx, dir);
  }

  static void right(int idx, int dir) {
    if(idx > 3) return;
    if(data[idx][6] == data[idx - 1][2]) return;
    right(idx + 1, -dir);
    rotate(idx, dir);
  }

  private static void rotate(int idx, int dir) {
    if (dir == 1) {
      int temp = data[idx][7];
      for (int i = 7; i > 0; i--) {
        data[idx][i] = data[idx][i - 1];
      }
      data[idx][0] = temp;
    } else {
      int temp = data[idx][0];
      for (int i = 0; i < 7; i++) {
        data[idx][i] = data[idx][i + 1];
      }
      data[idx][7] = temp;
    }
  }
}

/*
N극은 0, S극은 1

서로 맞닿은 톱니의 극이 같으면, 회전하지 않음
서로 맞닿은 톱니의 극이 다르다면, 반대방향으로 회전 == 톱니바퀴 A를 회전할 때, 톱니바퀴 B는 반대로 회전

방향이 1인 경우, 시계 방향 회전
방향이 -1인 경우, 반시계 방향 회전

idx 3과 idx 7이 맞닿는 부분

1번이 회전하면: 2번 -> 3번 -> 4번 확인
2번이 회전하면: 1번 확인, 3번 -> 4번 확인
3번이 회전하면: 2번 -> 1번 확인, 4번 확인
4번이 회전하면: 3번 -> 2번 -> 1번 확인
 */