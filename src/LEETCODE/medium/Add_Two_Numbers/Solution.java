package LeetCode.medium.Add_Two_Numbers;


public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode answer = new ListNode();
    ListNode result = answer;
    int sum = 0;

    while (l1 != null || l2 != null || sum > 0) {
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      int val = sum % 10;
      sum /= 10;
      ListNode temp = new ListNode(val);
      answer.next = temp;
      answer = answer.next;
    }

    return result.next;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
