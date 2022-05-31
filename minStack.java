class MinStack { // #1
     Stack<Integer> st;
    Stack<Integer> minst;
    public MinStack() {
        st = new Stack<Integer>();
        minst = new Stack<Integer>();
    }
    
    public void push(int val) {
         st.push(val);
        if(minst.size()==0 || getMin()>=val)
            minst.push(val);
    }
    
    public void pop() {
        if(getMin()==st.pop())
            minst.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}

class MinStack { // #2
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

