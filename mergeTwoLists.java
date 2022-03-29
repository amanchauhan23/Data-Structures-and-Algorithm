class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class mergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head = (list1.val > list2.val) ? list2 : list1;
        ListNode a = head.next;
        ListNode b = (list1.val > list2.val) ? list1 : list2;
        ListNode tail = head;
        while (a != null && b != null) {
            if (b.val > a.val) {
                tail.next = a;
                tail = a;
                a = a.next;
            } else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        if (a == null)
            tail.next = b;
        else
            tail.next = a;

        return head;

        // if (list1 == null)
        //     return list2;
        // if (list2 == null)
        //     return list1;

        // ListNode head;

        // if (list1.val < list2.val) {
        //     head = list1;
        //     head.next = mergeTwoLists(list1.next, list2);
        // } else {
        //     head = list2;
        //     head.next = mergeTwoLists(list1, list2.next);
        // }

        // return head;

    }
}
