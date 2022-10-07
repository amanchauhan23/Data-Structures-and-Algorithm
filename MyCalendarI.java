class MyCalendar { // O(logn) || O(n)
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if(calendar.floorEntry(start) != null){
            int floorEnd = calendar.floorEntry(start).getValue();
            if(floorEnd > start) return false; 
        }
        if(calendar.ceilingEntry(start) != null){
            int ceilStart = calendar.ceilingEntry(start).getKey();
            if(ceilStart < end) return false; 
        }
        calendar.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
