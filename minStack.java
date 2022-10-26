class MinStack { // #1 || Naive
    private ArrayList<Integer> array = new ArrayList<>();
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    public MinStack() { }

    public void push(int val) {
        minHeap.add(val);
        array.add(val);
    }

    public void pop() {
        if(array.isEmpty()){
            return;
        }
        minHeap.remove(top());
        array.remove(array.size()-1);
    }

    public int top() {
        return array.get(array.size()-1);
    }

    public int getMin() {
        return minHeap.peek();}
}

// #2 || O(1) 
class MinStack {

    Stack<Integer> stk;
    Stack<Integer> monoStk;
    
    public MinStack() {
        stk = new Stack<>();
        monoStk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(monoStk.size() < 1 || val < monoStk.peek())
            monoStk.push(val);
        else
            monoStk.push(monoStk.peek());
    }
    
    public void pop() {
        monoStk.pop();
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return monoStk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
