class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n) // O(N) | auxSpace O(N)
    {
        HashSet<Integer> h = new HashSet<>(); // for prefixSum
        h.add(0);
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
            if(h.contains(sum)){
                return true;
            }else
            h.add(sum);
        }
        return false;
    }
}
