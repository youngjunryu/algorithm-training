package Programmers.lv2.마법의_엘리베이터;

class Solution {
  public int solution(int storey) {
    int answer = 0;

    while (storey > 0) {
      int n = storey % 10;
      storey /= 10;

      if (n > 5) {
        answer += 10 - n;
        storey += 1;
      } else if (n < 5) {
        answer += n;
      } else if (storey % 10 >= 5) {
        answer += 10 - n;
        storey += 1;
      } else {
        answer += n;
      }
    }

    return answer;
  }
}

