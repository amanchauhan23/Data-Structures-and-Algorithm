// class MyStack { // #1 here push is O(n) 

//     int size;
//     Queue<Integer> q1;
//     Queue<Integer> q2;
    
//     public MyStack() {
        
//         q1 = new LinkedList<>();
//         q2 = new LinkedList<>();
        
//     }
    
//     public void push(int x) { // O(n)
        
//         while(!q1.isEmpty()){
//             q2.offer(q1.poll());
//         }
//         q1.offer(x);
//         while(!q2.isEmpty()){
//             q1.offer(q2.poll());
//         }
        
//     }
    
//     public int pop() { // O(1)
        
//         if(q1.isEmpty())
//             return -1;
//         return q1.poll();        
//     }
    
//     public int top() { // O(1)
        
//         if(q1.isEmpty())
//             return -1;
//         return q1.peek();
        
//     }
    
//     public boolean empty() { // O(1)
        
//         return q1.isEmpty();
        
//     }
// }



/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
