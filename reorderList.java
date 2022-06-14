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
    public void reorderList(ListNode head) { // O(n) | O(1)
        
        if(head == null || head.next == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode l = head;
        
        
        while(fast != null && fast.next != null){ // finding mid
            l = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        l.next = null; // separating two lists
        
        ListNode l2 = reverseList(slow); 
        
        merge(head, l2); 
        
    }
    
    public ListNode reverseList(ListNode head) {
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
    
    public void merge(ListNode l, ListNode r){
        
        while(l != null){
            
            ListNode l_next = l.next;
            ListNode r_next = r.next;
            
            l.next = r;
            if(l_next == null){
                break;
            }
            r.next = l_next;
            
            l = l_next;
            r = r_next;
            
        }
    }
    
}
