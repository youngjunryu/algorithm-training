package Archiving.PROGRAMMERS;

public class 다트게임 {
  public static int solution(String dartResult) {
    int idx = 0;
    StringBuilder sb;
    int num;
    int[] score = new int[3];
    int step = 0;

    while (idx < dartResult.length()) {
      sb = new StringBuilder();
      char c = dartResult.charAt(idx++);
      sb.append(c);
      if (idx < dartResult.length() && dartResult.charAt(idx) - '0' == 0) {
        sb.append(dartResult.charAt(idx));
        idx++;
      }

      num = Integer.parseInt(sb.toString());
      num = (int) calculateBonus(num, dartResult.charAt(idx++));

      if (idx < dartResult.length() && (dartResult.charAt(idx) == '*' || dartResult.charAt(idx) == '#')) {
        char c2 = dartResult.charAt(idx++);
         if (c2 == '#') {
           num *= -1;
         } else {
          if (step != 0) {
            score[step - 1] *= 2;
          }
          num *= 2;
         }
      }

      score[step++] = num;
    }

    int answer = 0;
    for (int i = 0; i < 3; i++) {
      answer += score[i];
    }

    return answer;
  }

  public static double calculateBonus(int num, char bonus) {
    switch (bonus) {
      case 'S':
        return Math.pow(num, 1);
      case 'D':
        return Math.pow(num, 2);
      case 'T':
        return Math.pow(num, 3);
    }

    return -1;
  }

  public static void main(String[] args) {
    solution("1D2S0T");
  }
}
