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
        TreeMap<Integer,Integer> tm = new TreeMap<>();

        ListNode temp = head;

        while(temp != null){
            int num = temp.val;
            tm.put(num,tm.getOrDefault(num , 0) + 1);
            temp = temp.next;
        }

        ArrayList<Integer> arr = new ArrayList<>();
       
        for(int num:tm.keySet()){

                    int count = tm.get(num);
            if(count < 2){
                arr.add(num);
            }
        }

        ListNode dummy = new ListNode(-1);

        ListNode prev = dummy;

        int len = arr.size();
        int i =0;
        while(len > 0){
            ListNode l = new ListNode(arr.get(i));
            prev.next = l;
            prev = prev.next;
            i++;
            len--;
        }

        return dummy.next;
    }
}