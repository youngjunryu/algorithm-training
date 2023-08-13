package Archiving.LEETCODE;

public class Merge_Two_Sorted_Lists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode();
    ListNode tail = head;

    while (list1 != null || list2 != null) {
      if (list2 == null || (list1 != null && list1.val < list2.val)) {
        tail.next = list1;
        tail = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        tail = list2;
        list2 = list2.next;
      }
    }

    return head.next;
  }

  public static class ListNode {
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
}
