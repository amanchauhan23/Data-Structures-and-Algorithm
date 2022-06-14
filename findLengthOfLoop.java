/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

//Function should return the length of the loop in LL.

class Solution
{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head) // O(n) | O(1)
    {
        //Add your code here.
        Node slow = head;
        Node fast = head;
        
        boolean b = true;
        while(fast != null && fast.next != null){ // floyd's cycle detection
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                b = false;
                break;
            }
        }
        
        if(b)
            return 0;
        
        slow = head;
        
        int c = 0;
        while(slow != fast){ // iterating with same speed
            slow = slow.next;
            fast = fast.next;
        }
        Node count = slow.next;
        while(slow != count){
            c++;
            count  = count.next;
        }
        return c + 1;
        
    }
}
