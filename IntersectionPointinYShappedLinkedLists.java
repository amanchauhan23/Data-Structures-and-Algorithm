class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2) // O(n) | O(1)
	{
         // code here
         Node one = head1;
         Node two = head2;
         
         while(one != two){
             one = one.next;
             two = two.next;
             if(one == null) // setting to other list's head, so as to remove the difference in lengths of two list
                 one = head2;
             if(two == null)
                two = head1;
         }
         return one.data;
	}
}
