class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) // O(n) | O(n)
    { 
        long ans[] = new long[n];
        Stack<Long> s = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--){
            if(s.isEmpty()){
                ans[i] = -1;
            }else{
                while(!s.isEmpty() && arr[i]>=s.peek()){
                    s.pop();
                }
                if(s.isEmpty()){
                    ans[i] = -1;
                }else{
                    ans[i] = s.peek();
                }
            }
             s.push(arr[i]);
        }
        return ans;
    } 
    
}
