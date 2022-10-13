class Solution {
    public void deleteNode(ListNode node) { // O(n) || O(1)
        if(node.next.next != null){
            node.val = node.next.val;
            deleteNode(node.next);
        }else{
            node.val = node.next.val;
            node.next = null;
            return;
        }
    }
}
