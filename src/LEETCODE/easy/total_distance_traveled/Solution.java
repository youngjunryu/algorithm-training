package LeetCode.easy.Total_distance_traveled;

class Solution {

  public int distanceTraveled(int mainTank, int additionalTank) {
    if (mainTank < 5) {
      return mainTank * 10;
    }

    int result = 0;
    while (mainTank >= 5) {
      result += 50;
      mainTank -= 5;
      if (additionalTank >= 1) {
        mainTank += 1;
        additionalTank -= 1;
      } else {
        break;
      }
    }

    result += mainTank * 10;
    return result;
  }
}
