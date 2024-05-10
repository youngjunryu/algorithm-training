package Programmers.lv2.숫자_카드_나누기;

import java.util.Arrays;

class Solution {

  public int solution(int[] arrayA, int[] arrayB) {
    int aGcd = getGcd(arrayA, arrayB);
    int bGcd = getGcd(arrayB, arrayA);

    if (aGcd == 0 && bGcd == 0) {
      return 0;
    }

    return Math.max(aGcd, bGcd);
  }

  public int getGcd(int[] arr, int[] arr2) {
    Arrays.sort(arr);

    int num = arr[0];

    while (num > 0) {
      boolean flag = true;

      for (int a : arr) {
        if (a % num != 0) {
          flag = false;
          break;
        }
      }

      if (!flag) {
        num--;
      } else {
        if (checkArr(num, arr2)) {
          break;
        } else {
          num--;
        }
      }
    }

    return num;
  }

  private boolean checkArr(int num, int[] arr2) {
    for (int a : arr2) {
      if (a % num == 0) {
        return false;
      }
    }
    return true;
  }
}
