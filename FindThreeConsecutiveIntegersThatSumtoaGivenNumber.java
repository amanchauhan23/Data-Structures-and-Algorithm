class Solution {
    public long[] sumOfThree(long num) { // O(logn)
        long start = -1;
        long end = num/3;
        
        while(start <= end){
            long mid = start + (end - start)/2;
            long sum = mid + mid + 1 + mid + 2;
            if(sum == num){
                long ans[] = {mid, mid + 1, mid + 2};
                return ans;
            }
            if(sum > num){
                end = mid -1;
            }else
                start = mid + 1;
        }
        return new long[0];
        
    }
}
