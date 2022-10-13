class Solution {
    public ListNode swapNodes(ListNode head, int k) { // O(n) || O(1)
        if(head == null) return null;
        ListNode res = head;
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        ListNode fast = head;
        
        for(int i = 0; i < k - 1; i++) pointer1 = pointer1.next;

        for(int i = 0; i < k; i++) fast = fast.next;
        while(fast != null){
            fast = fast.next;
            pointer2 = pointer2.next;
        }

        int temp = pointer1.val;
        pointer1.val = pointer2.val;
        pointer2.val = temp;
        
        return res;
    }
}

