package LeetCode.contest.weekly_360.Furthest_Point_From_Origin;

public class Solution {
  public int furthestDistanceFromOrigin(String moves) {
    int lCnt = 0, rCnt = 0, sCnt = 0;
    for (int i = 0; i < moves.length(); i++) {
      if (moves.charAt(i) == 'L') {
        lCnt++;
      } else if (moves.charAt(i) == 'R') {
        rCnt++;
      } else {
        sCnt++;
      }
    }

    int result = 0;
    if (lCnt > rCnt) {
      return lCnt - rCnt + sCnt;
    } else if (rCnt > lCnt) {
      return rCnt - lCnt + sCnt;
    } else {
      return sCnt;
    }
  }
}
