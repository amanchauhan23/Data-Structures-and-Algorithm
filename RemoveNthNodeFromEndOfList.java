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
class Solution { // O(n) | O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) { // differnce between slow and fast is n, we take slow from dummy node  
        if(head == null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode res = dummy;
        ListNode fast = head;
        for(int i = 0; i < n; i++)
            fast = fast.next;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
