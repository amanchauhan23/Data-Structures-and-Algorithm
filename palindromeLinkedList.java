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
    public boolean isPalindrome(ListNode head) {
        
        // #1
        //StringBuffer sb = new StringBuffer("");
        //while(head!=null){
        //    sb.append(String.valueOf(head.val));
        //    head = head.next;
        //}
        //return sb.toString().equals(sb.reverse().toString());
        
        // #2 optimized
        if(head == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null){ // even
              ListNode reversed = reverseList(slow);
            while(reversed!=null){
                if(head.val != reversed.val)
                    return false;
                reversed = reversed.next;
                head = head.next;
            }
        }else{ // odd
            ListNode reversed = reverseList(slow);
            while(reversed!=null){
                if(head.val != reversed.val)
                    return false;
                reversed = reversed.next;
                head = head.next;
            }
        }
        return true;
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
        ListNode tt = t;
        return t;
    }
    
}
