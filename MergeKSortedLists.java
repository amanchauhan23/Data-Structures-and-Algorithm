class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for(ListNode nodes : lists)
            if(nodes != null)
                pq.offer(nodes);
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode pop = pq.poll();
            curr.next = pop;
            curr = pop;
            if(pop.next != null)
                pq.offer(pop.next);
        }
        return dummy.next;
    }
}
