package Archiving.PROGRAMMERS;

import java.util.*;

class 인사고과 {
  public static int solution(int[][] scores) {
    int answer = 0;
    int a = scores[0][0];
    int b = scores[0][1];
    Arrays.sort(scores, (o1, o2) -> (o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]));

    int k = scores[0][1];

    for(int[] score : scores){
      if(k > score[1]){
        if(a == score[0] && b == score[1]) {
          answer = -1;
          return answer;
        }
        score[0] = -1;
        score[1] = -1;
      }else{
        k = score[1];
      }
    }

    Arrays.sort(scores, Comparator.comparingInt(o -> -(o[0] + o[1])));
    for (int i = 0; i < scores.length; i++) {
      if (scores[i][0] == a && scores[i][1] == b) {
        answer = i + 1;
        break;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[][]{{2, 1}, {1, 4}, {3, 2}, {3, 2}, {2, 2}}));
  }
}
