class Solution {
    public int[] twoSum(int[] n, int target) { // O(n) | O(1)
        int [] ans = new int[2];
        int l = 0;
        int r = n.length-1;
        while(l<r){
            int sum = n[l] + n[r];
            if(sum<target){
                l++;
            }else if(sum > target){
                r--;
            }else{
                ans[0] = l+1;
                ans[1] = r+1;
                return ans;
            }
        }
        return ans;
    }
}
