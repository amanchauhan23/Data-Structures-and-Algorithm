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
    public ListNode detectCycle(ListNode head) { // O(n) | O(1)
        ListNode slow = head;
        ListNode fast = head;
        
        boolean b = true;
        while(fast != null && fast.next != null){ // floyd's cycle detection
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                b = false;
                break;
            }
        }
        
        if(b)
            return null;
        
        slow = head;
        
        while(slow != fast){ // iterating with same speed
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}
