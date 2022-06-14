/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) { // O(n) | O(1)
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){ // floyd's cycle detection
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)
                return true;
        }
        
        return false;
        
    }
}
