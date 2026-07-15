/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
         while (head != null && head.next != null && head.val == head.next.val) {
            int val = head.val;
            while (head != null && head.val == val) {
                head = head.next;
            }
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {

            if (curr.next != null && curr.val == curr.next.val) {
                int val = curr.val;

                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }

                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}