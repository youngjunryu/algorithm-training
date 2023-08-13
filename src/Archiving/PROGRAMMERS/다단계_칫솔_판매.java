package Archiving.PROGRAMMERS;

import java.util.Arrays;
import java.util.HashMap;

public class 다단계_칫솔_판매 {
  static class Node {
    private String name;
    private String ref;
    private int sum = 0;

    public Node(String name, String ref) {
      this.name = name;
      this.ref = ref;
    }

    public void updateSum(int val) {
      sum += val;
    }

    public int getSum() {
      return sum;
    }
  }

  static int n;
  static HashMap<String, Node> map;

  public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    init(enroll, referral);
    aggregate(seller, amount);

    return getAnswer(enroll);
  }

  private static int[] getAnswer(String[] enroll) {
    int[] answer = new int[n];
    int i = 0;

    for (String name : enroll) {
      Node n = map.get(name);
      answer[i++] = n.getSum();
    }

    return answer;
  }

  private static void aggregate(String[] seller, int[] amount) {
    for (int i = 0; i < seller.length; i++) {
      int val = amount[i] * 100;
      Node profitGetter = map.get(seller[i]);
      while (true) {
        if (val * 0.1 < 1) {
          profitGetter.updateSum(val);
          break;
        }

        profitGetter.updateSum((int)Math.ceil(val * 0.9));
        val = (int)(val * 0.1);

        if (profitGetter.ref == null) {
          break;
        }

        profitGetter = map.get(profitGetter.ref);
      }
    }
  }

  private static void init(String[] enroll, String[] referral) {
    n = enroll.length;
    map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String name = enroll[i];
      String ref = referral[i].equals("-") ? null : referral[i];
      map.put(name, new Node(name, ref));
    }
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(solution(
            new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
            new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
            new String[]{"young", "john", "tod", "emily", "mary"},
            new int[]{12, 4, 2, 5, 10})));
  }
}
