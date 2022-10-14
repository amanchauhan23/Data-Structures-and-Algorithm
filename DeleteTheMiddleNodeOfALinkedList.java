class Solution {
    public ListNode deleteMiddle(ListNode head) { // O(n) || O(1) 
        if(head == null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = dummy;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
