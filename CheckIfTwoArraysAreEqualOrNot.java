class Solution{   // O(n) || O(n)
    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        HashMap<Long, Integer> hs1 = new HashMap<>();
        HashMap<Long, Integer> hs2 = new HashMap<>();
        
        for(long i : A) hs1.put(i, hs1.getOrDefault(i, 0) + 1);
        for(long i : B) hs2.put(i, hs2.getOrDefault(i, 0) + 1);
            
        return hs1.equals(hs2);
    }
}
