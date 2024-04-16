package Programmers.lv1.붕대_감기;

class Solution {

  public int solution(int[] bandage, int health, int[][] attacks) {
    int t = bandage[0];
    int x = bandage[1]; // 1초마다 x만큼 회복
    int y = bandage[2]; // t초 연속으로 성공시 y만큼 회복

    int result = health;
    int time = 0;
    int idx = 0;
    for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
      if (i == attacks[idx][0]) {
        time = 0;
        result -= attacks[idx++][1];
        if (result <= 0) {
          return -1;
        }
        continue;
      }

      result += x;
      time++;
      if (time == t) {
        result += y;
        time = 0;
      }

      if (result > health) {
        result = health;
      }
    }

    return result;
  }
}
