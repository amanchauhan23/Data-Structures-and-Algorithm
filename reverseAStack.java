class Solution
{ 
    static ArrayList<Integer> ls = new ArrayList<>();
    static ArrayList<Integer> reverse(Stack<Integer> s)
    {
        // #1 | O(n) | O(1)
        // ArrayList<Integer> ls = new ArrayList<>();
        // while(!s.isEmpty()){
        //     ls.add(s.pop());
        // }
        // return ls;
         
        // #2 recursive | O(n) | O(n)
        ArrayList<Integer> ls = new ArrayList<>();
        ans(s, ls);
        return ls;
    }
    
    static void ans(Stack<Integer> s,  ArrayList<Integer> a){
        if(s.isEmpty()){
            return;
        }
        a.add(s.pop());
        ans(s, a);
        return;
    }
    
    
}
