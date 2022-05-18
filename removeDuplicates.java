public ListNode deleteDuplicates(ListNode head) { // O(N)
//         #1
//         if(head==null)
//             return head;
//         ListNode a = head;
//         while(a.next != null){
//             ListNode t = a.next;
//             while(a.val == t.val){
//                 t = t.next;
//                 if(t==null){
//                     a.next = null;
//                     return head;
//                 }
//                 continue;
//             }
//             a.next = t;
//             a = a.next;
//         }
//         return head;
        
//      #2
        ListNode t = head;
        while(t!=null){
            if(t.next==null)
                break;
            if(t.val==t.next.val)
                t.next= t.next.next;
            else
                t = t.next;
        }
        return head;
    }
