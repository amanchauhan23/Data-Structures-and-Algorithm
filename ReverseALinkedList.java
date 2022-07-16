class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head) // O(N)
    {
        // code here
        if(head == null)
            return null;
        
        Node prev = null;
        while(head.next != null){
            Node nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        head.next = prev;
        return head;
    }
}
