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
    public ListNode rotateRight(ListNode head, int k) {

          
            if (head == null || head.next == null || k == 0) return head;
            
            
            int count = 0;

            ListNode temp = head;
            ListNode start = head;
            while(temp != null){
                count++;
                temp = temp.next;
            }

          k = k % count ;
          
          if (k == 0) return head;
            int rem = count - k - 1;
            temp = head;
           
            for(int i =0;i<rem;i++){
                temp = temp.next;
            }
            

            ListNode newNode = temp.next;
            ListNode newhead = temp.next;
            temp.next = null;
            
            while(newNode.next != null){
                newNode = newNode.next;
            }

            newNode.next = start;
            
            return newhead;
    }
}