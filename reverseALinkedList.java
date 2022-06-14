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
    public ListNode reverseList(ListNode head) { // O(n)
        if(head == null)
            return null;
        ListNode t = head;
        ListNode temp = null;
        while(t!=null && t.next != null){
            ListNode next = t.next;
            t.next = temp;
            temp = t;
            t = next;
        }
        t.next = temp;
        return t;
    }
}
