package Programmers.PCCP1.유전법칙;

class Solution {
  public String[] solution(int[][] queries) {
    String[] answer = new String[queries.length];
    int idx = 0;
    for (int[] q : queries) {
      answer[idx++] = bean(q[0], q[1]);
    }

    return answer;
  }

  public String bean(int generation, int order) {
    if (generation == 1) {
      return "Rr";
    }

    String parent = bean(generation - 1, (order - 1) / 4 + 1);

    if (parent.equals("RR") || parent.equals("rr")) {
      return parent;
    }

    if (order % 4 == 0) {
      return "rr";
    } else if (order % 4 == 1) {
      return "RR";
    } else {
      return "Rr";
    }
  }
}
