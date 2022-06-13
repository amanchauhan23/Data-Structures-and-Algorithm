class MyCircularQueue {

    int [] list;
    int l = 0;
    int r = -1;
    int size = 0;
    int k;
    
    public MyCircularQueue(int k) {
        list = new int[k];
        this.k = k;
        
    }
    
    public boolean enQueue(int value) {
        
        if(size == k)
            return false;
        ++r;
        if(r%k == 0){
            r = r%k;
        }
        size++;
        list[r] = value;
        return true;
        
    }
    
    public boolean deQueue() {
        
        if(size == 0)
            return false;
        l++;
        if(l%k == 0){
            l = l%k;
        }
        size--;
        return true;
        
    }
    
    public int Front() {
        
        if(size == 0)
            return -1;
        return list[l];
        
    }
    
    public int Rear() {
        if(size == 0)
            return -1;
        return list[r];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
