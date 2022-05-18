public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode a = head;
        while(a.next != null){
            ListNode t = a.next;
            while(a.val == t.val){
                t = t.next;
                if(t==null){
                    a.next = null;
                    return head;
                }
                continue;
            }
            a.next = t;
            a = a.next;
        }
        return head;
    }
