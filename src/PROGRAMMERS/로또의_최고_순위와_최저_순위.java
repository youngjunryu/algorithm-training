package PROGRAMMERS;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {
  public static int[] solution(int[] lottos, int[] win_nums) {
    int maxCnt = 0;
    int lowCnt = 0;
    int[] win = {6, 6, 5, 4, 3, 2, 1};

    Arrays.sort(win_nums);

    for (int l : lottos) {
      if (l == 0) {
        maxCnt++;
        continue;
      }

      int left = 0;
      int right = win_nums.length - 1;

      while (left <= right) {
        int mid = (left + right) / 2;

        if (win_nums[mid] == l) {
          maxCnt++;
          lowCnt++;
          break;
        } else if (win_nums[mid] > l) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }

    int[] answer = new int[2];

    answer[0] = win[maxCnt];
    answer[1] = win[lowCnt];

    return answer;
  }

  public static void main(String[] args) {
    solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
  }
}
