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
    public ListNode removeElements(ListNode head, int val) {  // O(n) || O(1)
        ListNode h = head;
        while(head != null && head.val == val){
            h = head.next;
            head = head.next;
        }
        if(head == null) return null;

        while(head.next != null){
            if(head.next.val == val)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return h;
    }
}
