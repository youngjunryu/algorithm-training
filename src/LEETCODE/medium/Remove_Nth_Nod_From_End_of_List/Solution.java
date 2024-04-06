package LeetCode.medium.Remove_Nth_Nod_From_End_of_List;

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode temp = new ListNode();
    temp.next = head;
    ListNode start = temp;
    ListNode end = temp;

    for (int i = 0; i < n; i++) {
      end = end.next;
    }

    while (end.next != null) {
      start = start.next;
      end = end.next;
    }

    start.next = start.next.next;

    return temp.next;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}