package LeetCode.medium.Gas_Station;

class Solution2 {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int gasSum = 0;
    int costSum = 0;

    for (int i = 0; i < n; i++) {
      gasSum += gas[i];
      costSum += cost[i];
    }

    if (gasSum < costSum) {
      return -1;
    }

    int i = 0;
    boolean flag = true;
    for (; i < n && flag; ) {
      int val = gas[i];

      int idx = i;
      int next = -1;

      while (true) {
        if (val - cost[idx] < 0) {
          i = (idx + 1) % n;
          break;
        }

        next = (idx + 1) % n;

        if (next == i) {
          flag = false;
          break;
        }

        val = val - cost[idx] + gas[next];
        idx = next;
      }
    }

    return i;
  }
}
